package com.example.jobhunting;

import java.util.HashMap;
import java.util.Map;

public class Jobs {
    private String id;
    private String title;
    private String company;
    private String salary;
    private String description;

    public Jobs(){};

    public Jobs(String id, String title, String company, String salary, String description){
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.description = description;
    }

    public Jobs(String title, String company, String salary, String description){
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> toMap() {

        HashMap<String, Object> result = new HashMap<>();
        result.put("title", this.title);
        result.put("company", this.company);

        return result;
    }
}
