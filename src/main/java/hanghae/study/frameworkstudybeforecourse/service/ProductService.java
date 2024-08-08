package hanghae.study.frameworkstudybeforecourse.service;

import hanghae.study.frameworkstudybeforecourse.entity.Product;
import hanghae.study.frameworkstudybeforecourse.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getItem(Long id) {
        return productRepository.findById(id);
    }
}
