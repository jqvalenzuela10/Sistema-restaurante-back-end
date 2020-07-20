package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.Info;

import com.restaurant.products.entitys.TblSucursale;

@EnableJpaRepositories
@Repository
public interface SucursalRepository extends JpaRepository<TblSucursale, Integer>{
	
	 List<TblSucursale> findAllSucursal();
	 
	 // @Query(value = "select s.nombre,e.nombres From Tbl_empleados e join tbl_sucursales s on e.id_sucursal=s.id_sucursal",nativeQuery = true)
	 
	 
//	 @Query("SELECT new com.restaurant.products.entitys.Info(c.nombres , p.nombre) FROM TblEmpleado c JOIN c.tblSucursale p")
//	 public List<Info> getJoinInformation();
}