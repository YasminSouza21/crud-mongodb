package com.yasmin.trabalho.crud_mongo.controllers;

import com.yasmin.trabalho.crud_mongo.domain.products.Product;
import com.yasmin.trabalho.crud_mongo.domain.products.ProductRequestDTO;
import com.yasmin.trabalho.crud_mongo.domain.products.ProductRequestUpdateDTO;
import com.yasmin.trabalho.crud_mongo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ModelAndView home(ModelAndView mv) {
        Product product = productService.findTopProduct();

        if (product != null) {
            long currentId = product.getId() + 1;

            mv.addObject("productRequestDTO", new ProductRequestDTO(currentId, "", 0, 0.0));
        } else {
            mv.addObject("productRequestDTO", new ProductRequestDTO(1L, "", 0, 0.0));
        }

        mv.addObject("productRequestUpdateDTO", new ProductRequestUpdateDTO(0L, "", 0, 0.0));

        List<Product> products = productService.listProducts();

        mv.addObject("products", products);

        return mv;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productRequestDTO") ProductRequestDTO productRequestDTO, RedirectAttributes redirectAttributes) {
        productService.saveProduct(productRequestDTO);

        redirectAttributes.addFlashAttribute("successMessage", "Produto salvo com sucesso!");

        return "redirect:/home?page=products";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("productRequestUpdateDTO") ProductRequestUpdateDTO productRequestUpdateDTO, RedirectAttributes redirectAttributes){
        productService.updateProduct(productRequestUpdateDTO);

        redirectAttributes.addFlashAttribute("successMessage", "Produto atualizado com sucesso!");

        return "redirect:/home?page=products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);

        redirectAttributes.addFlashAttribute("successMessage", "Produto deletado com sucesso!");

        return "redirect:/home?page=products";
    }

}