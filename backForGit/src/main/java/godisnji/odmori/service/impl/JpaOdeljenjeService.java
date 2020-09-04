package godisnji.odmori.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import godisnji.odmori.model.Odeljenje;
import godisnji.odmori.repository.OdeljenjeRepository;
import godisnji.odmori.service.OdeljenjeService;

@Service
public class JpaOdeljenjeService implements OdeljenjeService {
	
	@Autowired
	private OdeljenjeRepository stanjeRepository;

	@Override
	public List<Odeljenje> all() {
		return stanjeRepository.findAll();
	}

	@Override
	public Optional<Odeljenje> one(Long id) {
		return stanjeRepository.findById(id);
	}

	@Override
	public Odeljenje save(Odeljenje stanje) {
		return stanjeRepository.save(stanje);
	}

	@Override
	public Odeljenje deleteById(Long id) {
		Optional<Odeljenje> odeljenje=stanjeRepository.findById(id);
		if(odeljenje.isPresent()){
			stanjeRepository.deleteById(id);
		}
		return odeljenje.get();
	}

}
