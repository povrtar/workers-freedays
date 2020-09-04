package godisnji.odmori.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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

import godisnji.odmori.model.Odsustvo;
import godisnji.odmori.model.Radnik;
import godisnji.odmori.service.OdsustvoService;
import godisnji.odmori.service.RadnikService;
import godisnji.odmori.support.OdsustvoDtoToOdsustvo;
import godisnji.odmori.support.OdsustvoToOdsustvoDto;
import godisnji.odmori.web.dto.OdsustvoDto;
import godisnji.odmori.web.dto.RadnikDto;

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
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<OdsustvoDto>> get(@RequestParam(value = "radnikId", required = false) Long radnikId) {

		List<Odsustvo> odsustva = null;

		if (radnikId != null ) {
			odsustva = odsustvoService.search(radnikId);
	} else {
			odsustva = odsustvoService.all();
		}

		

		return new ResponseEntity<>(toDto.convert(odsustva), HttpStatus.OK);
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
