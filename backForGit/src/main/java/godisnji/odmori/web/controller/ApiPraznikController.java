package godisnji.odmori.web.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import godisnji.odmori.model.Praznik;
import godisnji.odmori.service.PraznikService;
import godisnji.odmori.support.PraznikToPraznikDto;
import godisnji.odmori.web.dto.PraznikDto;

@RestController
@RequestMapping("api/praznici")
public class ApiPraznikController {

	@Autowired
	private PraznikService praznikService;
	@Autowired
	private PraznikToPraznikDto toDto;
	
	
	@GetMapping
	public ResponseEntity<List<PraznikDto>> getAll(
			@RequestParam(required = false) String name){
		
		List<Praznik> praznici = praznikService.all();
		return new ResponseEntity<>(toDto.convert(praznici), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Praznik> save(@Validated @RequestBody Praznik praznik){
		Praznik saved = praznikService.save(praznik);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Praznik> put(@PathVariable Long id,@Validated @RequestBody Praznik praznik){
		if(id==praznik.getId()) {
		Praznik saved = praznikService.save(praznik);

		return new ResponseEntity<>(saved, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Praznik> delete(
			@PathVariable Long id){
		
		Optional<Praznik> praznikOpt = praznikService.one(id);
		if(praznikOpt.isPresent()) {
			Praznik praznik=praznikOpt.get();
		praznikService.deleteById(id);
		return new ResponseEntity<>(praznik, HttpStatus.OK);}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
