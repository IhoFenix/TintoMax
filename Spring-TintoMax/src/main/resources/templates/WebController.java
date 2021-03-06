package es.tintomax.server.controllers;

import es.tintomax.server.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class WebController {
	

    @Autowired
    private UserRepository userRepository;
    

	@RequestMapping("/home")
	public String home(Model model) {

		return "home";
	}
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "home";
	}

	private static String filePath = System.getProperty("catalina.home") + File.separator + "webapps"+File.separator+"images"+File.separator;
	
	@RequestMapping("/")
	public String index(Model model) {

		

		//	model.addAttribute("name", "World");

		return "home";
	}
	/*
	 //codigo para subida de imagenes. 
	 @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file")MultipartFile image) { 
        
        if(!image.isEmpty()) {
            try {
                image.transferTo(new File(filePath+image.getOriginalFilename()));                
            } catch(Exception e) {
                                
            }
        }        
        return "home";
    } 
	*/
	@RequestMapping(value="/servicios_cliente",method = RequestMethod.GET)
	public String servicios_cliente(Model model,HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);


		return "servicios_cliente";
	}
	
	@RequestMapping(value="/datos_usuario",method = RequestMethod.GET)
	public String datos_cliente(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "datos_usuario";
	}
	@RequestMapping("/login")
	public String login(Model model) {

	//	model.addAttribute("name", "World");

		return "login";
	}
	@RequestMapping(value="/listado_precios",method = RequestMethod.GET)
	public String precios(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "listado_precios";
	}
	@RequestMapping(value="/administracion",method = RequestMethod.GET)
	public String administracion(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "administracion";
	}
	@RequestMapping(value="/localizacion",method = RequestMethod.GET)
	public String localizacion(Model model,HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    	String name = auth.getName(); //get logged in username
	    	model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("username",name);

		return "localizacion";
		
	
	}
}
