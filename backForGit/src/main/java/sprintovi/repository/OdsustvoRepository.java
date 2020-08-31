package sprintovi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sprintovi.model.Odsustvo;

@Repository
public interface OdsustvoRepository extends JpaRepository<Odsustvo, Long>{

}
