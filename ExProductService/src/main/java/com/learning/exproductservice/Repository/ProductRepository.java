package com.learning.exproductservice.Repository;

import com.learning.exproductservice.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Method for custom method name
    //Optional<Product> findByPrdname(String name);

    //Method for custom query
    @Query(value = "select * from product where prdname Like %:word%", nativeQuery = true)
    Iterable<Product> findByPrdname(@Param("word") String prdname);

    //Method for Filtering concept
    Page<Product> findByPrdnameContainingIgnoreCase(String name, Pageable pageable);
}
