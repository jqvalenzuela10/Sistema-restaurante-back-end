package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblIngrediente;


@Repository
public interface IngredientsRepository extends JpaRepository<TblIngrediente, Integer>{
	
	 List<TblIngrediente> findAllIngredients();
}
