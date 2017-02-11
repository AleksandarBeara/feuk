package feces.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feces.model.Namirnica;
import feces.service.NamirnicaService;
import feces.support.NamirnicaDTOToNamirnica;
import feces.support.NamirnicaToNamirnicaDTO;
import feces.web.dto.NamirnicaDTO;

@RestController
@RequestMapping(value = "/api/namirnice")
public class ApiNamirnicaController {
	@Autowired
	private NamirnicaService namirnicaService;
	@Autowired
	private NamirnicaToNamirnicaDTO toDTO;
	@Autowired
	private NamirnicaDTOToNamirnica toNamirnica;
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<NamirnicaDTO>> getNamirnice(
			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "page", required=true) int page,
			@RequestParam(value = "number", required=true) int number) {
		List<Namirnica> namirnice;
		Page<Namirnica> namirnicePage;
		int totalpages = 0;
		int totalnamirnice = 0;
		if (name != null) {
			namirnicePage = namirnicaService.findByName(name, page, number);
			totalpages = namirnicePage.getTotalPages();
			namirnice = namirnicePage.getContent();
		} else {
			namirnicePage = namirnicaService.findAll(page, number);
			namirnice = namirnicePage.getContent();
			totalpages = namirnicePage.getTotalPages();
			totalnamirnice = (int) namirnicePage.getTotalElements();
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("totalpages", "" + totalpages);
		httpHeaders.add("totalnamirnice", "" + totalnamirnice);
		return new ResponseEntity<>(toDTO.convert(namirnice), httpHeaders, HttpStatus.OK);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<NamirnicaDTO> getnamirnica(@PathVariable Long id){
		Namirnica namirnica = namirnicaService.findOne(id);
		if(namirnica==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDTO.convert(namirnica),HttpStatus.OK);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<NamirnicaDTO> delete(@PathVariable Long id){
		Namirnica deleted = namirnicaService.delete(id);
		return new ResponseEntity<>(toDTO.convert(deleted),HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<NamirnicaDTO> add(@RequestBody NamirnicaDTO newNamirnica){
		Namirnica savedNamirnica = namirnicaService.save(toNamirnica.convert(newNamirnica));
		return new ResponseEntity<>(toDTO.convert(savedNamirnica), HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<NamirnicaDTO> edit(@RequestBody NamirnicaDTO namirnica,
			@PathVariable Long id) {
		if(id != namirnica.getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Namirnica persisted = namirnicaService.save(toNamirnica.convert(namirnica));
		return new ResponseEntity<>(toDTO.convert(persisted),HttpStatus.OK);
	}
}