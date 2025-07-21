package com.hs.inventory_app.service;

import com.hs.inventory_app.dto.ProductDto;
import com.hs.inventory_app.model.Product;
import com.hs.inventory_app.query.ProductQueryRepository;
import com.hs.inventory_app.query.ProductSearchCondition;
import com.hs.inventory_app.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductQueryRepository queryRepository;

    public List<Product> search(ProductSearchCondition condition) {
        return queryRepository.search(condition);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 제품을 찾을 수 없습니다."));
    }

    public Product create(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return productRepository.save(product);
    }

    public Product update(Long id, ProductDto dto) {
        Product product = getById(id);
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
