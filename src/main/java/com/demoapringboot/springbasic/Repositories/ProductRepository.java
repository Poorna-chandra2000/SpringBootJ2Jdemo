package com.demoapringboot.springbasic.Repositories;

import com.demoapringboot.springbasic.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByPname();//


    List<Product> findByPnameContaining(String name);
}
