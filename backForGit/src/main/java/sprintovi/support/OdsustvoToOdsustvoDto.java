package sprintovi.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sprintovi.model.Odsustvo;
import sprintovi.web.dto.OdsustvoDto;

@Component
public class OdsustvoToOdsustvoDto implements Converter<Odsustvo, OdsustvoDto>{

	@Override
	public OdsustvoDto convert(Odsustvo source) {
		OdsustvoDto dto = new OdsustvoDto();
		dto.setId(source.getId());
		dto.setDatumPocetka(source.getDatumPocetka());
		dto.setRadnihDana(source.getRadnihDana());
		dto.setRadnikId(source.getRadnik().getId());
		
		return dto;
	}
	
	public List<OdsustvoDto> convert(List<Odsustvo> source){
		List<OdsustvoDto> retVal = new ArrayList<>();
		
		for(Odsustvo s : source) {
			OdsustvoDto dto = convert(s);
			retVal.add(dto);
		}
		
		return retVal;
	}

}
