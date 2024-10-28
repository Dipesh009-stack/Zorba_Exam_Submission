package org.example.propTextFileOperation;

import java.io.*;

public class WriteToTextFileFromPropFile {
    public static void main(String[] args)  {
        try{
            File file = new File("/Users/dipeshwosti/IdeaProjects/Java_1016_Batch_Class_Notes/FileInputOutputOperations/src/main/resources/abc.properties");
            FileInputStream fileInputStream = new FileInputStream(file);

            Properties properties = new Properties();

            properties.load(fileInputStream);
            String name = properties.getProperty("name");
            String address = properties.getProperty("address");
            String pin = properties.getProperty("PIN");
            String mobileNumber = properties.getProperty("mobile_number");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            String output = String.format("My name is %s. Address is %s, pin: %s. Mobile number %s.\n"
                            + "Whereas my username is %s and password is %s.",
                    name, address, pin, mobileNumber, username, password);

            PrintWriter writer = new PrintWriter(new FileOutputStream(/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/Exam27OCT2024/src/main/resources/test.txt));
            writer.println(output);
            writer.close();


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}