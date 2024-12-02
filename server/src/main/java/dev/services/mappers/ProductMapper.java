package dev.services.mappers;

import dev.dtos.requests.ProductRequest;
import dev.dtos.responses.ProductResponse;
import dev.entities.Category;
import dev.entities.Product;
import dev.exception.AppException;
import dev.exception.ErrorCode;
import dev.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    private final CategoryRepository categoryRepository;

    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ProductResponse toProductResponse(Product product) {
        if (product == null) {
            return null;
        } else {
            Category cate = categoryRepository.findById(product.getCategoryID())
                    .orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

            ProductResponse.ProductResponseBuilder productResponse = ProductResponse.builder();
            productResponse.id(product.getId());
            productResponse.imageURL(product.getImageURL());
            productResponse.category(cate.getName());
            productResponse.description(product.getDescription());
            productResponse.quantity(product.getQuantity());
            productResponse.price(product.getPrice());
            return productResponse.build();
        }
    }

    public Product toProduct(ProductRequest request) {
        if (request == null) {
            return null;
        } else {
            Product.ProductBuilder product = Product.builder();
            product.name(request.getName());
            product.description(request.getDescription());
            product.quantity(request.getQuantity());
            product.price(request.getPrice());
            return product.build();
        }
    }
}
