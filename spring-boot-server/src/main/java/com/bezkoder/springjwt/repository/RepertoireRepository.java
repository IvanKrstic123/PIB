package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Repertoire;
import com.bezkoder.springjwt.models.RepertoirePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepertoireRepository extends JpaRepository<Repertoire, RepertoirePK> {
}
