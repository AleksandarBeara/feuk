package feces.service;

import java.util.List;

import org.springframework.data.domain.Page;

import feces.model.Calc;

public interface CalcService {
	Calc findOne(Long idcalc);
	Page<Calc> getAll(int pagecalc, int numbercalc);
	Calc save(Calc calc);
	Calc delete(Long idcalc);
	List<Calc> findAll();
}
