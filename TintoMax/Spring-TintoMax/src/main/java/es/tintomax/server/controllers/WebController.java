package es.tintomax.server.controllers;

<<<<<<< HEAD:Spring-TintoMax/src/main/java/es/tintomax/server/controllers/MiController.java
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.tintomax.server.jpa.User;
import es.tintomax.server.repositories.UserRepository;
=======
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
>>>>>>> a1ad3bd53f33db55cdcc520fd0fb802cf5dabdec:Spring-TintoMax/src/main/java/es/tintomax/server/controllers/WebController.java

@Controller
public class MiController {
	
	@Autowired
	private UserRepository userRepository;
	

<<<<<<< HEAD:Spring-TintoMax/src/main/java/es/tintomax/server/controllers/MiController.java
	@RequestMapping("/home")
	public String home(Model model) {

	//	model.addAttribute("name", "World");
		int numpagina=1;
		String cad= " ";
		/*Page<User> users = userRepository.findAll();*/
		//Page<User> users = userRepository.findAll(new PageRequest(numpagina, 10));

		/*List<User> finalUsers = users.getContent();
		for (User user : finalUsers) {
			cad=cad+user.getNombre();
		}*/
		System.out.println(cad);		
				
=======
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("username",name);
>>>>>>> a1ad3bd53f33db55cdcc520fd0fb802cf5dabdec:Spring-TintoMax/src/main/java/es/tintomax/server/controllers/WebController.java

		return "home";
	}
	@RequestMapping("/")
	public String index(Model model) {

	//	model.addAttribute("name", "World");

		return "home";
	}
	@RequestMapping("/servicios_cliente")
	public String servicios_cliente(Model model) {

	//	model.addAttribute("name", "World");

		return "servicios_cliente";
	}
	
	@RequestMapping("/datos_cliente")
	public String datos_cliente(Model model) {

	//	model.addAttribute("name", "World");

		return "datos_cliente";
	}
	@RequestMapping("/login")
	public String login(Model model) {

	//	model.addAttribute("name", "World");

		return "login";
	}
	@RequestMapping("/listado_precios")
	public String precios(Model model) {

	//	model.addAttribute("name", "World");

		return "listado_precios";
	}
	
}
