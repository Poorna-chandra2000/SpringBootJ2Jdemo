package com.demoapringboot.springbasic.Repositories;

import com.demoapringboot.springbasic.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByPname(String pname);//parameter is must


    List<Product> findByPnameContaining(String pname);

    List<Product> findByPnameContainingIgnoreCase(String pname);

    List<Product> findByPnameAndPrice(String name, Integer sal);

    List<Product> findByPnameOrPrice(String name, Integer sal);

    List<Product> findByPriceGreaterThan(Integer sal);

    @Query(value = "SELECT COUNT(*) FROM product WHERE price > :sal", nativeQuery = true)
    Integer getcount(@Param("sal") Integer salary);
//    @Query(value = "SELECT COUNT(*) FROM product WHERE price > :sal", nativeQuery = true)
//    Integer getCount(@Param("sal") Integer sal);

}
