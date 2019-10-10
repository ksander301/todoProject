package ru.test.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.test.model.adapter.LocalDateXmlAdapter;
import ru.test.model.serializer.LocalDateSerializer;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "ToDo")
public class ToDo  {

    private String name;
    private LocalDate alertDate;
    private String description;
    private Long id;

    public ToDo() {
    }

    public ToDo(String name, LocalDate alertDate, String description, Long id) {
        this.name = name;
        this.alertDate = alertDate;
        this.description = description;
        this.id = id;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    //@XmlSchemaType( name="date")
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonSerialize(using = LocalDateSerializer.class)
    public LocalDate getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(LocalDate alertDate) {
        this.alertDate = alertDate;
    }

    @XmlElement
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
