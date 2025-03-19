package com.cisco.prj.entity;

import com.cisco.prj.annotation.Column;
import com.cisco.prj.annotation.Table;

@Table(name="EMP")
public class Employee {
    private String email;
    private String firstName;

    @Column(name = "EMP_EMAIL", type = "VARCHAR(50)")
    public String getEmail() {
        return email;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
