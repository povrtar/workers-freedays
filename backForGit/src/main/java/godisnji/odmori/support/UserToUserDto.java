package godisnji.odmori.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import godisnji.odmori.model.User;
import godisnji.odmori.web.dto.UserDto;

@Component
public class UserToUserDto implements Converter<User, UserDto>{

	@Override
	public UserDto convert(User source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setDateOfBirth(source.getDateOfBirth());
		target.setEmail(source.getEmail());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setUsername(source.getUsername());
		
		return target;
	}

	
}
