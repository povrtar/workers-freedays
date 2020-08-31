package sprintovi.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sprintovi.model.Odeljenje;
import sprintovi.service.OdeljenjeService;
import sprintovi.support.OdeljenjeToOdeljenjeDto;
import sprintovi.web.dto.OdeljenjeDto;

@RestController
@RequestMapping("api/odeljenja")
public class ApiOdeljenjeController {

	@Autowired
	private OdeljenjeService stanjeService;
	
	@Autowired
	private OdeljenjeToOdeljenjeDto toDto;
	
	@GetMapping
	public ResponseEntity<List<OdeljenjeDto>> getAll(
			@RequestParam(required = false) String name){
		
		List<Odeljenje> stanja = stanjeService.all();
		return new ResponseEntity<>(toDto.convert(stanja), HttpStatus.OK);
	}
	
}
