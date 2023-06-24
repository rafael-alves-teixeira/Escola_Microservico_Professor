package com.escola.professor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.professor.entities.Professor;
import com.escola.professor.repositories.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	public ProfessorRepository professorRepository;
	
	
	public List<Professor> findAll() {
		List<Professor> professor = professorRepository.findAll();
		return professor;

	}
	
	public Optional<Professor> findById(Long id) {
		Optional<Professor> professor = professorRepository.findById(id);
		return professor;
	}

	public Optional<Professor> cadastrarProfessor(Professor professor) {
		
		if(professorRepository.findByProfessor(professor.getProfessor()).isPresent()) {
			return Optional.empty();
	}
		
		return Optional.of(professorRepository.save(professor));		
	}

	public Optional<Professor> atualizarProfessor(Professor professor) {
		
		if(professorRepository.findById(professor.getId()).isPresent()) {
						
			return Optional.ofNullable(professorRepository.save(professor));
		}
		
		return Optional.empty();
	}
	

	public void deleteById(Long id) {
		
		if(professorRepository.findById(id).isPresent()) {	
			
			professorRepository.deleteById(id);
		}		
	}

	
}
