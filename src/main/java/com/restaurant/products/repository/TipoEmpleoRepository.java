package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblEmpleo;


@Repository
public interface TipoEmpleoRepository extends JpaRepository<TblEmpleo, Integer>{
	
	 List<TblEmpleo> findAllTipoEmpleos();
}
