package feces.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import feces.model.Namirnica;
import feces.service.NamirnicaService;
import feces.web.dto.NamirnicaDTO;

@Component
public class NamirnicaDTOToNamirnica implements Converter<NamirnicaDTO, Namirnica> {
	@Autowired
	NamirnicaService namirnicaService;
	@Override
	public Namirnica convert(NamirnicaDTO namirnicaDTO) {
		Namirnica ret = new Namirnica();
		if(namirnicaDTO.getId()!=null){
			ret = namirnicaService.findOne(namirnicaDTO.getId());
		}
		ret.setId(namirnicaDTO.getId());
		ret.setName(namirnicaDTO.getName());
		ret.setKalorije(namirnicaDTO.getKalorije());
		ret.setUgljeniHidrati(namirnicaDTO.getUgljeniHidrati());
		ret.setMasti(namirnicaDTO.getMasti());
		ret.setProteini(namirnicaDTO.getProteini());
		ret.setSecer(namirnicaDTO.getSecer());
		return ret;
	}
	public List<Namirnica> convert (List<NamirnicaDTO> namirniceDTO){
		List<Namirnica> ret = new ArrayList<>();
		for(NamirnicaDTO dto : namirniceDTO){
			ret.add(convert(dto));
		}
		return ret;
	}
}