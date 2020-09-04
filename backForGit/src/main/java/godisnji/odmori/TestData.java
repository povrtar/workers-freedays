package godisnji.odmori;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import godisnji.odmori.model.Odeljenje;
import godisnji.odmori.model.Odsustvo;
import godisnji.odmori.model.Radnik;
import godisnji.odmori.model.User;
import godisnji.odmori.model.UserRole;
import godisnji.odmori.repository.OdeljenjeRepository;
import godisnji.odmori.repository.OdsustvoRepository;
import godisnji.odmori.repository.RadnikRepository;

import godisnji.odmori.service.UserService;

@Component
public class TestData {

	@Autowired
	private UserService userService;
	
	@Autowired
	private OdsustvoRepository odsustvoRepository;
	
	@Autowired
	private OdeljenjeRepository odeljenjeRepository;
	
	@Autowired
	private RadnikRepository radnikRepository;
		
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
			
		Odsustvo odsustvo1 = new Odsustvo();
		Date date1=new Date();
		date1.setYear(2020);
		date1.setMonth(6);
		date1.setDate(21);
		odsustvo1.setDatumPocetka(date1);
		odsustvo1.setRadnihDana(5L);
	
		Odsustvo odsustvo2 = new Odsustvo();
		Date date2=new Date();
		date2.setYear(2020);
		date2.setMonth(07);
		date2.setDate(21);
		odsustvo2.setDatumPocetka(date2);;
		odsustvo2.setRadnihDana(8L);
		
		odsustvoRepository.save(odsustvo1);
		odsustvoRepository.save(odsustvo2);
		
		Odeljenje skladiste = new Odeljenje();
		skladiste.setIme("Skladiste");
		skladiste.setBonusSlobodihDana(3L);
		Odeljenje prodaja = new Odeljenje();
		prodaja.setIme("Prodaja");
		prodaja.setBonusSlobodihDana(2L);
		
		
		prodaja= odeljenjeRepository.save(prodaja);
		skladiste = odeljenjeRepository.save(skladiste);
		
		
		
		Radnik zadatak1 = new Radnik();
		zadatak1.setEmail("marko@gmail.net");
		zadatak1.setGodinaStaza(5L);
		zadatak1.setImeIPrezime("Marko Markovic");
		zadatak1.setJmbg("1234567890123");
		zadatak1.setOdeljenje(skladiste);
		zadatak1.setSlobodnihDana(21L);

		Radnik zadatak2 = new Radnik();
		zadatak2.setEmail("Pero@gmail.net");
		zadatak2.setGodinaStaza(10L);
		zadatak2.setImeIPrezime("Pero Markovic");
		zadatak2.setJmbg("1234567890125");
		zadatak2.setOdeljenje(prodaja);
		zadatak2.setSlobodnihDana(22L);
		
		radnikRepository.save(zadatak1);
		radnikRepository.save(zadatak2);
		
		odsustvo1.setRadnik(zadatak1);
		odsustvo2.setRadnik(zadatak1);
	odsustvoRepository.save(odsustvo1);
	odsustvoRepository.save(odsustvo2);
	List<Odsustvo> odsustva=new ArrayList<>();
	odsustva.add(odsustvo1);
	odsustva.add(odsustvo2);
	zadatak1.setOdsustva(odsustva);
	radnikRepository.save(zadatak1);
		
		List<User> users = new ArrayList<User>();
		for (int i = 1; i <= 3; i++) {
			User user = new User();
			user.setUsername("user" + i);
			user.setFirstName("First " + i);
			user.setLastName("Last " + i);
			user.setEmail("user"+i+"@mail.com");
			user.setDateOfBirth(LocalDateTime.now().minusYears(20 + i));

			// ubacen deo koda zbog greske koja se desavala ako kroz ubacivanje podataka dva puta
			// kriptujemo lozinku
			String encodedPass = passwordEncoder.encode("pass"+i);
			user.setPassword(encodedPass);

			List<UserRole> roles = Arrays.asList(UserRole.values());
			Random random = new Random();
			user.setRole(roles.get(random.nextInt(3)));
			
			users.add(user);
			userService.save(user);
			
		}
	}
}
