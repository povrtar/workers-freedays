package sprintovi.service;

import java.util.List;
import java.util.Optional;

import sprintovi.model.Odeljenje;

public interface OdeljenjeService {

	List<Odeljenje> all();
	Optional<Odeljenje> one(Long id);
	Odeljenje save(Odeljenje stanje);

}
