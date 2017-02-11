package feces.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import feces.model.Calc;
import feces.web.dto.CalcDTO;

@Component
public class CalcToCalcDTO implements Converter<Calc, CalcDTO> {
	@Override
	public CalcDTO convert(Calc calc) {
		CalcDTO ret = new CalcDTO();
		ret.setIdcalc(calc.getIdcalc());
		ret.setNamirnica(calc.getNamirnica());
		ret.setKolicina(calc.getKolicina());
		return ret;
	}
	public List<CalcDTO> convert(List<Calc> calci){
		List<CalcDTO> ret = new ArrayList<>();
		for(Calc c: calci){
			ret.add(convert(c));
		}
		return ret;
	}
}