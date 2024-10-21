package org.yhiagovb62.desafiouber.Service;


import org.springframework.stereotype.Service;
import org.yhiagovb62.desafiouber.Model.Product;
import org.yhiagovb62.desafiouber.Model.ProductDto;
import org.yhiagovb62.desafiouber.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(String id, ProductDto productDto) {
        Product product = getProductById(id);
        product.setTitle(productDto.tittle());
        product.setPrice(productDto.price());
        product.setDescription(productDto.description());
        product.setOwnerId(productDto.ownerId());
        // Assuming you will set the category later
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
