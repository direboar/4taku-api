package yontaku.batch;

import javax.inject.Inject;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;

@QuarkusMain
// @TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = { UpdateHeroCommand.class,GetMinderRankingCommand.class})
public class MainCommand implements QuarkusApplication {
    @Inject
    CommandLine.IFactory factory; 

    @Override
    public int run(String... args) throws Exception {
        return new CommandLine(this, factory).execute(args);
    }

}
