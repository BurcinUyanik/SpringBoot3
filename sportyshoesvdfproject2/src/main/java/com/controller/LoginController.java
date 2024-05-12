package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.entity.Login;
import com.service.LoginService;


@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	LoginService loginService;
	// http://localhost:8080/register , method : post 
		
	@GetMapping(value = "")
	public String open() {
		return "index";
	}	
	
	@GetMapping("/adminlogin")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}
	
	@PostMapping("/adminlogin2")
	public String signUp(@ModelAttribute("user") Login user ) {
		Login oauthUser = null;
		System.out.println("from login"+ user);
		
		if(user.getPassword() != "" ) {
			System.out.println("logging in");	
			oauthUser = loginService.signgin(user.getUsername(), user.getPassword());
			return "menu";
		} else {
			if (user.getNewPassword() != "" ) {
				System.out.println("Changing new password");
				oauthUser = loginService.changePassword(user.getUsername(), user.getNewPassword());
				if(oauthUser == null ) {
					return "invalid_credentials";
				}
				return "menu";
			}
			return "invalid_credentials";	
		} 
	}
	
	
	
	//@GetMapping("/forgotPassword")
	//public String update(@ModelAttribute("user") Login user){
		//Login changepw = userService.updatePassword(user.);
		//System.out.println(changepw);
		//if(Objects.nonNull(changepw)) 
		//{	

			//return "redirect:/";


		//} else {
			//return "redirect:/login";

		//}
		
	//}
	//{
		
	//}


	@RequestMapping("/logout")
	public String logoutDo()
	{
		return "conform_logout";
	}
	
	//@PostMapping("/reset")
	//public String resetPassword(@ModelAttribute("userchange") Login user) {
		//System.out.println("form reset");
		//Boolean changePassword = ls.changePassword(user.getUsername(), user.getPassword());
		//if(!changePassword) {
		//	return "usernotfound";
		//}
		//return "menu";	
	//}
	
/*	@GetMapping("/forgotpw")
	public String resetPassword1(@ModelAttribute("change") Login change ) {
		System.out.println("from login"+ change);

		Boolean oauthUser = ls.changePassword(change.getUsername(), change.getPassword());


		System.out.print(oauthUser);
		if(Objects.nonNull(oauthUser)) 
		{	

			return "menu";


		} else {
			return "invalid_credentials";

		}

	}
	*/

}

