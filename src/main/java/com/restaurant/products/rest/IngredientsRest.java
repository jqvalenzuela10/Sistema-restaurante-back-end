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

import com.restaurant.products.entitys.TblIngrediente;

import com.restaurant.products.repository.IngredientsRepository;

@RestController
@RequestMapping("/rest")
public class IngredientsRest {

	
	
	@Autowired
	IngredientsRepository pRepository;
	
	
	
	/*listado*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/ingredients")
	public ResponseEntity<TblIngrediente> getIngredient() {
		
		List<TblIngrediente> lista=pRepository.findAllIngredients();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	
	/*listado por Id*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/ingredients/{ingredientId}")
	public ResponseEntity<TblIngrediente> getIngredientById(@PathVariable("ingredientId")int ingredientId) {
		
		Optional<TblIngrediente> ingredient=pRepository.findById(ingredientId);
		
		if(!ingredient.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(ingredient.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value = "/ingredients")
	public ResponseEntity<TblIngrediente> createIngredient(@RequestBody TblIngrediente p){
		
		TblIngrediente newIngredient=pRepository.save(p);
		
		return ResponseEntity.ok(newIngredient);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/ingredients/{ingredientId}")
	public String deleteIngredient(@PathVariable("ingredientId") int ingredientId){
		
		Optional<TblIngrediente> ingredient = pRepository.findById(ingredientId);

		if(!ingredient.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(ingredientId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, este ingrediente esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/ingredients")
	public ResponseEntity<TblIngrediente> updateProveedor(@RequestBody TblIngrediente ingredient){
		
		Optional<TblIngrediente> c = pRepository.findById(ingredient.getIdIngrediente());
		if(c.isPresent()) {
			TblIngrediente newIngredient=c.get();
			newIngredient.setIngrediente(ingredient.getIngrediente());
			newIngredient.setPresentacion(ingredient.getPresentacion());
			newIngredient.setMarca(ingredient.getMarca());
			newIngredient.setVencimiento(ingredient.getVencimiento());
			newIngredient.setTblProveedore(ingredient.getTblProveedore());
			
		
			pRepository.save(newIngredient);
			return ResponseEntity.ok(newIngredient);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
	}
	
	
}
