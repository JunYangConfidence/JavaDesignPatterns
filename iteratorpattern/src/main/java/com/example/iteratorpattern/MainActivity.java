package com.example.iteratorpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List objects = new ArrayList<>();
        objects.add("阿甘正传");
        objects.add("西游记");
        objects.add("java编程思想");
        objects.add("设计模式");

        logcat("正序遍历");
        ListIterator listIterator = objects.listIterator();
        while (listIterator.hasNext()){
            Object next = listIterator.next();
            logcat(next+" ");
        }
        logcat("后序遍历");
        while (listIterator.hasPrevious()){
            Object previous = listIterator.previous();
            logcat(previous+" ");
        }
//        AbstractBookList bookList;
//        AbstractIterator iterator;
//
//        bookList = new BookList(objects);
//        iterator = bookList.createIterator();
//
//        logcat("正序遍历");
//        logcat("first list object = "+objects.get(1));
//        while (!iterator.isLast()){
//            logcat(iterator.getNextItem()+",");
//            iterator.next();
//        }
//        logcat("后序遍历");
//        while (!iterator.isFirst()){
//            logcat(iterator.getPrevious()+",");
//            iterator.previous();
//        }
    }
    private void logcat(String msg){
        Log.d("test",msg);
    }
}
