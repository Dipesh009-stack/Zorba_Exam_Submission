package org.zorba.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zorba.entity.Student;
import org.zorba.entity.Teacher;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadStudentExcelFile {
    public static List<Student> readStudent(){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("resources/education_systems.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Student_info");
            for(Row row : sheet ){
                if(row.getRowNum()==0) continue;
                Student student = new Student();
                student.setStudentName(row.getCell(0).getStringCellValue());
                student.setLocation(row.getCell(1).getStringCellValue());
                student.setCourse(row.getCell(2).getStringCellValue());
                student.setEmail(row.getCell(3).getStringCellValue());
                student.setMobile((long)row.getCell(4).getNumericCellValue());
                student.setScore((int)row.getCell(6).getNumericCellValue());
                students.add(student);
            }

        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

        return students;
    }
}
