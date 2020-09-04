package godisnji.odmori.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import godisnji.odmori.model.Praznik;

import godisnji.odmori.repository.PraznikRepository;

import godisnji.odmori.service.PraznikService;

@Service
public class JpaPraznikService implements PraznikService {
	
	@Autowired
	private PraznikRepository praznikRepository;

	@Override
	public List<Praznik> all() {
		return praznikRepository.findAll();
	}

	@Override
	public Optional<Praznik> one(Long id) {
		return praznikRepository.findById(id);
	}

	@Override
	public Praznik save(Praznik praznik) {
		return praznikRepository.save(praznik);
	}

	@Override
	public Praznik deleteById(Long id) {
		Optional<Praznik> praznik=praznikRepository.findById(id);
		if(praznik.isPresent()){
			praznikRepository.deleteById(id);
		}
		return praznik.get();
	}

}
