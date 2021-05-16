package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    public <S extends Type> S save(S s);

    public List<Type> findAllByType(String type);
}
