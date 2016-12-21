package com.example.iteratorpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by **
 * 聚合类
 */

public abstract class AbstractBookList {
    protected List<Object> objects = new ArrayList<Object>();

    public AbstractBookList(List objects){
        this.objects = objects;
    }

    protected void addObject(Object object){
        this.objects.add(object);
    }

    protected void removeObject(Object object){
        this.objects.remove(object);
    }

    protected List getObjects(){
        return this.objects;
    }

    protected abstract BookIterator createIterator();
}
