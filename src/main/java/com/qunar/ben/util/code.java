package com.qunar.ben.util;

/**
 * Created by ben on 2016/11/22.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class code {

    private static final int A = 3;

    public static void doTheThing(final Collection<? extends Object> c) {
        c.remove(A);
        System.out.println(c);
    }
    public static void main(String[] args) {
        TreeSet<Integer> c2 = new TreeSet<Integer>();
        c2.add(3);
        c2.add(2);
        c2.add(1);
        c2.add(4);
        doTheThing(new ArrayList<Integer>(Collections.unmodifiableSet(c2)));
    }
}
