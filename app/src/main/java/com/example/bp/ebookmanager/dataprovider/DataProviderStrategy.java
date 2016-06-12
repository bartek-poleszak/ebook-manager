package com.example.bp.ebookmanager.dataprovider;

import com.example.bp.ebookmanager.model.Book;

import java.util.List;

/**
 * Created by bp on 08.05.16.
 */
public interface DataProviderStrategy {

    void gainAccess(Callbacks callback);
    void retryToGainAccess();
    List<Book> getBooks();
    void enableUserAction(UserActionEnabler visitor);

    interface Callbacks {
        void onAccessGained();
        void onUserActionRequired();
    }
}