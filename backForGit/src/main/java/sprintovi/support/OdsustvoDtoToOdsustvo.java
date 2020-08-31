package sprintovi.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import sprintovi.model.Odsustvo;
import sprintovi.service.RadnikService;
import sprintovi.web.dto.OdsustvoDto;

@Component
public class OdsustvoDtoToOdsustvo implements Converter<OdsustvoDto, Odsustvo>{
@Autowired
private RadnikService radnikService;
	@Override
	public Odsustvo convert(OdsustvoDto source) {
		Odsustvo dto = new Odsustvo();
		dto.setId(source.getId());
		dto.setDatumPocetka(source.getDatumPocetka());
		dto.setRadnihDana(source.getRadnihDana());
		dto.setRadnik(radnikService.one(source.getRadnikId()).get());
		
		return dto;
	}
	
	public List<Odsustvo> convert(List<OdsustvoDto> source){
		List<Odsustvo> retVal = new ArrayList<>();
		
		for(OdsustvoDto s : source) {
			Odsustvo dto = convert(s);
			retVal.add(dto);
		}
		
		return retVal;
	}

}
