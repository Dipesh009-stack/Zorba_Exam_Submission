package org.zorba.entity;


import jakarta.persistence.*;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;


    @Column(name="department_name")
    private String departmentName;

    @Column(name="location")
    private String location;
}
