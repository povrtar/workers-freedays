package sprintovi.service;

import java.util.List;
import java.util.Optional;

import sprintovi.model.Odsustvo;

public interface OdsustvoService {

	List<Odsustvo> all();
	Optional<Odsustvo> one(Long id);
	Odsustvo save(Odsustvo sprint);

}
