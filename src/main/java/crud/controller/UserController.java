package crud.controller;

import crud.model.User;
import crud.service.SecurityService;
import crud.service.UserService;
import crud.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for {@link crud.model.User}'s pages
 *
 * @author Alexander
 * @version 1.0
 */

@Controller
public class UserController {

//    @Autowired
    private UserService userService;

//    @Autowired
    private SecurityService securityService;

//    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or Password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String admin(Model model) {
        return "products";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }
}
