package godisnji.odmori.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import godisnji.odmori.model.Radnik;

@Repository
public interface RadnikRepository extends JpaRepository<Radnik, Long> {

	@Query("SELECT r FROM Radnik r WHERE" +
			"(:jmbg = NULL OR r.jmbg= :jmbg) AND " + 
			"(:idOdeljenja = NULL OR r.odeljenje.id = :idOdeljenja)")
	Page<Radnik> search(@Param("jmbg") String jmbg, @Param("idOdeljenja") Long idOdeljenja, Pageable pageable);

	
}
