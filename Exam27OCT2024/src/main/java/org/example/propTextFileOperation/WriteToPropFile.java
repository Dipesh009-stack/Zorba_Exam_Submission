package org.example.propTextFileOperation;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class WriteToPropFile {
    public static void main(String[] args) {


        try {
            File file = new File("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/Exam27OCT2024/src/main/resources/test.properties");
            FileInputStream fis;
            fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            properties.setProperty("name", "Robet");
            properties.setProperty("address", "NYC");
            properties.setProperty("PIN", "239823");
            properties.setProperty("username", "robo_test");
            properties.setProperty("password", "hello");

            FileOutputStream outputStream = new FileOutputStream(file);
            properties.store(outputStream, "Updated by Dipesh..");
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }





    }

}