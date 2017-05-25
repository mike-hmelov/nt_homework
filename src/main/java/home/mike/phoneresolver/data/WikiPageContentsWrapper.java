package home.mike.phoneresolver.data;

public interface WikiPageContentsWrapper {
    boolean canHandle(Object pageData);

    WikiPageContentsWrapper wrap(Object pageData);
}
