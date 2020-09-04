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

import godisnji.odmori.model.Odeljenje;

import godisnji.odmori.service.OdeljenjeService;
import godisnji.odmori.support.OdeljenjeDtoToOdeljenje;
import godisnji.odmori.support.OdeljenjeToOdeljenjeDto;
import godisnji.odmori.web.dto.OdeljenjeDto;

@RestController
@RequestMapping("api/odeljenja")
public class ApiOdeljenjeController {

	@Autowired
	private OdeljenjeService odeljenjeService;
	
	@Autowired
	private OdeljenjeToOdeljenjeDto toDto;
	@Autowired
	private OdeljenjeDtoToOdeljenje toEntity;
	@GetMapping
	public ResponseEntity<List<OdeljenjeDto>> getAll(
			@RequestParam(required = false) String name){
		
		List<Odeljenje> stanja = odeljenjeService.all();
		return new ResponseEntity<>(toDto.convert(stanja), HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<OdeljenjeDto> getOne(
			@PathVariable Long id){
		
		Optional<Odeljenje> odeljenje = odeljenjeService.one(id);
		if(odeljenje.isPresent()) {
			Odeljenje odeljenjeEntity=(Odeljenje) odeljenje.get();
		
		return new ResponseEntity<>(toDto.convert(odeljenjeEntity), HttpStatus.OK);}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping
	public ResponseEntity<OdeljenjeDto> save(@Validated @RequestBody OdeljenjeDto dto){
		Odeljenje saved = odeljenjeService.save(toEntity.convert(dto));

		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<OdeljenjeDto> put(@PathVariable Long id,@Validated @RequestBody OdeljenjeDto dto){
		if(id==dto.getId()) {
		Odeljenje saved = odeljenjeService.save(toEntity.convert(dto));

		return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<OdeljenjeDto> delete(
			@PathVariable Long id){
		
		Optional<Odeljenje> odeljenje = odeljenjeService.one(id);
		if(odeljenje.isPresent()) {
			Odeljenje odeljenjeEntity=(Odeljenje) odeljenje.get();
		odeljenjeService.deleteById(id);
		return new ResponseEntity<>(toDto.convert(odeljenjeEntity), HttpStatus.OK);}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
