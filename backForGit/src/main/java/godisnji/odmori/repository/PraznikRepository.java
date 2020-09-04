package godisnji.odmori.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import godisnji.odmori.model.Praznik;



@Repository
public interface PraznikRepository extends JpaRepository<Praznik, Long>{

}
