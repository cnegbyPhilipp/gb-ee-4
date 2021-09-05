package ru.gb.repository;

import java.util.List;
import java.util.Optional;
import ru.gb.domain.Product;

public interface ProductRepository {

  Optional<Product> getById(int id);

  Optional<List<Product>> getAll();
}
