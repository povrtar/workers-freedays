package sprintovi.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sprintovi.model.Radnik;
import sprintovi.web.dto.RadnikDto;


@Component
public class RadnikToRadnikDto implements Converter<Radnik, RadnikDto>{

	@Override
	public RadnikDto convert(Radnik radnik) {
		
		RadnikDto retValue = new RadnikDto();
		retValue.setId(radnik.getId());
		retValue.setJmbg(radnik.getJmbg());
		retValue.setEmail(radnik.getEmail());
		retValue.setGodineStaza(radnik.getGodinaStaza());
		retValue.setImeIPrezime(radnik.getImeIPrezime());
		retValue.setSlobodnihDana(radnik.getSlobodnihDana());
		retValue.setOdeljenjeId(radnik.getOdeljenje().getId());
		retValue.setOdeljenjeName(radnik.getOdeljenje().getIme());
		return retValue;
	}

	public List<RadnikDto> convert(List<Radnik> zadaci){
		List<RadnikDto> ret = new ArrayList<>();
		
		for(Radnik z : zadaci){
			ret.add(convert(z));
		}
		
		return ret;
	}

}
