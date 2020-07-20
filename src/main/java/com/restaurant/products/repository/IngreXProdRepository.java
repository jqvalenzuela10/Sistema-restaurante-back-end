package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblIngreXProd;
import com.restaurant.products.entitys.TblProveedore;


@Repository
public interface IngreXProdRepository extends JpaRepository<TblIngreXProd, Integer>{
	
	 List<TblIngreXProd> findAllIngreXProd();
}