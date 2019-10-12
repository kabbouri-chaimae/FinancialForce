package com.social.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.social.entities.*;
import com.social.services.BcService;
import com.social.services.ConsultationService;
import com.social.services.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.social.services.UserService;
import com.social.util.CustomErrorType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("account")
@CrossOrigin(origins = "http://localhost:4200")

public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);


	@Autowired
	private BcService bcService;

	@Autowired
	private UserService userService;
	@Autowired

	private ProviderService providerService;



	@Autowired
	private ConsultationService consultationService;
	// request method to create a new account by a guest
	@CrossOrigin
	@RequestMapping(value = "/postSelectedProviders", method = RequestMethod.POST)
	public ResponseEntity<?> createProvider(@RequestBody Provider provider) {

		System.out.println("===> working");

		return new ResponseEntity<Provider>(providerService.save(provider), HttpStatus.CREATED);
	}
	@CrossOrigin
	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
	public ResponseEntity<?> createConsultation(@RequestBody Consultation consultation) {

		System.out.println("===> working");
    Consultation consu = consultationService.save(consultation);

		return new ResponseEntity<Consultation>(consultationService.save(consultation), HttpStatus.CREATED);
	}
	@CrossOrigin
	@RequestMapping(value = "/BC", method = RequestMethod.POST)
	public ResponseEntity<Bc> postBC(@RequestBody Bc bc) {

		System.out.println("===> working");
		Bc b = bcService.save(bc);

		return new ResponseEntity<Bc>(bcService.save(bc), HttpStatus.CREATED);
	}
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		System.out.println("dsffds");
		if (userService.find(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity(
					new CustomErrorType("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}


		return new ResponseEntity<User>(userService.save(newUser), HttpStatus.CREATED);
	}



	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/allUsers")
	public List<User> ListUsers() {

  return userService.findAll();

}

	@RequestMapping(value = "/logout")
	public String logout(){
		try {
			HttpServletRequest request = null;
			HttpSession session = request.getSession(false);
			session.invalidate();

			if (session != null) {


				session.invalidate();
			}


			SecurityContextHolder.clearContext();
			return "s";

		} catch (Exception e) {
			//logger.log(LogLevel.INFO, "Problem logging out.");
			System.out.println("inside catch\n\n");

			return "ERROR"+e.getMessage();
		}

	}
	@CrossOrigin
	@RequestMapping("/selectedSocieties")
	public List<Provider> findSocieties() {

		return this.providerService.findAll();

	}


	@CrossOrigin
	@RequestMapping("/selectedSociety")
	public Provider findSociety(String pname) {

		return providerService.find (pname);

	}
	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged " + principal);
		return principal;
	}
	@CrossOrigin
	@GetMapping("/getByObject/{objet}")
	public ResponseEntity<?> get(@PathVariable("objet") String objet) {
		List<Consultation> consultations = consultationService.find(objet);
		return ResponseEntity.ok().body(consultations);
	}

	@CrossOrigin
	@GetMapping("/getAllConsultations")
	public List<Consultation> ListConsultations() {

		return consultationService.findAll();

	}

	@CrossOrigin
	@PutMapping("updatec/{idConsultation}")
	public ResponseEntity<Consultation> updateConsultation(@PathVariable("idConsultation") Long idConsultation , @RequestBody Consultation consultation) {
		Optional<Consultation> consData = Optional.ofNullable(consultationService.findById(idConsultation));
		if (consData.isPresent()) {
			Consultation consu = consData.get();
			consu.setMentant(consultation.getMentant());
			return new ResponseEntity<>(consultationService.update((consu)), HttpStatus.OK);
		} else {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}



}
