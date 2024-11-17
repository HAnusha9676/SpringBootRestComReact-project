package com.sathya.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.rest.entity.Products;

@Repository
public interface ReactRepository extends JpaRepository<Products,Long> {

}
