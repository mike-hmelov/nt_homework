package home.mike.phoneresolver.jsoup;

import home.mike.phoneresolver.data.WikiPageDownloader;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

@Component
public class WikiPageDownloaderJsoup extends WikiPageDownloader {

    protected Object doDownload() throws Exception {
        return Jsoup.connect(wikiPageWebAddress).get();
    }
}
