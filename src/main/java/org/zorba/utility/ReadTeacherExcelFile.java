package org.zorba.utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zorba.entity.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadTeacherExcelFile {
    public static List<Teacher> readTeacher(){
    List<Teacher> teachers = new ArrayList<>();
    try{
        File file = new File("/Users/dipeshwosti/IdeaProjects/Zorba_Exam_Submission/HibernateAssignment/src/main/resources/education_systems.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Teacher_info");
        for(Row row : sheet ){
            if(row.getRowNum()==0) continue;
            Teacher teacher = new Teacher();
            teacher.setTeacherName(row.getCell(0).getStringCellValue());
            teacher.setSpecialization(row.getCell(1).getStringCellValue());
            teacher.setEmail(row.getCell(2).getStringCellValue());
            teacher.setMobile((long)row.getCell(3).getNumericCellValue());
            teacher.setAddress(row.getCell(4).getStringCellValue());
            teachers.add(teacher);
            teacher.setStudents(ReadStudentExcelFile.readStudent());
        }

    }
    catch (Exception e){
        System.err.println(e.getMessage());
    }

    return teachers;
    }
}
