package godisnji.odmori.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import godisnji.odmori.model.Odeljenje;
import godisnji.odmori.model.Radnik;
import godisnji.odmori.repository.OdeljenjeRepository;
import godisnji.odmori.repository.RadnikRepository;
import godisnji.odmori.service.RadnikService;


@Service
@Transactional
public class JpaRadnikService implements RadnikService {
	
	
	@Autowired
	private RadnikRepository zadatakRepository;
	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	@Autowired
	private RadnikRepository radnikRepository;
	
	
	
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
		if(radnik.getId()!=null) {
		if(!(radnik.getOdeljenje().equals(radnikRepository.getOne(radnik.getId())))){
			Odeljenje staroOdeljenje=radnikRepository.getOne(radnik.getId()).getOdeljenje();
			List<Radnik> radnici=staroOdeljenje.getRadnici();
			radnici.remove(radnik);
			staroOdeljenje.setRadnici(radnici);
			odeljenjeRepository.save(staroOdeljenje);
		}}
		Odeljenje odeljenje=radnik.getOdeljenje();
		List<Radnik> radnici=odeljenje.getRadnici();
		if(!radnici.contains(radnik)) {
		radnici.add(radnik);
		odeljenje.setRadnici(radnici);
		odeljenjeRepository.save(odeljenje);
		}
		Long naStazIOdeljenje=radnik.getGodinaStaza()/5+radnik.getOdeljenje().getBonusSlobodihDana();
		radnik.setSlobodnihDana(20L+naStazIOdeljenje);
		return zadatakRepository.save(radnik);
	}

	
}
