package net.jcornelio.projects.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.jcornelio.projects.springboot.web.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

  @Autowired
  LoginService loginService;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginPage() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String showWelcomePage(@RequestParam String name, @RequestParam String password,
      ModelMap model) {

    boolean isValidUser = loginService.validateUser(name, password);

    if (!isValidUser) {
      model.put("errorMessage", "Invalid Credentials");
      return "login";
    }

    model.put("name", name);
    model.put("password", password);

    return "welcome";
  }
}
