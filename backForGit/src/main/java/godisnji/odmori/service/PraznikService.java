package godisnji.odmori.service;

import java.util.List;
import java.util.Optional;


import godisnji.odmori.model.Praznik;

public interface PraznikService {

	List<Praznik> all();
	Optional<Praznik> one(Long id);
	Praznik save(Praznik praznik);
Praznik deleteById(Long id);
}
