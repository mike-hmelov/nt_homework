package home.mike.phoneresolver.jsoup

import org.jsoup.nodes.Document
import spock.lang.Specification
import spock.lang.Subject

class WikiPageContentsWrapperJsoupShould extends Specification {
    @Subject
    WikiPageContentsWrapperJsoup wrapper = new WikiPageContentsWrapperJsoup()

    def 'handle correct data type'() {
        expect:
        wrapper.canHandle(type) == result
        where:
        type           | result
        Mock(Document) | true
        'hello'        | false
        null           | false
    }

    def "save document data and return it self"() {
        def document = Mock(Document)
        when:
        def result = wrapper.wrap(document)
        then:
        result == wrapper
        wrapper.document == document
    }
}
