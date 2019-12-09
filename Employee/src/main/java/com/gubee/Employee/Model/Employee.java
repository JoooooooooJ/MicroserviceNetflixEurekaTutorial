package com.gubee.Employee.Model;


public class Employee {

    private Long id;
    private Long departmentId;
    private Long organizationId;
    private String name;
    private Integer age;
    private String position;

    public Employee(Long departmentId, Long organizationId, String name, Integer age, String position) {
        this.departmentId = departmentId;
        this.organizationId = organizationId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
