package yontaku.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.jboss.logging.Logger;

import yontaku.entity.MinderRanking;
import yontaku.entity.MinderRankingDetail;

@ApplicationScoped
public class MinderRankingService {
    private static final Logger LOG = Logger.getLogger(BattlenetService.class);

    @Transactional
    public List<MinderRanking> getMinderRanking() {
        String csv = this.getRankingCSV();
        return this.parse(csv);
    }

    private String getRankingCSV() {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(
                "https://docs.google.com/spreadsheets/d/1Pis44oSp3jXylJnF6Xd55m_ZnWP7pNcmWhpW56CvWM4/gviz/tq?tqx=out:csv&sheet=Heroes");

        try (Response response = target.request()
                .get();) {

            // FIXME 型変換 本当はBeanにマッピングしたいが、属性が不足しているBeanにデフォルトの動作ではマッピングできない。
            // やり方がどこかに転がっていたので探す？
            return response.readEntity(String.class);
        }
    }

    private List<MinderRanking> parse(String csv) {
        try {
            Reader reader = new StringReader(csv);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);

            // 先頭2行を無視
            Iterator<CSVRecord> iterator = records.iterator();
            for (int i = 0; i < 2; i++) {
                iterator.next();
            }

            Map<String, Integer> metaData = this.parseHeader(iterator.next());
            List<MinderRanking> retVal = new ArrayList<>();
            iterator.forEachRemaining(record -> {
                retVal.add(this.parse(record, metaData));
            });
            return retVal;
        } catch (IOException e) {
            throw new RuntimeException("parse error", e);
        }
    }

    private Map<String, Integer> parseHeader(CSVRecord record) {
        Map<String, Integer> map = new HashMap<>();
        int col = 6;
        while (true) {
            String val = record.get(col);
            if (val.isBlank()) {
                break;
            }
            map.put(val, col);
            col++;
        }
        return map;
    }

    private MinderRanking parse(CSVRecord record, Map<String, Integer> metaData) {
        // "Akazamzarak","C","4.2","Slow Rafaam Curve","Rafaam
        // Curve","Link","Helpful","Helpful","Irrellevant","Irrellevant","Irrellevant","Helpful","Irrellevant","Irrellevant","Avoid","","","","","","","","","","",""
        MinderRanking minderRanking = new MinderRanking();
        minderRanking.setHeroName(record.get(0));
        minderRanking.setRanking(record.get(1));
        minderRanking.setCoinCurve1(record.get(3));
        minderRanking.setCoinCurve2(record.get(4));

        List<MinderRankingDetail> details = new ArrayList<>();
        minderRanking.setDetails(details);
        Map<String, String> rankingPerMinionType = new HashMap<>();
        metaData.entrySet().forEach(kv -> {
            MinderRankingDetail detail = new MinderRankingDetail();
            detail.setMinionType(kv.getKey());
            detail.setRanking(record.get(kv.getValue()));
            details.add(detail);
        });

        return minderRanking;
    }

}
