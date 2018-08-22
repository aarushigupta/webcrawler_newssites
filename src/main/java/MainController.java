
import edu.uci.ics.crawler4j.crawler.CrawlController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;


public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);



    public static void main(String[] args) throws Exception {

        String crawlStorageFolder = "data/";

        int numberOfCrawlers = 2;

        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(crawlStorageFolder);

        config.setPolitenessDelay(300);
        config.setMaxDepthOfCrawling(2);
        config.setMaxPagesToFetch(20);
        config.setIncludeBinaryContentInCrawling(false);
        config.setResumableCrawling(false);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("http://aarushigupta.info/");

        controller.start(Crawler.class, numberOfCrawlers);
    }

}
