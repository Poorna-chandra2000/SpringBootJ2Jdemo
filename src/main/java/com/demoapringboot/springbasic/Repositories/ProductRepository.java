package com.demoapringboot.springbasic.Repositories;

import com.demoapringboot.springbasic.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
