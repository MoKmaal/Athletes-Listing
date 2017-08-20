package com.blink.mohammed.athleteslisting;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mohammed on 20/08/17.
 *
 * Represent data as string
 */

public class StreamFormat {

    public static String convert2String(InputStream inputStream) {

        BufferedReader reader=new BufferedReader( new InputStreamReader(inputStream));
        String line ;
        String stream="";

        try {
            while ((line = reader.readLine()) != null) {
                stream += line;
            }

            inputStream.close();

        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return stream;
    }
}
