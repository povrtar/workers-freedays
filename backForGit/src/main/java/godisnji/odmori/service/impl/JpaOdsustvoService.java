package godisnji.odmori.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import godisnji.odmori.model.Odsustvo;
import godisnji.odmori.model.Praznik;
import godisnji.odmori.model.Radnik;
import godisnji.odmori.repository.OdsustvoRepository;
import godisnji.odmori.repository.PraznikRepository;
import godisnji.odmori.repository.RadnikRepository;
import godisnji.odmori.service.OdsustvoService;

@Service
public class JpaOdsustvoService implements OdsustvoService {
	@Autowired
	RadnikRepository radnikRepository;
	@Autowired
	private OdsustvoRepository sprintRepository;
@Autowired
private PraznikRepository praznikRepository;

	@Override
	public List<Odsustvo> all() {
		return sprintRepository.findAll();
	}

	@Override
	public Optional<Odsustvo> one(Long id) {
		return sprintRepository.findById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Odsustvo save(Odsustvo odsustvo) {
		 List<Praznik> praznici=praznikRepository.findAll();
		Radnik radnik=radnikRepository.getOne(odsustvo.getRadnik().getId());
		Long radnihDana=odsustvo.getRadnihDana();
		radnik.setSlobodnihDana(radnik.getSlobodnihDana()-radnihDana);
		radnikRepository.save(radnik);
		Date datumPocetka=odsustvo.getDatumPocetka();
		Date datum=new Date();
		 datum.setMonth(datumPocetka.getMonth());
		 datum.setDate(datumPocetka.getDate());
		 datum.setYear(datumPocetka.getYear());
		Date datumPovratka=new Date();
		datumPovratka.setYear(datumPocetka.getYear());
		datumPovratka.setMonth(datumPocetka.getMonth());
		int dani=odsustvo.getRadnihDana().intValue();
		for(int i=0;i<dani;i++) {
		if(datum.getDay()>5||datum.getDay()==0||isPraznik(datum,praznici)) {		
			dani=dani+1;}
		datum.setDate(datum.getDate()+1);
			System.out.println("dan nedelji="+datum.getDay());
		
		}
		System.out.println("dani sa vikendima="+dani);
		datumPovratka.setDate(datumPocetka.getDate()+dani);
		
		odsustvo.setDatumPovratka(datumPovratka);
		System.out.println("odsustvo= "+odsustvo.toString());
		return sprintRepository.save(odsustvo);
	}

	@SuppressWarnings("deprecation")
	private boolean isPraznik(Date datum,List<Praznik> praznici) {
		
		for (Praznik praznik:praznici) {
			if(praznik.getDatum().getDate()==datum.getDate()&&praznik.getDatum().getMonth()==datum.getMonth()&&praznik.getDatum().getYear()==datum.getYear()) {
				System.out.println("PRAZNIK JE");
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Odsustvo> search(Long radnikId) {
		
		return sprintRepository.search( radnikId);
	}
	
	
}
