package godisnji.odmori.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import godisnji.odmori.model.User;
import godisnji.odmori.web.dto.UserPasswordChangeDto;

public interface UserService {
	Optional<User> one(Long id);	
	List<User> all();
	Page<User> all(int pageNum);
	User save(User user);
	void delete(Long id);
	Optional<User> byUsername(String username);
	boolean changePassword(Long id, UserPasswordChangeDto changeDto);
}
