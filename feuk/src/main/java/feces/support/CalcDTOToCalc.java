package feces.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import feces.model.Calc;
import feces.service.CalcService;
import feces.web.dto.CalcDTO;

@Component
public class CalcDTOToCalc implements Converter<CalcDTO, Calc> {
	@Autowired
	CalcService calcService;
	@Override
	public Calc convert(CalcDTO calcDTO) {
		Calc ret = new Calc();
		ret.setIdcalc(calcDTO.getIdcalc());
		ret.setNamirnica(calcDTO.getNamirnica());
		ret.setKolicina(calcDTO.getKolicina());
		return ret;
	}
	public List<Calc> convert (List<CalcDTO> calciDTO){
		List<Calc> ret = new ArrayList<>();
		for(CalcDTO dto : calciDTO){
			ret.add(convert(dto));
		}
		return ret;
	}
}