package com.qunar.ben.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 16/9/13.
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args){
        List<OOMObject>  list =  new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
