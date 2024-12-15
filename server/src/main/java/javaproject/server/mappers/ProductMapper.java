package javaproject.server.mappers;


import javaproject.server.dtos.requests.ProductRequest;
import javaproject.server.dtos.responses.ProductResponse;
import javaproject.server.entities.Category;
import javaproject.server.entities.Product;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.repositories.CategoryRepository;
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
            productResponse.name(product.getName());
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
