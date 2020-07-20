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
import com.restaurant.products.entitys.TblProducto;
import com.restaurant.products.repository.CategoriesRepository;
import com.restaurant.products.repository.ProductsRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class CategoryRest {
	
	@Autowired
	CategoriesRepository pRepository;
	
	
	
	/*listado*/

	@GetMapping(value = "/categories")
	public ResponseEntity<TblCategoria> getCategories() {
		
		List<TblCategoria> lista=pRepository.findAllCategories();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	
	/*listado por Id*/
	
	@GetMapping(value = "/categories/{categoryId}")
	public ResponseEntity<TblCategoria> getCategoryById(@PathVariable("categoryId")int categoryId) {
		
		Optional<TblCategoria> category=pRepository.findById(categoryId);
		
		if(!category.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(category.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/

	@PostMapping(value = "/categories")
	public ResponseEntity<TblCategoria> createCategory(@RequestBody TblCategoria p){
		
		TblCategoria newcategory=pRepository.save(p);
		
		return ResponseEntity.ok(newcategory);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/categories/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId){
		
		Optional<TblCategoria> category = pRepository.findById(categoryId);

		if(!category.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(categoryId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, esta categoria esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/categories")
	public ResponseEntity<TblCategoria> updateCategory(@RequestBody TblCategoria category){
		
		Optional<TblCategoria> c = pRepository.findById(category.getIdCategoria());
		if(c.isPresent()) {
			TblCategoria updateCategory=c.get();
			updateCategory.setCateria(category.getCateria());
			pRepository.save(updateCategory);
			return ResponseEntity.ok(updateCategory);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
	
	
	
	
//	
//	@PostMapping(value = "/load")
//	public List<TblProducto> persist(@RequestBody final TblProducto pro){
//		pRepository.save(pro);
//		return pRepository.findAll();
//	}
}
	
	