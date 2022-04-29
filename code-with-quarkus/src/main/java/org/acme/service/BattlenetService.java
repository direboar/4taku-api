package org.acme.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.acme.entity.Hero;
import org.jboss.logging.Logger;

import io.quarkus.oidc.client.OidcClient;
import io.quarkus.oidc.client.Tokens;

@ApplicationScoped
public class BattlenetService {
    @Inject
    OidcClient client;

    private static final Logger LOG = Logger.getLogger(BattlenetService.class);

    volatile Tokens currentTokens;

    @PostConstruct
    public void init() {
        currentTokens = client.getTokens().await().indefinitely();
        LOG.info("token : " + currentTokens.getAccessToken());
    }

    @Transactional
    public List<Hero> getHeros() {
        if (this.currentTokens.isAccessTokenExpired()) {
            // Add @Blocking method annotation if this code is used with Reactive RestClient
            this.currentTokens = client.refreshTokens(this.currentTokens.getRefreshToken()).await().indefinitely();
        }

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(
                "https://us.api.blizzard.com/hearthstone/cards?:region=us&gameMode=battlegrounds&tier=hero&pageSize=1000");

        try (Response response = target.request()
                .header("Authorization", "Bearer " + this.currentTokens.getAccessToken())
                .get();) {

            // FIXME 型変換 本当はBeanにマッピングしたいが、属性が不足しているBeanにデフォルトの動作ではマッピングできない。
            //       やり方がどこかに転がっていたので探す？
            Object o = response.readEntity(HashMap.class).get("cards");

            if (o instanceof List) {
                List<Map<String, Object>> value = List.class.cast(o);
                return value.stream().map(this::toHero).filter(item -> {
                    return item != null;
                }).collect(Collectors.toList());
            }
            return null;
        }
    }

    private Hero toHero(Object item) {
        if (item instanceof Map) {
            // TODO REST APIの不完全なオブジェクトでもあったほうが楽？
            Map<String, ?> map = Map.class.cast(item);
            Integer id = (Integer) map.get("id");
            Map<String, String> name = (Map) map.get("name");
            Map<String, String> image = (Map) map.get("image");
            return new Hero(id, name.get("en_US"), name.get("ja_JP"), image.get("ja_JP"),false);
        } else {
            return null;
        }
    }

    // @Transactional
    // public Gift getHoge() throws Exception {
    //     Client client = ClientBuilder.newBuilder().build();
    //     WebTarget target = client.target(
    //             "http://localhost:8080/santa/get");
    //     Response response = target.request()
    //             .header("Authorization", "Bearer " + this.currentTokens.getAccessToken())
    //             .accept(MediaType.APPLICATION_JSON)
    //             .get();
    //     // String value = response.readEntity(String.class);
    //     // LOG.info(value);
    //     // Map<String, String> map = this.mapper.readValue(value, HashMap.class);
    //     // MyGift gift = response.readEntity(MyGift.class);
    //     // LOG.info(gift.name);
    //     Gift gift = response.readEntity(Gift.class);

    //     return gift;
    //     // TODO call battlenet api with jax-rs api.
    //     // return null;
    // }
}

// class MyGift{
//     String name;
// }

// class BattlenetGetHeroResponse{
//     private List<BattlenetCard> cards ;
// }

// class BattlenetCard{
//     private int id;
//     private BattlenetCardName name;
//     private BattlenetCardImage image;

// }

// class BattlenetCardName{
//     private String en_US;
//     private String ja_JP;
// }

// class BattlenetCardImage{
//     private String ja_JP;
// }

// class GiftModel {
//     private Long id;
//     private String name;

//     GiftModel() {

//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }
// }
