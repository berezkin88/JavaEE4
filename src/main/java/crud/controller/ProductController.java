package crud.controller;

import crud.model.Product;
import crud.model.User;
import crud.service.ProductService;
import crud.service.SecurityService;
import crud.service.UserService;
import crud.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Alexander on 23/07/2017.
 */
@Controller
public class ProductController {

    private ProductService productService;

    //    @Autowired
    private UserService userService;

    //    @Autowired
    private SecurityService securityService;

    //    @Autowired
    private UserValidator userValidator;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }

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
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.listProducts());
        return "welcome";
    }

//    @RequestMapping(value = "/products", method = RequestMethod.GET)
//    public String admin(Model model) {
//        return "products";
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.listProducts());
        return "products";
    }

//    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
//    public String listProducts2 (Model model) {
//        model.addAttribute("product", new Product());
//        model.addAttribute("listProducts", productService.listProducts());
//        return "welcome";
//    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if (product.getId() == null) {
            productService.addProduct(product);
        } else {
            productService.updateProduct(product);
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "remove/{id}")
    public String removeProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id);

        return "redirect:/products";
    }

    @RequestMapping(value = "edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        model.addAttribute("listProducts", productService.listProducts());

        return "products";
    }

    @RequestMapping(value = "/productData/{id}")
    public String productData(@PathVariable("id") Integer id, Model model){
        model.addAttribute("product", productService.findProductById(id));

        return "productData";
    }

    @Autowired
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "securityService")
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    @Qualifier(value = "userValidator")
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }
}


