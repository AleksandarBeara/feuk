package feces.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import feces.model.Calc;

public interface CalcRepository extends PagingAndSortingRepository<Calc, Long> {
	Page<Calc> findAll(Pageable pageable);
	List<Calc> findAll();
}