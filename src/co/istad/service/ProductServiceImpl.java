package co.istad.service;

import co.istad.dao.ProductDao;
import co.istad.dao.ProductDaoImpl;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;
import co.istad.util.Singleton;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    public ProductServiceImpl() {
        productDao = Singleton.getProductDaoV2Impl();
    }
    @Override
    public Product insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public List<Product> select() {
        return productDao.select().stream()
                .peek(product -> product.setName("CSTAD_" + product.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Product selectById(Long id) {
        return null;
    }

    @Override
    public Product updateById(Product product) {
        return null;
    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }

    @Override
    public List<Product> selectByName(String name) {
        return null;
    }
}
