package com.social.controller;

import java.security.Principal;
import java.util.List;

import com.social.dao.DevisRepository;
import com.social.entities.Consultation;
import com.social.entities.Devis;
import com.social.entities.Provider;
import com.social.services.ConsultationService;
import com.social.services.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import com.social.services.UserService;
import com.social.util.CustomErrorType;
import com.social.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("account")
@CrossOrigin(origins = "http://localhost:4200")

public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private UserService userService;
	@Autowired

	private ProviderService providerService;

	@Autowired

	private DevisRepository devisRepository;

	@Autowired
	private ConsultationService consultationService;
	// request method to create a new account by a guest

	@CrossOrigin
	@RequestMapping(value = "/consultation", method = RequestMethod.POST)
	public ResponseEntity<?> createConsultation(@RequestBody Consultation consultation) {

		System.out.println("===> working");

		return new ResponseEntity<Consultation>(consultationService.save(consultation), HttpStatus.CREATED);
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


	@CrossOrigin
	@RequestMapping(value = "/saveDevis", method = RequestMethod.POST)
	public ResponseEntity<?> createDevis(@RequestBody Devis newDevis) {


		return new ResponseEntity<Devis>(devisRepository.save(newDevis), HttpStatus.CREATED);
	}
	// this is the login api/service
	@CrossOrigin
	@RequestMapping("/allUsers")
	public List<User> ListUsers() {

  return userService.findAll();

}
	@CrossOrigin
	@RequestMapping("/getByObject")
	public Consultation getByObject(String object) {

		return consultationService.find(object);

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
	public ResponseEntity<?> get(@PathVariable("objet") String object) {
		Consultation consultation = consultationService.find(object);
		System.out.println(consultation.getObjet());
		return ResponseEntity.ok().body(consultation);
	}




}
