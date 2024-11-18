package org.zorba.JDBC;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.Properties;

public class JDBCOperations {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        try {

            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/JDBCExam1016/src/main/resources/applications.properties");
            properties.load(fis);
            String url = properties.getProperty("url");
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Successful");
//            2. Create a new table named employee (emp_id int pk, emp_name varchar
//                    (255), emp_address varchar (255), emp_salary decimal (12, 2),
//                    emp_mobile int (10), dept_name varchar (255), doj datetime).
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS emp_policy (
                    policy_id INT PRIMARY KEY,
                    policy_name VARCHAR(255) NOT NULL,
                    policy_duration INT NOT NULL,
                    rate_of_interest FLOAT NOT NULL,
                    sum_assured DECIMAL(10, 2) NOT NULL
                );
            """;
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableSQL);
                System.out.println("Table 'emp_policy' is ready.");
            }

            String createEmployee = "create table Employee(emp_id int pk, emp_name varchar(225), emp_address varchar(225),emp_salary decimal(12,2),emp_mobile int(10), dept_name varchar(225), doj datetime";
            PreparedStatement preparedStatement = connection.prepareStatement(createEmployee);
            preparedStatement.execute();

            String alterTable = "ALTER TABLE Employee "
                    + "MODIFY emp_name VARCHAR(225) NOT NULL, "
                    + "MODIFY dept_name VARCHAR(225) NOT NULL";

            preparedStatement = connection.prepareStatement(alterTable);
            preparedStatement.executeUpdate();

            String defaultalter = "alter table Employee alter column doj set default ‘1970-01-01’";
            preparedStatement = connection.prepareStatement(defaultalter);
            preparedStatement.executeUpdate();

            //Now read excel file

            File file = new File("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/JDBCExam1016/src/main/resources/employee.xlsx");
            FileInputStream fis1 = new FileInputStream(file);

            String sql = "insert into Employee(?,?,?,?,?,?,?)";
            XSSFWorkbook xssfworkbook = new XSSFWorkbook(fis1);
            XSSFSheet sheet = xssfworkbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                int id = (int) row.getCell(0).getNumericCellValue();
                String name = row.getCell(1).getStringCellValue();
                String address = row.getCell(3).getStringCellValue();
                int emp_salary = (int) row.getCell(4).getNumericCellValue();
                int emp_mobile = (int) row.getCell(5).getNumericCellValue();
                String dept_name = row.getCell(6).getStringCellValue();
                String date = row.getCell(7).getStringCellValue();

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, address);
                preparedStatement.setInt(4, emp_salary);
                preparedStatement.setInt(5, emp_mobile);
                preparedStatement.setString(6, dept_name);
                preparedStatement.setString(7, date);

                preparedStatement.executeUpdate();
            }

            System.out.println("Data inserted Successfully");


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        File file = new File("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/JDBCExam1016/src/main/resources/employee.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet secondSheet = workbook.getSheetAt(1);
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish the connection
        Properties properties = new Properties();
        FileInputStream fis1 = new FileInputStream("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/JDBCExam1016/src/main/resources/applications.properties");
        properties.load(fis1);
        String url = properties.getProperty("url");
        String username = properties.getProperty("user");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Successful");

        String insertSQL1 =
                        """
                INSERT INTO emp_policy (policy_id, policy_name, policy_duration, rate_of_interest, sum_assured)
                VALUES (?, ?, 
                        """;

        // Step 3: Prepare SQL for inserting data
        String insertSQL =
                """
            
               INSERT INTO emp_policy (policy_id, policy_name, policy_duration, rate_of_interest
                             sum_assured
                                         VALUES (?, ?, ?, ?, ?
                         """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);


        for (Row row : secondSheet) {
            if (row.getRowNum() == 0) continue; // Skip header row

            int policyId = (int) row.getCell(0).getNumericCellValue();
            String policyName = row.getCell(1).getStringCellValue();
            int policyDuration = (int) row.getCell(2).getNumericCellValue();
            float rateOfInterest = (float) row.getCell(3).getNumericCellValue();
            double sumAssured = row.getCell(4).getNumericCellValue();


            preparedStatement.setInt(1, policyId);
            preparedStatement.setString(2, policyName);
            preparedStatement.setInt(3, policyDuration);
            preparedStatement.setFloat(4, rateOfInterest);
            preparedStatement.setDouble(5, sumAssured);

            // Execute insertion


        preparedStatement.executeUpdate();


    }

}
}