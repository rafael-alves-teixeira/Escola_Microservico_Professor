package com.escola.professor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_professor")
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "É obrigatório informar o nome!")
	private String name;
	
	@NotBlank(message = "É obrigatório informar a especialidade!")
	private String specialty;
	
	@Email(message = "Precisa informar um email válido!")
	@NotBlank(message = "É obrigatório informar o email!")
	private String professor;
	
	public Professor() {
	}

	public Professor(Long id, String name, String specialty, String professor) {
		this.id = id;
		this.name = name;
		this.specialty = specialty;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	public String getProfessor() {
		return professor;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
}
