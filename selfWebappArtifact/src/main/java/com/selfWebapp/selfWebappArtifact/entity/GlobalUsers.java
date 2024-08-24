package com.selfWebapp.selfWebappArtifact.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "globalusers")
public class GlobalUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private  String lastName;
    private String department;

    @Column(unique = true)
    private String employeeId;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int riskscore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getRiskscore() {
        return riskscore;
    }

    public void setRiskscore(int riskscore) {
        this.riskscore = riskscore;
    }

    public GlobalUsers() {
    }

    public GlobalUsers(long id, String firstName, String lastName, String department, String employeeId, int riskscore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employeeId = employeeId;
        this.riskscore = riskscore;
    }
}
