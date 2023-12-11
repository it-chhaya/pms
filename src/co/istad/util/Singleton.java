package co.istad.util;

import co.istad.controller.MenuController;
import co.istad.controller.ProductController;
import co.istad.dao.ProductDaoImpl;
import co.istad.dao.ProductDaoV2Impl;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;

import java.util.Scanner;

public class Singleton {

    // 1. Create static reference type
    private static Scanner scanner;
    private static MenuController menuController;
    private static ProductController productController;
    private static ProductServiceImpl productServiceImpl;
    private static ProductDaoImpl productDao;
    private static ProductDaoV2Impl productDaoV2;

    // 2. Create get instance of scanner
    public static Scanner scanner() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    public static MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }

    public static ProductController productController() {
        if (productController == null) {
            productController = new ProductController();
        }
        return productController;
    }

    public static ProductServiceImpl getProductServiceImpl() {
        if (productServiceImpl == null) {
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public static ProductDaoImpl getProductDaoImpl() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    public static ProductDaoV2Impl getProductDaoV2Impl() {
        if (productDaoV2 == null) {
            productDaoV2 = new ProductDaoV2Impl();
        }
        return productDaoV2;
    }

}
