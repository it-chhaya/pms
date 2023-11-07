package co.istad.controller;

import co.istad.model.Product;
import co.istad.service.ProductServiceImpl;
import co.istad.view.MenuView;
import co.istad.view.ProductView;

import java.util.List;
import java.util.Scanner;

public class MainController {

    public void index() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to PMS");
        MenuView.menu();
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1 -> {
                List<Product> products = productService.select();
                ProductView.printProductList(products);
            }
            default -> throw new IllegalArgumentException();
        }
    }

}
