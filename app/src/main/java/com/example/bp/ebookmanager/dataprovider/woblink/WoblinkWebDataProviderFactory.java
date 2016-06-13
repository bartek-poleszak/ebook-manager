package com.example.bp.ebookmanager.dataprovider.woblink;

import com.example.bp.ebookmanager.dataprovider.BookDataProvider;
import com.example.bp.ebookmanager.dataprovider.BookDataProviderImpl;
import com.example.bp.ebookmanager.dataprovider.WebActionContext;
import com.example.bp.ebookmanager.dataprovider.WebDataProviderFactory;
import com.example.bp.ebookmanager.dataprovider.WebActionResolver;
import com.example.bp.ebookmanager.dataprovider.WebDataProviderStrategy;
import com.example.bp.ebookmanager.dataprovider.android.HeadlessWebClient;
import com.example.bp.ebookmanager.model.BookDetails;
import com.example.bp.ebookmanager.model.WebBookDetails;

/**
 * Ebook Manager
 * Created by bp on 12.06.16.
 */
public class WoblinkWebDataProviderFactory implements WebDataProviderFactory {

    private static WoblinkWebDataProviderFactory inst;

    private WoblinkWebDataProviderFactory() {}

    public static WoblinkWebDataProviderFactory instance() {
        if (inst == null)
            inst = new WoblinkWebDataProviderFactory();
        return inst;
    }

    @Override
    public BookDataProvider createBookDataProvider() {
        WebDataProviderStrategy strategy = new WebDataProviderStrategy();
        WebActionResolver resolver = new WebActionResolver(new HeadlessWebClient());
        strategy.setResolver(resolver);
        strategy.setParser(new WoblinkBookDataParser());
        strategy.setWebActionContext(new WoblinkWebActionContext());
        return new BookDataProviderImpl(strategy);
    }

    @Override
    public WebBookDetails createBookDetails(WebActionContext context) {
        WebBookDetails details = new WebBookDetails();
        details.setContext(context);
        details.setResolver(new WebActionResolver(new HeadlessWebClient()));
        details.setParser(new WoblinkBookDetailsParser());
        return details;
    }
}
