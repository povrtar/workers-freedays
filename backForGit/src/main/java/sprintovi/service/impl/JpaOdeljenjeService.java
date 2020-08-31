package sprintovi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintovi.model.Odeljenje;
import sprintovi.repository.OdeljenjeRepository;
import sprintovi.service.OdeljenjeService;

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

}
