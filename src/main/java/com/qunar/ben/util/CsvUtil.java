package com.qunar.ben.util;

import com.opencsv.CSVReader;

import java.io.FileReader;

/**
 * Created by ben on 2016/11/22.
 */


public class CsvUtil {
    public  static  void main(String[] args){

        try {
            CSVReader csvReader = new CSVReader(new FileReader("/Users/ben/basic_data/origin_sight.csv"));
            String [] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[3] + '\t'+nextLine[1] + "etc...");
            }
        }catch(Exception e){

        }finally {

        }
    }
}
