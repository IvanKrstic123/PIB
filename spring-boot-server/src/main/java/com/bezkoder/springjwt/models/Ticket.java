package com.bezkoder.springjwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String payment;

    @NotBlank
    private int price;

    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "pin", nullable = false)
    private Person person;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "id", referencedColumnName = "id"),
            @JoinColumn(name = "queue", referencedColumnName = "queue")
    })
    @ManyToOne
    private Seat seat;

    @MapsId("date")
    @JoinColumns({
            @JoinColumn(name = "date_id", referencedColumnName = "date"),
            @JoinColumn(name = "performance_id", referencedColumnName = "performance")
    })
    @ManyToOne
    private Repertoire repertoire;


    public Ticket() {
    }

    public Ticket(Long id, @NotBlank @Size(max = 20) String payment, @NotBlank int price, Timestamp date, Seat seat, Person person, Repertoire repertoire) {
        this.id = id;
        this.payment = payment;
        this.price = price;
        this.date = date;
        this.seat = seat;
        this.person = person;
        this.repertoire = repertoire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return price == ticket1.price &&
                Objects.equals(id, ticket1.id) &&
                Objects.equals(payment, ticket1.payment) &&
                Objects.equals(date, ticket1.date) &&
                Objects.equals(seat, ticket1.seat) &&
                Objects.equals(person, ticket1.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, payment, price, date, seat, person);
    }


    public Repertoire getRepertoire() {
        return repertoire;
    }

    public void setRepertoire(Repertoire repertoire) {
        this.repertoire = repertoire;
    }
}
