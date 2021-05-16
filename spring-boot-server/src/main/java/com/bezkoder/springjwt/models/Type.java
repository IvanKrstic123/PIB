package com.bezkoder.springjwt.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "types")
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Type required!")
    @Size(max = 40)
    private String type;

    @OneToMany(mappedBy = "type")
    private Set<Performance> performances;


    public Type() {
    }

    public Type(Long id, @NotBlank() @Size(max = 40) String title, Set<Performance> performances) {
        this.id = id;
        this.type = title;
        this.performances = performances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return type;
    }

    public void setTitle(String title) {
        this.type = title;
    }

    public Set<Performance> getPerformances() {
        return performances;
    }

    public void setPerformances(Set<Performance> performances) {
        this.performances = performances;
    }
}
