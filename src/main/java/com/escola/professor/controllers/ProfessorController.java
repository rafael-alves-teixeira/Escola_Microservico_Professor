package com.escola.professor.controllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.escola.professor.entities.Professor;
import com.escola.professor.services.ProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Professor>>  findAll() {
		
		return ResponseEntity.ok(professorService.findAll()); 		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Professor> findById(@PathVariable  Long id){
		return professorService.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());		
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Professor> post(@Valid @RequestBody Professor Professor){
		return professorService.cadastrarProfessor(Professor)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());	
	} 
	
	@PutMapping("/atualizar")
	public ResponseEntity<Professor> putProfessor(@Valid @RequestBody Professor professor) {
		
		return professorService.atualizarProfessor(professor)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Professor> professor = professorService.findById(id);
		
		if(professor.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		professorService.deleteById(id);
	}	
	
	
}
