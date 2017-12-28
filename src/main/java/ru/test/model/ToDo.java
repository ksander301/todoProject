package ru.test.model;

import java.util.Date;

public class ToDo {

    private String name;
    private Date alertDate;
    private String description;
    private Long id;

    public ToDo() {
    }

    public ToDo(String name, Date alertDate, String description, Long id) {
        this.name = name;
        this.alertDate = alertDate;
        this.description = description;
        this.id = id;
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

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "name='" + name + '\'' +
                ", alertDate=" + alertDate +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
