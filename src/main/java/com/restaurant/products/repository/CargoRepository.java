package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblCar;
import com.restaurant.products.entitys.TblCategoria;

@EnableJpaRepositories
@Repository
public interface CargoRepository extends JpaRepository<TblCar, Integer>{
	
	 List<TblCar> findAllCargos();
}
