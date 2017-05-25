package home.mike.phoneresolver.data

import spock.lang.Specification
import spock.lang.Subject

class WikiPageContentsWrapperFactoryShould extends Specification {
    @Subject
    WikiPageContentsWrapperFactory factory

    def 'fail if no wrapper found'() {
        setup:
        factory = new WikiPageContentsWrapperFactory()
        factory.wrappers = new ArrayList<WikiPageContentsWrapper>()
        when:
        factory.wrap('hello')
        then:
        def ex = thrown(UnknownWikiPageContentsFormatException)
        ex.message == 'Cannot wrap wiki page data of type: class java.lang.String'
    }

    def 'wrap page data'() {
        setup:
        factory = new WikiPageContentsWrapperFactory()
        factory.wrappers = new ArrayList<>()
        def fakeWrapper = new WikiPageContentsWrapper() {
            @Override
            boolean canHandle(Object pageData) {
                return true
            }

            @Override
            WikiPageContentsWrapper wrap(Object pageData) {
                return this
            }
        }
        factory.wrappers.add(fakeWrapper)
        when:
        def wrapper = factory.wrap('hello')
        then:
        wrapper == fakeWrapper
    }
}
