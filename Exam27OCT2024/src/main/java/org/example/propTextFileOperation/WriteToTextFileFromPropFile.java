package org.example.propTextFileOperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToTextFileFromPropFile {
    public static void main(String[] args)  {
        try{
            File file = new File("/Users/dipeshwosti/IdeaProjects/Java_1016_Batch_Class_Notes/FileInputOutputOperations/src/main/resources/abc.properties");
            FileInputStream fileInputStream = new FileInputStream(file);

            Properties properties = new Properties();

            properties.load(fileInputStream);
            PrintWriter writer = new PrintWriter(file);
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                writer.println(key + "=" + value);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}