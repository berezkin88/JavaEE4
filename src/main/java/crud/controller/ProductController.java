package crud.controller;

import crud.model.Product;
import crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(){
//        return "index";
//    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.listProducts());
        return "products";
    }

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
}
