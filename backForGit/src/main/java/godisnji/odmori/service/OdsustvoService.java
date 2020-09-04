package godisnji.odmori.service;

import java.util.List;
import java.util.Optional;

import godisnji.odmori.model.Odsustvo;

public interface OdsustvoService {

	List<Odsustvo> all();
	Optional<Odsustvo> one(Long id);
	Odsustvo save(Odsustvo sprint);
	List<Odsustvo> search(Long radnikId);

}
