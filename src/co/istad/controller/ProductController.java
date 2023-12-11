package co.istad.controller;

import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.ProductView;

import java.util.List;
import java.util.Scanner;

public class ProductController {

    Scanner scanner;

    private ProductService productService;

    public ProductController() {
        productService = new ProductServiceImpl();
        scanner = Singleton.scanner();
        System.out.println(scanner.hashCode());
    }

    public void index() {
        List<Product> products = productService.select();
        ProductView.viewProductList(products);
    }

    public void createNew() {
        Product product = new Product();
        ProductView.viewCreateProduct(product, scanner);
        product = productService.insert(product);
        System.out.println("Successfully saved");
        System.out.println(product);
    }

}
