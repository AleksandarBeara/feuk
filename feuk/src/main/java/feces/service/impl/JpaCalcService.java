package feces.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import feces.model.Calc;
import feces.repository.CalcRepository;
import feces.service.CalcService;

@Service
@Transactional
public class JpaCalcService implements CalcService {
	@Autowired
	private CalcRepository calcRepository;
	@Override
	public Page<Calc> getAll(int pagecalc, int numbercalc) {
		return calcRepository.findAll(new PageRequest(pagecalc, numbercalc));
	}
	@Override
	public Calc findOne(Long idcalc) {
		return calcRepository.findOne(idcalc);
	}
	@Override
	public Calc save(Calc calc) {
		return calcRepository.save(calc);
	}
	@Override
	public Calc delete(Long idcalc) {
		Calc calc = calcRepository.findOne(idcalc);
		if (calc==null) {
			throw new IllegalArgumentException(
					"Removing nonexistant meal");
		}
		calcRepository.delete(calc);
		return calc;
	}
	@Override
	public List<Calc> findAll() {
		return calcRepository.findAll();
	}
}
