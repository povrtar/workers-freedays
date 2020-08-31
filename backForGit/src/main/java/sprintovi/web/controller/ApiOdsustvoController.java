package sprintovi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sprintovi.model.Odsustvo;
import sprintovi.model.Radnik;
import sprintovi.service.OdsustvoService;
import sprintovi.service.RadnikService;
import sprintovi.support.OdsustvoDtoToOdsustvo;
import sprintovi.support.OdsustvoToOdsustvoDto;
import sprintovi.web.dto.OdsustvoDto;
import sprintovi.web.dto.RadnikDto;

@RestController
@RequestMapping("api/odsustva")
public class ApiOdsustvoController {
	@Autowired
	RadnikService radnikService;
	@Autowired
	private OdsustvoService odsustvoService;
	
	@Autowired
	private OdsustvoToOdsustvoDto toDto;
	@Autowired
	private OdsustvoDtoToOdsustvo toEntity;
	@GetMapping
	public ResponseEntity<List<OdsustvoDto>> getAll(
			@RequestParam(required = false) String name){
		
		List<Odsustvo> sprintovi = odsustvoService.all();
		return new ResponseEntity<>(toDto.convert(sprintovi), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<OdsustvoDto> add(@Validated @RequestBody OdsustvoDto newDto) {
		System.out.println("OdsustvoDto ="+newDto.toString());
Radnik radnik=radnikService.one(newDto.getRadnikId()).get();
	
if(newDto.getRadnihDana()>radnik.getSlobodnihDana()) {
	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}else {

Odsustvo odsustvo=odsustvoService.save(toEntity.convert(newDto));
		return new ResponseEntity<>(toDto.convert(odsustvo), HttpStatus.CREATED);
	}
	}
}
