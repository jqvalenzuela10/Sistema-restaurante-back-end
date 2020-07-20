package com.restaurant.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.products.entitys.TblEmpleado;

@EnableJpaRepositories
@Repository
public interface UsersRepository extends JpaRepository<TblEmpleado, Integer>{
	
	 List<TblEmpleado> findAllUsers();
	 
	 @Query(value = "select * from TBL_EMPLEADOS e where e.ID_EMPLEADO=:id and CLAVE=:clave",nativeQuery = true)
	 TblEmpleado validar(@Param("id") int id ,@Param("clave") String clave);
}
