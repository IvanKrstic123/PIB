package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "repertoire")
public class Repertoire implements Serializable {
    @EmbeddedId
    private RepertoirePK repertoirePK;

    @ManyToOne
    @JoinColumn(name = "performance_id", referencedColumnName = "id", nullable = false)
    private Performance performance;

    @OneToMany(mappedBy = "repertoire")
    @JsonIgnore
    private Set<Ticket> tickets;


    public Repertoire() {
    }

    public Repertoire(RepertoirePK repertoirePK, Performance performance, Set<Ticket> tickets) {
        this.repertoirePK = repertoirePK;
        this.performance = performance;
        this.tickets = tickets;
    }

    public RepertoirePK getRepertoirePK() {
        return repertoirePK;
    }

    public void setRepertoirePK(RepertoirePK repertoirePK) {
        this.repertoirePK = repertoirePK;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
