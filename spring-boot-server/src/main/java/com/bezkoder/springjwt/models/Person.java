package com.bezkoder.springjwt.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pin; // personal identification number

    @NotBlank
    @Size(max = 20)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String surname;

    @Size(max = 30)
    @Email
    private String email;

    @Size(max = 30)
    private String password;

    @OneToMany(mappedBy = "person")
    private Set<Ticket> tickets;


    public Person() {
    }

    public Person(Long pin, @NotBlank @Size(max = 20) String name, @NotBlank @Size(max = 20) String surname, @Size(max = 30) @Email String email, @Size(max = 30) String password,/*, Set<Ticket> tickets*/Set<Ticket> tickets) {
        this.pin = pin;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.tickets = tickets;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(pin, person.pin) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(email, person.email) &&
                Objects.equals(password, person.password) &&
                Objects.equals(tickets, person.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin, name, surname, email, password/*, tickets*/);
    }


}
