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
import com.restaurant.products.entitys.TblProveedore;
import com.restaurant.products.repository.CategoriesRepository;
import com.restaurant.products.repository.ProveedoresRepository;

@RestController
@RequestMapping("/rest")
public class ProveedoresRest {

	
	
	@Autowired
	ProveedoresRepository pRepository;
	
	
	
	/*listado*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/proveedores")
	public ResponseEntity<TblProveedore> getProveedores() {
		
		List<TblProveedore> lista=pRepository.findAllProveedores();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	
	
	
	/*listado por Id*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@GetMapping(value = "/proveedores/{proveedorId}")
	public ResponseEntity<TblProveedore> getProveedorById(@PathVariable("proveedorId")int proveedorId) {
		
		Optional<TblProveedore> proveedor=pRepository.findById(proveedorId);
		
		if(!proveedor.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(proveedor.get(),HttpStatus.OK);
	}

	
	
	
	/*insertar una categoria*/
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value = "/proveedores")
	public ResponseEntity<TblProveedore> createProveedor(@RequestBody TblProveedore p){
		
		TblProveedore newProveedor=pRepository.save(p);
		
		return ResponseEntity.ok(newProveedor);
	}
	
	
	/*eliminar una categoria*/
	
	@DeleteMapping(value = "/proveedores/{proveedorId}")
	public String deleteProveedor(@PathVariable("proveedorId") int proveedorId){
		
		Optional<TblProveedore> proveedor = pRepository.findById(proveedorId);

		if(!proveedor.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(proveedorId);
			
			return "{'response':'el elemento se ha eliminado'}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{'response':'no se puede eliminar, este proveedor esta relacionada con algun producto'}";
		}
		
		
	}
	

	/*actualizar categoria*/
	@PutMapping(value = "/proveedores")
	public ResponseEntity<TblProveedore> updateProveedor(@RequestBody TblProveedore proveedor){
		
		Optional<TblProveedore> c = pRepository.findById(proveedor.getIdProveedor());
		if(c.isPresent()) {
			TblProveedore newProveedor=c.get();
			newProveedor.setProveedor(proveedor.getProveedor());
			newProveedor.setNombreContacto(proveedor.getNombreContacto());
			newProveedor.setTelefonos(proveedor.getTelefonos());
			newProveedor.setSitioWeb(proveedor.getSitioWeb());
			
		
			pRepository.save(newProveedor);
			return ResponseEntity.ok(newProveedor);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
		
		
	}
}
