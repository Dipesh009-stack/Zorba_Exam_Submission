package org.zorba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="student")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(name="studnet_name")
    private String studentName;

    @Column(name= "location")
    private String location;

    @Column(name="course")
    private String course;

    @Column(name= "email")
    private String email;

    @Column(name= "mobile")
    private Long mobile;

    @Column(name="score")
    private Integer score;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="teacher_name")
    private Teacher teacher;




}
