package org.zorba.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zorba.entity.Student;
import org.zorba.entity.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadStudentExcelFile {
    public static Set<Student> readStudent(){
        Set<Student> students = new HashSet<>();
        System.out.println(students);
        try{
            File file = new File("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/HibernateAssignment/src/main/resources/education_systems.xlsx");
            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Student_info");
            for(Row row : sheet ){

                students.add( students);
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        return students;
    }
}
