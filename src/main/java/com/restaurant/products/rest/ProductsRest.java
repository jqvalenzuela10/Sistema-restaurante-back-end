package com.restaurant.products.rest;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.PresentationDirection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblProducto;

import com.restaurant.products.repository.ProductsRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class ProductsRest {
	
	@Autowired
	ProductsRepository pRepository;
	
	
	
	

	@GetMapping(value = "/products")
	public ResponseEntity<TblProducto> getProducts() {
		
		List<TblProducto> lista=pRepository.findAllProducts();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	

	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<TblProducto> getProductById(@PathVariable("productId")int productId) {
		
		Optional<TblProducto> product=pRepository.findById(productId);
		
		if(!product.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(product.get(),HttpStatus.OK);
	}
	

	@PostMapping(value = "/products")
	public ResponseEntity<TblProducto> createProduct(@RequestBody TblProducto p){
		
		TblProducto newProduct=pRepository.save(p);
		
		return ResponseEntity.ok(newProduct);
	}
	
	@PostMapping(value = "/productos")
	public ResponseEntity<TblProducto> watson(){
		Optional<TblProducto> product=pRepository.findById(1);
		
		
			return new ResponseEntity(product.get(),HttpStatus.OK); 
	
	}
//	@PostMapping(value = "/load")
//	public List<TblProducto> persist(@RequestBody final TblProducto pro){
//		pRepository.save(pro);
//		return pRepository.findAll();
//	}
//	
	
	@DeleteMapping(value = "/products/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId){
		
		Optional<TblProducto> product = pRepository.findById(productId);

		if(!product.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(productId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, esta categoria esta relacionada con algun producto'}";
		}
		
		
	}
	
	
	@PutMapping(value="/products")
	public ResponseEntity<TblProducto> updateProduct(@RequestBody TblProducto product){
		
		Optional<TblProducto> optional=pRepository.findById(product.getIdProducto());
		
		if(optional.isPresent()) {
			TblProducto newProduct=optional.get();
			newProduct.setTblCategoria(product.getTblCategoria());
			newProduct.setNombre(product.getNombre());
			newProduct.setPrecio(product.getPrecio());
			newProduct.setDescripcion(product.getDescripcion());
			
			pRepository.save(newProduct);
			return ResponseEntity.ok(newProduct);
			
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
