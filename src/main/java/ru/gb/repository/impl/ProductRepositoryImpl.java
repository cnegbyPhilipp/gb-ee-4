package ru.gb.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private static final int PRODUCTS_COUNT = 5;

  private final List<Product> products = new ArrayList<>();

  public ProductRepositoryImpl() {
    for (int i = 0; i < PRODUCTS_COUNT; i++) {
      products.add(buildProduct(i));
    }
  }

  @Override
  public Optional<Product> getById(int id) {
    return products.stream()
        .filter(product -> product.getId() == id)
        .findFirst();
  }

  @Override
  public Optional<List<Product>> getAll() {
    return Optional.of(products);
  }

  private Product buildProduct(int id) {
    Product product = new Product();
    product.setId(id);
    product.setCost(new Random().nextInt(100));
    product.setTitle(String.format("Product %d", id));

    return product;
  }
}
