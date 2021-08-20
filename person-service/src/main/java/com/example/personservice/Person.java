package com.example.personservice;


import lombok.Data;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;
import org.springframework.data.annotation.Id;


import java.util.UUID;

@Data
@Table(name = "people")
public class Person {

    @PrimaryKey
    String id = UUID.randomUUID().toString();

    String firstName;
    String lastName;

    public Person() {}

    public Person(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
