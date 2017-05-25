package home.mike.phoneresolver.jsoup;

import home.mike.phoneresolver.data.WikiPageContentsWrapper;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
public class WikiPageContentsWrapperJsoup implements WikiPageContentsWrapper {
    private Document document;

    @Override
    public boolean canHandle(Object pageData) {
        return pageData instanceof Document;
    }

    @Override
    public WikiPageContentsWrapper wrap(Object pageData) {
        this.document = (Document) pageData;
        return this;
    }
}
