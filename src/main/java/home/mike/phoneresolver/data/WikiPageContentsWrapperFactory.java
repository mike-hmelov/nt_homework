package home.mike.phoneresolver.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class WikiPageContentsWrapperFactory {
    @Autowired
    private List<WikiPageContentsWrapper> wrappers;

    WikiPageContentsWrapper wrap(Object pageData) {
        Optional<WikiPageContentsWrapper> validWrapper = wrappers
                .stream()
                .filter(w -> w.canHandle(pageData))
                .findFirst();
        return validWrapper.<UnknownWikiPageContentsFormatException>orElseThrow(
                () -> {
                    throw new UnknownWikiPageContentsFormatException(String.format("Cannot wrap wiki page data of type: %s", pageData != null ? pageData.getClass() : "null"));
                }).wrap(pageData);
    }
}
