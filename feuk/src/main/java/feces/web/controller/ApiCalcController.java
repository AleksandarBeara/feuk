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

import feces.model.Calc;
import feces.service.CalcService;
import feces.support.CalcDTOToCalc;
import feces.support.CalcToCalcDTO;
import feces.web.dto.CalcDTO;

@RestController
@RequestMapping(value = "/api/calc")
public class ApiCalcController {
	@Autowired
	private CalcService calcService;
	@Autowired
	private CalcToCalcDTO toDTO;
	@Autowired
	private CalcDTOToCalc toCalc;
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<CalcDTO>> getAllCalc(
//			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "pagecalc", required=true) int pagecalc,
			@RequestParam(value = "numbercalc", required=true) int numbercalc) {
		List<Calc> calci;
		Page<Calc> calciPage;
		int totalpagescalc = 0;
		int totalcalci = 0;
		calciPage = calcService.getAll(pagecalc, numbercalc);
		calci = calciPage.getContent();
		totalpagescalc = calciPage.getTotalPages();
		totalcalci = (int) calciPage.getTotalElements();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("totalpagescalc", "" + totalpagescalc);
		httpHeaders.add("totalcalci", "" + totalcalci);
		return new ResponseEntity<>(toDTO.convert(calci), httpHeaders, HttpStatus.OK);
	}
	@RequestMapping(value="/{idcalc}", method=RequestMethod.GET)
	ResponseEntity<CalcDTO> findOne(@PathVariable Long idcalc){
		Calc calc = calcService.findOne(idcalc);
		if(calc==null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toDTO.convert(calc),HttpStatus.OK);
	}
	@RequestMapping(value="/{idcalc}", method=RequestMethod.DELETE)
	ResponseEntity<CalcDTO> delete(@PathVariable Long idcalc){
		Calc deleted = calcService.delete(idcalc);
		return new ResponseEntity<>(toDTO.convert(deleted),HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<CalcDTO> add(@RequestBody CalcDTO newCalc){
		Calc savedCalc = calcService.save(toCalc.convert(newCalc));
		return new ResponseEntity<>(toDTO.convert(savedCalc), HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/{idcalc}", consumes="application/json")
	public ResponseEntity<CalcDTO> edit(@RequestBody CalcDTO calc,
			@PathVariable Long idcalc) {
		if(idcalc != calc.getIdcalc()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Calc persisted = calcService.save(toCalc.convert(calc));
		return new ResponseEntity<>(toDTO.convert(persisted),HttpStatus.OK);
	}
}