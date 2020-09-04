package godisnji.odmori.support;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import godisnji.odmori.model.Odeljenje;
import godisnji.odmori.web.dto.OdeljenjeDto;

@Component
public class OdeljenjeDtoToOdeljenje implements Converter<OdeljenjeDto, Odeljenje>{

	@Override
	public Odeljenje convert(OdeljenjeDto source) {
		Odeljenje odeljenje = new Odeljenje();
		odeljenje.setId(source.getId());
		odeljenje .setIme(source.getIme());
		odeljenje .setBonusSlobodihDana(source.getBonusSlobodnihDana());
		
		return odeljenje ;
	}
	
	

}
