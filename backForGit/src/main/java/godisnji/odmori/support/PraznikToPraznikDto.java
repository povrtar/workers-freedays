package godisnji.odmori.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import godisnji.odmori.model.Praznik;

import godisnji.odmori.web.dto.PraznikDto;

@Component
public class PraznikToPraznikDto implements Converter<Praznik,PraznikDto>{

	@Override
	public PraznikDto convert(Praznik source) {
		PraznikDto dto = new PraznikDto();
		dto.setId(source.getId());
		dto.setIme(source.getIme());
		
		String dateAll=source.getDatum().toString();
		
		String[] niz=dateAll.substring(0, 10).split("-");
		dto.setDate(niz[2]+"-"+niz[1]+"-"+niz[0]);
		
		return dto;
	}
	
	public List<PraznikDto> convert(List<Praznik> source){
		List<PraznikDto> retVal = new ArrayList<>();
		
		for(Praznik s : source) {
			PraznikDto dto = convert(s);
			retVal.add(dto);
		}
		
		return retVal;
	}

}
