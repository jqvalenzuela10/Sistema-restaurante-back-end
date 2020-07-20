package com.restaurant.products.rest;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;
import javax.websocket.server.PathParam;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restaurant.products.entitys.TblCar;
import com.restaurant.products.entitys.TblCategoria;
import com.restaurant.products.entitys.TblEmpleado;
import com.restaurant.products.entitys.TblProducto;
import com.restaurant.products.repository.ProductsRepository;
import com.restaurant.products.repository.UsersRepository;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/rest")
public class UsersRest {

	
	@Autowired
	UsersRepository pRepository;
	
	
	
	/*listado por Id*/
	
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<TblEmpleado> getUserById(@PathVariable("userId")int userId) {
		
		Optional<TblEmpleado> category=pRepository.findById(userId);
		
		if(!category.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		
		return new ResponseEntity(category.get(),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/users")
	public ResponseEntity<TblEmpleado> getProducts() {
		
		List<TblEmpleado> lista=pRepository.findAllUsers();
		return new ResponseEntity(lista, HttpStatus.OK) ;
	}
	

	
	
	@PostMapping(value = "/login", produces = "application/json")
	public String login(@RequestBody TblEmpleado t) {
		

		
		System.out.println("el codigo es "+t.getIdEmpleado());
		
		TblEmpleado lista=pRepository.validar(t.getIdEmpleado(),t.getClave());
//		String ok = "{'status': 'ok' }";	
//		String error = "{ 'status': 'error' }";	
//		JsonObject okjson = new Gson().fromJson(ok, JsonObject.class);
//		JsonObject errorjson = new Gson().fromJson(error, JsonObject.class);
//		
//		System.out.println(okjson);
//		System.out.println(errorjson);
		if(lista!=null) {
			
			
			return "{\"status\":\"ok\"}";
		
		}
		return  "{\"status\":\"error\"}";
	
	}
	
	
	
/*insertar una categoria*/
	
	@PostMapping(value = "/users")
	public ResponseEntity<TblEmpleado> createUser(@RequestBody TblEmpleado p){
		
		TblEmpleado newcargo=pRepository.save(p);
		
		return ResponseEntity.ok(newcargo);
	}
	
	
	
	
	
	
/*eliminar una categoria*/
	
	@DeleteMapping(value = "/users/{userId}")
	public String deleteUser(@PathVariable("userId") int userId){
		
		Optional<TblEmpleado> cargo = pRepository.findById(userId);

		if(!cargo.isPresent()) {
			return  "{'response':'no se ha encontrado el elemento'}";
		}
		
		try {
			pRepository.deleteById(userId);
			
			return "{\"status\":\"ok\"}";
		} catch (Exception e) {
			// TODO: handle exception
			return  "{\"status\":\"error\"}";
		}
		
		
	}
}
