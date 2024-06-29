package com.example.stripe.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.stripe.model.MSProduct;


@Repository
public interface MSProductRepository extends CrudRepository<MSProduct, Long> {
	List<MSProduct> findByCategory(String category);

    @Modifying
    @Query("UPDATE MSProduct SET priceId = :priceId WHERE id = :id")
    boolean updateByEmail(@Param("id") Long id, @Param("priceId") String priceId);
}
