package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblProveedore;


@Repository
public interface ProveedoresRepository extends JpaRepository<TblProveedore, Integer>{
	
	 List<TblProveedore> findAllProveedores();
}