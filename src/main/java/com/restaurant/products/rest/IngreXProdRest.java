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

import com.restaurant.products.entitys.TblIngreXProd;
import com.restaurant.products.entitys.TblProducto;
import com.restaurant.products.repository.IngreXProdRepository;
import com.restaurant.products.repository.ProductsRepository;

@RestController
@RequestMapping("/rest")
public class IngreXProdRest {
	@Autowired
	IngreXProdRepository pRepository;
	
	
	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/ingrexprod")
	public ResponseEntity<TblIngreXProd> getTblIngreXProd() {
		
		List<TblIngreXProd> lista=pRepository.findAllIngreXProd();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/ingrexprod/{ingrexprodId}")
	public ResponseEntity<TblIngreXProd> getTblIngreXProdById(@PathVariable("ingrexprodId")int ingrexprodId) {
		
		Optional<TblIngreXProd> product=pRepository.findById(ingrexprodId);
		
		if(!product.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(product.get(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value = "/ingrexprod")
	public ResponseEntity<TblIngreXProd> createTblIngreXProdById(@RequestBody TblIngreXProd p){
		
		TblIngreXProd newProduct=pRepository.save(p);
		
		return ResponseEntity.ok(newProduct);
	}
	
	


	

}
