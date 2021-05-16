package com.bezkoder.springjwt.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class RepertoirePK implements Serializable {
    private Timestamp date;
    private Long performance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepertoirePK that = (RepertoirePK) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(performance, that.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, performance);
    }
}
