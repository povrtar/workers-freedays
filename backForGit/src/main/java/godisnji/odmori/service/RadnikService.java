package godisnji.odmori.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import godisnji.odmori.model.Radnik;
import godisnji.odmori.web.dto.RadnikDto;

public interface RadnikService {
	
	Page<Radnik> search(String jmbg, Long idOdeljenja, int pageNum);
	Page<Radnik> all(int page);
	Optional<Radnik> one(Long id);
	Radnik save(Radnik radnik);
	Radnik delete(Long id);
	
	
}
