package sprintovi.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import sprintovi.model.Odsustvo;
import sprintovi.model.Odeljenje;
import sprintovi.model.Radnik;
import sprintovi.repository.OdsustvoRepository;
import sprintovi.repository.OdeljenjeRepository;
import sprintovi.repository.RadnikRepository;
import sprintovi.service.RadnikService;
import sprintovi.support.RadnikDtoToRadnik;
import sprintovi.web.dto.RadnikDto;


@Service
@Transactional
public class JpaRadnikService implements RadnikService {
	
	@Autowired
	private RadnikDtoToRadnik toEntity;
	
	@Autowired
	private RadnikRepository zadatakRepository;
	
	@Autowired
	private OdsustvoRepository sprintRepository;
	
	@Autowired
	private OdeljenjeRepository stanjeRepository;
	
	@Override
	public Page<Radnik> all(int page) {
		return zadatakRepository.findAll(PageRequest.of(page, 5));
	}
	
	@Override
	public Page<Radnik> search(String jmbg, Long idOdeljenja, int page){
		
		
		
		return zadatakRepository.search(jmbg, idOdeljenja, PageRequest.of(page, 5));
	}

	@Override
	public Optional<Radnik> one(Long id) {
		return zadatakRepository.findById(id);
	}

	


	@Override
	public Radnik delete(Long id) {
		Optional<Radnik> zadatakOptional = zadatakRepository.findById(id);
		Radnik zadatak=zadatakOptional.get();
			
			zadatakRepository.deleteById(id);
			return zadatak;
		
		
		
	}


	@Override
	public Radnik save(Radnik radnik) {
		Long naStaz=radnik.getGodinaStaza()/5;
		radnik.setSlobodnihDana(20L+naStaz);
		return zadatakRepository.save(radnik);
	}

}
