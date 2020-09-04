package godisnji.odmori.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import godisnji.odmori.model.Odeljenje;
import godisnji.odmori.model.Odsustvo;
import godisnji.odmori.model.Radnik;
import godisnji.odmori.service.OdeljenjeService;
import godisnji.odmori.service.OdsustvoService;
import godisnji.odmori.service.RadnikService;
import godisnji.odmori.web.dto.RadnikDto;

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