package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblProducto;

@Repository
public interface ProductsRepository extends JpaRepository<TblProducto, Integer>{
	
	 List<TblProducto> findAllProducts();
}
