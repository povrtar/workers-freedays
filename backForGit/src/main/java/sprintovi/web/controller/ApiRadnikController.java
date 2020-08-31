package sprintovi.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sprintovi.model.Radnik;
import sprintovi.service.RadnikService;
import sprintovi.support.RadnikDtoToRadnik;
import sprintovi.support.RadnikToRadnikDto;
import sprintovi.web.dto.RadnikDto;

@RestController
@RequestMapping(value = "/api/radnici")
public class ApiRadnikController {
	@Autowired
	private RadnikService zadatakService;

	@Autowired
	private RadnikToRadnikDto toDTO;
	@Autowired
	private RadnikDtoToRadnik toRadnik;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<RadnikDto>> get(@RequestParam(value = "jmbg", required = false) String jmbg,
			@RequestParam(value = "idOdeljenja", required = false) Long idOdeljenja,
			@RequestParam(value = "pageNum", defaultValue = "0") int pageNum) {

		Page<Radnik> page = null;

		if (jmbg != null || idOdeljenja != null) {
			page = zadatakService.search(jmbg, idOdeljenja, pageNum);
	} else {
			page = zadatakService.all(pageNum);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toDTO.convert(page.getContent()), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<RadnikDto> getOne(@PathVariable Long id) {
		Optional<Radnik> zadatak = zadatakService.one(id);
		if (!zadatak.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(zadatak.get()), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<RadnikDto> delete(@PathVariable Long id) {
		Radnik deleted = zadatakService.delete(id);

		if (deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(deleted), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RadnikDto> add(@Validated @RequestBody RadnikDto newDto) {

		Radnik saved = zadatakService.save(toRadnik.convert(newDto));

		return new ResponseEntity<>(toDTO.convert(saved), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}", consumes = "application/json")
	public ResponseEntity<RadnikDto> edit(@Validated @RequestBody RadnikDto zadatakDTO, @PathVariable Long id) {

		if (!id.equals(zadatakDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Radnik persisted = zadatakService.save(toRadnik.convert(zadatakDTO));

		return new ResponseEntity<>(toDTO.convert(persisted), HttpStatus.OK);
	}

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
