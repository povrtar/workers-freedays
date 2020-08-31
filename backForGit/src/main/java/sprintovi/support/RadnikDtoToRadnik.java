package sprintovi.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sprintovi.model.Odsustvo;
import sprintovi.model.Odeljenje;
import sprintovi.model.Radnik;
import sprintovi.service.OdsustvoService;
import sprintovi.service.OdeljenjeService;
import sprintovi.service.RadnikService;
import sprintovi.web.dto.RadnikDto;

@Component
public class RadnikDtoToRadnik implements Converter<RadnikDto, Radnik>{

	
	
	@Autowired
	private OdeljenjeService stanjeService;
	
	@Override
	public Radnik convert(RadnikDto source) {
Radnik radnik=new Radnik();
radnik.setId(source.getId());
radnik.setEmail(source.getEmail());
radnik.setGodinaStaza(source.getGodineStaza());
radnik.setJmbg(source.getJmbg());
radnik.setImeIPrezime(source.getImeIPrezime());
radnik.setSlobodnihDana(source.getSlobodnihDana());
radnik.setOdeljenje(stanjeService.one(source.getOdeljenjeId()).get());
		return radnik;
}
	
}