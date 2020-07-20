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

import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblEmpleo;
import com.restaurant.products.repository.CategoriesRepository;
import com.restaurant.products.repository.TipoEmpleoRepository;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class TipoEmpleoRest {

	
	
	@Autowired
	TipoEmpleoRepository pRepository;
	
	
	
	/*listado*/
	
	@GetMapping(value = "/tipoEmpleo")
	public ResponseEntity<TblEmpleo> getTipoEmpleo() {
		
		List<TblEmpleo> lista=pRepository.findAllTipoEmpleos();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	
	/*listado por Id*/

	@GetMapping(value = "/tipoEmpleo/{tipoEmpleoId}")
	public ResponseEntity<TblEmpleo> getTipoEmpleoById(@PathVariable("tipoEmpleoId")int tipoEmpleoId) {
		
		Optional<TblEmpleo> tipoEmpleo=pRepository.findById(tipoEmpleoId);
		
		if(!tipoEmpleo.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(tipoEmpleo.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/

	@PostMapping(value = "/tipoEmpleo")
	public ResponseEntity<TblEmpleo> createTipoEmpleo(@RequestBody TblEmpleo p){
		
		TblEmpleo newcategory=pRepository.save(p);
		
		return ResponseEntity.ok(newcategory);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/tipoEmpleo/{tipoEmpleoId}")
	public String deleteTipoEmpleo(@PathVariable("tipoEmpleoId") int tipoEmpleoId){
		
		Optional<TblEmpleo> category = pRepository.findById(tipoEmpleoId);

		if(!category.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(tipoEmpleoId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, este tipo de empleado esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/tipoEmpleo")
	public ResponseEntity<TblEmpleo> updateTipoEmpleo(@RequestBody TblEmpleo tipoEmpleo){
		
		Optional<TblEmpleo> c = pRepository.findById(tipoEmpleo.getIdTipoEmpleo());
		if(c.isPresent()) {
			TblEmpleo updateTipoEmpleo=c.get();
			updateTipoEmpleo.setTipoEmpleo(tipoEmpleo.getTipoEmpleo());
			
			
			pRepository.save(updateTipoEmpleo);
			return ResponseEntity.ok(updateTipoEmpleo);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
	
}
