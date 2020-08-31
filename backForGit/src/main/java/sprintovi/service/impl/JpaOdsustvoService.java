package sprintovi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sprintovi.model.Odsustvo;
import sprintovi.model.Radnik;
import sprintovi.repository.OdsustvoRepository;
import sprintovi.repository.RadnikRepository;
import sprintovi.service.OdsustvoService;

@Service
public class JpaOdsustvoService implements OdsustvoService {
	@Autowired
	RadnikRepository radnikRepository;
	@Autowired
	private OdsustvoRepository sprintRepository;

	@Override
	public List<Odsustvo> all() {
		return sprintRepository.findAll();
	}

	@Override
	public Optional<Odsustvo> one(Long id) {
		return sprintRepository.findById(id);
	}

	@Override
	public Odsustvo save(Odsustvo sprint) {
		Radnik radnik=radnikRepository.getOne(sprint.getRadnik().getId());
		radnik.setSlobodnihDana(radnik.getSlobodnihDana()-sprint.getRadnihDana());
		radnikRepository.save(radnik);
		return sprintRepository.save(sprint);
	}
	
	
}
