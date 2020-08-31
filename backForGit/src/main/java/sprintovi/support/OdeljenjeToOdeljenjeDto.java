package sprintovi.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sprintovi.model.Odeljenje;
import sprintovi.web.dto.OdeljenjeDto;

@Component
public class OdeljenjeToOdeljenjeDto implements Converter<Odeljenje, OdeljenjeDto>{

	@Override
	public OdeljenjeDto convert(Odeljenje source) {
		OdeljenjeDto dto = new OdeljenjeDto();
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		dto.setBonusSlobodnihDana(source.getBonusSlobodihDana());
		
		return dto;
	}
	
	public List<OdeljenjeDto> convert(List<Odeljenje> source){
		List<OdeljenjeDto> retVal = new ArrayList<>();
		
		for(Odeljenje s : source) {
			OdeljenjeDto dto = convert(s);
			retVal.add(dto);
		}
		
		return retVal;
	}

}
