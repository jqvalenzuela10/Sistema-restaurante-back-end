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

import com.restaurant.products.entitys.TblCar;
import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.repository.CargoRepository;
import com.restaurant.products.repository.CategoriesRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class CargoRest {

	@Autowired
	CargoRepository pRepository;
	
	
	
	/*listado*/
	
	@GetMapping(value = "/cargo")
	public ResponseEntity<TblCar> getCargos() {
		
		List<TblCar> lista=pRepository.findAllCargos();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	
	/*listado por Id*/

	@GetMapping(value = "/cargo/{cargoId}")
	public ResponseEntity<TblCar> getCargoById(@PathVariable("cargoId")int cargoId) {
		
		Optional<TblCar> cargo=pRepository.findById(cargoId);
		
		if(!cargo.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(cargo.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/
	
	@PostMapping(value = "/cargo")
	public ResponseEntity<TblCar> createCargo(@RequestBody TblCar p){
		
		TblCar newcargo=pRepository.save(p);
		
		return ResponseEntity.ok(newcargo);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/cargo/{cargoId}")
	public String deleteCargo(@PathVariable("cargoId") int cargoId){
		
		Optional<TblCar> cargo = pRepository.findById(cargoId);

		if(!cargo.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(cargoId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, este cargo esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/cargo")
	public ResponseEntity<TblCar> updateCargo(@RequestBody TblCar cargo){
		
		Optional<TblCar> c = pRepository.findById(cargo.getIdCar());
		if(c.isPresent()) {
			TblCar updateCargo=c.get();
			updateCargo.setCar(cargo.getCar());
			pRepository.save(updateCargo);
			return ResponseEntity.ok(updateCargo);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
	
}
