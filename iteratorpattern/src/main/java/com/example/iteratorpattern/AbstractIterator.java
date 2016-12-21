package com.example.iteratorpattern;

/**
 * Created by *8
 */

public interface AbstractIterator {
    /**
     * 移动至上一个元素
     */
    void previous();

    /**
     * 移动至下一个元素
     */
    void next();

    /**
     * 判断是否为第一个元素
     * @return
     */
    boolean isFirst();

    /**
     * 判断是否为最后一个元素
     * @return
     */
    boolean isLast();

    /**
     * 获取上一个元素
     */
    Object getNextItem();
    /**
     * 获取下一个元素
     */
    Object getPrevious();

}
