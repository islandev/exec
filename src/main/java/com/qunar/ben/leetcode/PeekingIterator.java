package com.qunar.ben.leetcode;

import java.util.Iterator;

/**
 * Created by ben on 2017/2/23.
 */
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private final  Iterator<Integer> iterator;
    private boolean hasPeeked;
    private int peekElment;
    public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator= iterator;
        // initialize any member here.

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeeked){
            peekElment = iterator.next();
            hasPeeked = true;
        }
        return  peekElment;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked){
            return  iterator.next();
        }
        int result = peekElment;
        hasPeeked =false;
        peekElment = 0;
        return  result;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}
