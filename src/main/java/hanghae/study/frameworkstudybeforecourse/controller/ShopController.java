package hanghae.study.frameworkstudybeforecourse.controller;

import hanghae.study.frameworkstudybeforecourse.entity.Product;
import hanghae.study.frameworkstudybeforecourse.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/shop")
public class ShopController {

    private final ProductService productService;

    public ShopController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String shop(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "shop";
    }

    @GetMapping("/{id}")
    public String productDetail(@PathVariable("id") Long id, Model model) {
        Product product = productService.getItem(id).orElseThrow(IllegalArgumentException::new);

        model.addAttribute("product", product);

        return "productDetail";
    }
}
