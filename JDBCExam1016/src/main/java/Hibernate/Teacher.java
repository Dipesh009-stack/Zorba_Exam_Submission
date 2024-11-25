package Hibernate;
//. Teacher : teacher_id(pk), teacher_name,
//teacher_qualification, experience_of_teaching, student_id

public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private String teacherQualifications;
    private Integer eperienceOfTeaching;

    public Integer getEperienceOfTeaching() {
        return eperienceOfTeaching;
    }

    public void setEperienceOfTeaching(Integer eperienceOfTeaching) {
        this.eperienceOfTeaching = eperienceOfTeaching;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherQualifications() {
        return teacherQualifications;
    }

    public void setTeacherQualifications(String teacherQualifications) {
        this.teacherQualifications = teacherQualifications;
    }
}
