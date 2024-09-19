package com.cognixia.stagestream.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cognixia.stagestream.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findByProductNameLike(String keyword, Pageable pageDetails);

    List<Product> findByCategory(String category);
}
