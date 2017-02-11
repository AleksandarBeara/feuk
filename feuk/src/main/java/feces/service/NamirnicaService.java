package feces.service;

import java.util.List;

import org.springframework.data.domain.Page;

import feces.model.Namirnica; 

public interface NamirnicaService {
	Namirnica findOne(Long id);
	Page<Namirnica> findAll(int page, int number);
	List<Namirnica> findAll();
	List<Namirnica> findByName(String name);
	Namirnica save(Namirnica namirnica);
	List<Namirnica> save(List<Namirnica> namirnice);
	Page<Namirnica> findByName(String name, int page, int number);
	Namirnica delete(Long id);
	void remove(List<Namirnica> ids);
}