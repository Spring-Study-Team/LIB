package hanghae.study.frameworkstudybeforecourse.repository;

import hanghae.study.frameworkstudybeforecourse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
