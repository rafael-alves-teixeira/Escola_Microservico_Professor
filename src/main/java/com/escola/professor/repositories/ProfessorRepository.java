package com.escola.professor.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.professor.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
	
	public Optional<Professor> findByProfessor(String professor);


}
