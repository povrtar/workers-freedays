package godisnji.odmori.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import godisnji.odmori.model.Odsustvo;


@Repository
public interface OdsustvoRepository extends JpaRepository<Odsustvo, Long>{
	@Query("SELECT o FROM Odsustvo o WHERE" +
			"(:radnikId = NULL OR o.radnik.id= :radnikId)")  
			
	List<Odsustvo> search(@Param("radnikId") Long radnikId);

	

}
