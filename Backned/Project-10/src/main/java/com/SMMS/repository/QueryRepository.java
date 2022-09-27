package com.SMMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SMMS.entities.Query;

@Repository
public interface QueryRepository extends JpaRepository<Query, Integer> {

}
