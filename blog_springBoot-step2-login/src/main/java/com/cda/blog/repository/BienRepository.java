package com.cda.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.blog.model.Bien;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long> {

}
