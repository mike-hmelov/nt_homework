package home.mike.phoneresolver.data

import spock.lang.Specification
import spock.lang.Subject

class WikiPageDownloaderShould extends Specification {
    @Subject
    WikiPageDownloader downloader

    def 'fail download with specific exception'() {
        setup:
        downloader = new WikiPageDownloader() {
            @Override
            protected Object doDownload() throws Exception {
                throw new IOException("Error");
            }
        }
        when:
        downloader.download()
        then:
        def ex = thrown(WikiPageDownloadException)
        ex.message == 'Failed to download country codes data'
        ex.cause instanceof IOException
        ex.cause.message == 'Error'
    }
}
