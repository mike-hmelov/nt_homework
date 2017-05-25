package home.mike.phoneresolver.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public abstract class WikiPageDownloader {
    @Value("${phoneresolver.wiki_page_web_address:https://en.wikipedia.org/wiki/List_of_country_calling_codes}")
    protected String wikiPageWebAddress;

    @Autowired
    private WikiPageContentsWrapperFactory wikiPageContentsWrapperFactory;

    public WikiPageContentsWrapper download() {
        try {
            Object data = doDownload();
            return wikiPageContentsWrapperFactory.wrap(data);
        } catch (Exception e) {
            throw new WikiPageDownloadException("Failed to download country codes data", e);
        }
    }

    protected abstract Object doDownload() throws Exception;
}
