package feces.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import feces.model.Namirnica;
import feces.web.dto.NamirnicaDTO;

@Component
public class NamirnicaToNamirnicaDTO implements Converter<Namirnica, NamirnicaDTO> {
	@Override
	public NamirnicaDTO convert(Namirnica namirnica) {
		NamirnicaDTO ret = new NamirnicaDTO();
		ret.setId(namirnica.getId());
		ret.setName(namirnica.getName());
		ret.setKalorije(namirnica.getKalorije());
		ret.setUgljeniHidrati(namirnica.getUgljeniHidrati());
		ret.setMasti(namirnica.getMasti());
		ret.setProteini(namirnica.getProteini());
		ret.setSecer(namirnica.getSecer());
		return ret;
	}
	public List<NamirnicaDTO> convert(List<Namirnica> namirnice){
		List<NamirnicaDTO> ret = new ArrayList<>();
		for(Namirnica n: namirnice){
			ret.add(convert(n));
		}
		return ret;
	}
}