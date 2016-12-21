package com.example.iteratorpattern;

import java.util.List;

/**
 * Created by **
 */

public class BookList extends AbstractBookList {

    public BookList(List objects) {
        super(objects);
    }

    @Override
    protected BookIterator createIterator() {
        return new BookIterator(this);
    }
}
