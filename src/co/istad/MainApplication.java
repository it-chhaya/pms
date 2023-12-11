package co.istad;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.util.Singleton;
import co.istad.view.MainView;
import co.istad.view.MenuView;
import co.istad.view.ProductView;
import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApplication {

    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;

    public MainApplication() {
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();
    }

    private void run() {

        MainView.logoHeader();

        while(true) {
            menuController.index();
            System.out.print("Enter option: ");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "*" ->  productController.index();
                case "w" -> productController.createNew();
                case "e" -> System.exit(0);
                default -> throw new IllegalStateException();
            }
        }

    }

    public static void main(String[] args) {

        new MainApplication().run();

    }
}
