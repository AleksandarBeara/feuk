package feces.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import feces.model.Namirnica;

@Repository
public interface NamirnicaRepository  extends JpaRepository<Namirnica, Long> {
	List<Namirnica> findByName(String name);
	Page<Namirnica> findByNameLike(String name, Pageable pageable);
	List<Namirnica> findByNameLike(String name);
	Page<Namirnica> findAll(Pageable pageable);
}