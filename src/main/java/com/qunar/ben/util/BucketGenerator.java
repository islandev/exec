package com.qunar.ben.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Created by ben on 2016/12/7.
 */
public class BucketGenerator {

    public static void main(String[] args) {
        float  sum =0;
        float  firstBucketCount = 0;
        float secondBucketCount =0;
        float rator = 0.1f;
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ben/qunar/project/exec/src/main/java/com/qunar/ben/util/suid.log"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum ++;
               if(getSearchBoxType(rator,line)== 1){
                   firstBucketCount++;
               }else secondBucketCount ++;

            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.print("can not find the file");
        }

        try {
            String context = new StringBuilder().append("1:").append(firstBucketCount).append("/t 2:").append(secondBucketCount).toString();
            final File file = new File("log.txt");
            FileUtils.writeStringToFile(file, context, "UTF-8");
        }catch (IOException ie){
            ie.printStackTrace();
        }
        //System.out.print( getSearchBoxType(rator,"860797035707645"));
    }


    private static  int getSearchBoxType(float ratio , String uid) {
        int searchBoxType = -1;
        if (searchBoxType == -1) {
            searchBoxType = 0;
            //String uid = GlobalEnv.getInstance().getUid();
            if (!isEmpty(uid)) {
                uid = uid.toLowerCase();
                if ("000000000000000".equals(uid) || uid.length() < 5) {
                    searchBoxType = 0;
                } else {
                    MessageDigest md = null;
                    String uidMd5 = "";
                    try {
                        md = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    md.update(uid.getBytes());
                    byte[] sum = md.digest();
                    for (byte o : sum) {
                        uidMd5 = uidMd5 + String.format("%02X", o);
                    }
                    uidMd5 = uidMd5.substring(uidMd5.length() - 4);
                    int uidInt = Integer.parseInt(uidMd5, 16);
                    float bucket = (float) uidInt / 65535;
                    if (bucket < ratio) {
                        searchBoxType = 1;
                    } else {
                        searchBoxType = 0;
                    }
                }
            }
            //  DataUtils.putPreferences(SearchUtils.searchBoxUiTypeName, searchBoxType);
        }
        return searchBoxType;
    }
}
