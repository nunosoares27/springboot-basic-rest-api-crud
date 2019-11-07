package dev.nunosoares.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.nunosoares.model.Food;
import dev.nunosoares.repository.FoodRepository;

@RestController
@RequestMapping(value="/api/food" )
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@GetMapping(value="/{id}", produces = "application/json" )
	public ResponseEntity<Food> init(@PathVariable (value="id") Long id) {
		
		Optional<Food> food = foodRepository.findById(id);
		
		return new ResponseEntity<Food>(food.get(), HttpStatus.OK);
		
	}
	
	@GetMapping(value="/", produces = "application/json" )
	public ResponseEntity<List<Food>> food () {
		
		List<Food> foods = (List<Food>) foodRepository.findAll();
		
		return new ResponseEntity<List<Food>>(foods, HttpStatus.OK);
		
	}	
	
	@PostMapping(value="/", produces = "application/json")
	public ResponseEntity<Food> addFood(@RequestBody Food food){
		Food newFood = foodRepository.save(food);
		return new ResponseEntity<Food>(newFood, HttpStatus.OK);
	}
	
	@PutMapping(value="/", produces = "application/json")
	public ResponseEntity<Food> updateFood(@RequestBody Food food){
		Food updateFood = foodRepository.save(food);
		return new ResponseEntity<Food>(updateFood, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces="application/json")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		foodRepository.deleteById(id);
		
		return new ResponseEntity("Apagado com sucesso", HttpStatus.OK);
		
	}
	
}
