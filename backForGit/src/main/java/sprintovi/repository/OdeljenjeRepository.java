package sprintovi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sprintovi.model.Odeljenje;

@Repository
public interface OdeljenjeRepository extends JpaRepository<Odeljenje, Long>{

}
