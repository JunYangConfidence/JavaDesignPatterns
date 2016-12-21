package com.example.iteratorpattern;

import java.util.List;

/**
 * Created by **
 */

public class BookIterator implements AbstractIterator {

    private BookList bookList;
    private List list;
    private int cursor1;
    private int cursor2;

    public BookIterator(BookList bookList){
        this.bookList = bookList;
        this.list = bookList.getObjects();
        cursor1 = 0;
        cursor2 = this.list.size()-1;
    }
    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2 --;
        }
    }

    @Override
    public void next() {
        if (cursor1<this.list.size()){
            cursor1 ++;
        }
    }

    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }

    @Override
    public boolean isLast() {
        return cursor1 == this.list.size();
    }

    @Override
    public Object getNextItem() {
        return this.list.get(cursor1);
    }

    @Override
    public Object getPrevious() {
        return this.list.get(cursor2);
    }
}
