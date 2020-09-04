package godisnji.odmori.service;

import java.util.List;
import java.util.Optional;

import godisnji.odmori.model.Odeljenje;

public interface OdeljenjeService {

	List<Odeljenje> all();
	Optional<Odeljenje> one(Long id);
	Odeljenje save(Odeljenje stanje);
Odeljenje deleteById(Long id);
}
