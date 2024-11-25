package Hibernate;
//Student : student_id(pk), stud_name,
//stud_roll_number, subject_id (fk)

public class Student {

    private Integer studentiId;
    private String  studnetName;
    private Subject subject;

    public Integer getStudentiId() {
        return studentiId;
    }

    public void setStudentiId(Integer studentiId) {
        this.studentiId = studentiId;
    }

    public String getStudnetName() {
        return studnetName;
    }

    public void setStudnetName(String studnetName) {
        this.studnetName = studnetName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
