package eu.haktes.clebo_t.bots;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import eu.haktes.clebo_t.Bot;

public class BotTesterCsv
    extends
    Bot {

    private static final Logger LOG =
        (Logger) LogManager.getLogger(BotTesterCsv.class);

    public void start() {

        LOG.info("csv BOT started");

        getProperties();
        startDriver();

        // test csv here

        try {
            Thread.sleep(1000);
            LOG.info("exit in 10");
            Thread.sleep(1000);
            LOG.info("exit in 9");
            Thread.sleep(1000);
            LOG.info("exit in 8");
            Thread.sleep(1000);
            LOG.info("exit in 7");
            Thread.sleep(1000);
            LOG.info("exit in 6");
            Thread.sleep(1000);
            LOG.info("exit in 5");
            Thread.sleep(1000);
            LOG.info("exit in 4");
            Thread.sleep(1000);
            LOG.info("exit in 3");
            Thread.sleep(1000);
            LOG.info("exit in 2");
            Thread.sleep(1000);
            LOG.info("exit in 1");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeDriver();
        quitDriver();

    }

}
