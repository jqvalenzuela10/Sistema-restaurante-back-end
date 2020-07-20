package com.restaurant.products.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.products.entitys.Info;
import com.restaurant.products.entitys.TblSucursale;

import com.restaurant.products.repository.SucursalRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class SucursalRest {

	
	
	@Autowired
	SucursalRepository pRepository;
	
	
	
	/*listado*/
	
	@GetMapping(value = "/sucursal")
	public ResponseEntity<TblSucursale> getsucursal() {
		
		List<TblSucursale> lista=pRepository.findAllSucursal();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	/*LISTADO SUCURSAL EMPLEADOS*/
//	@GetMapping(value = "/getInfo")
//	public List<Info> getInfo() {
//		
//	
//		return  pRepository.getJoinInformation();
//	}
	
	
	/*listado por Id*/

	@GetMapping(value = "/sucursal/{sucursalId}")
	public ResponseEntity<TblSucursale> getSucursalById(@PathVariable("sucursalId")int sucursalId) {
		
		Optional<TblSucursale> sucursal=pRepository.findById(sucursalId);
		
		if(!sucursal.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(sucursal.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/

	@PostMapping(value = "/sucursal")
	public ResponseEntity<TblSucursale> createCategory(@RequestBody TblSucursale p){
		
		TblSucursale newcategory=pRepository.save(p);
		
		return ResponseEntity.ok(newcategory);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/sucursal/{sucursalId}")
	public String deleteCategory(@PathVariable("sucursalId") int sucursalId){
		
		Optional<TblSucursale> sucursal = pRepository.findById(sucursalId);

		if(!sucursal.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(sucursalId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, esta categoria esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/sucursal")
	public ResponseEntity<TblSucursale> updateCategory(@RequestBody TblSucursale sucursal){
		
		Optional<TblSucursale> c = pRepository.findById(sucursal.getIdSucursal());
		if(c.isPresent()) {
			TblSucursale updateSucursal=c.get();
			updateSucursal.setNombre(sucursal.getNombre());
			updateSucursal.setUbicacion(sucursal.getUbicacion());
			updateSucursal.setTelefono(sucursal.getTelefono());
			
			
			
			pRepository.save(updateSucursal);
			return ResponseEntity.ok(updateSucursal);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
