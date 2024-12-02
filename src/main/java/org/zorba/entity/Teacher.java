package org.zorba.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name="teacher")
@Getter
@Setter
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name="email")
    private String email;

    @Column(name="mobile")
    private Long mobile;

    @Column(name= "address")
    private String address;

//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private Set<Student> students;
}
