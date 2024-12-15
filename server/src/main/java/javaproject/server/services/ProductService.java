package javaproject.server.services;


import javaproject.server.dtos.requests.ProductRequest;
import javaproject.server.dtos.responses.ProductResponse;
import javaproject.server.entities.Category;
import javaproject.server.entities.Product;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.ProductMapper;
import javaproject.server.repositories.CategoryRepository;
import javaproject.server.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Value("${image.PRODUCT_DIR}")
    private String uploadDir;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getAll()
    {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    public ProductResponse createProduct(ProductRequest request)
    {
        if(productRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.PRODUCT_EXISTED);

        Product newProduct = productMapper.toProduct(request);
        Category category = categoryRepository.findByName(request.getCategory())
                .orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        newProduct.setCategoryID(category.getId());

        Path path = Paths.get(uploadDir + File.separator + "base" + File.separator + "base.jpeg");

        newProduct.setImageURL(path.toString());

        ProductResponse response = productMapper.toProductResponse(productRepository.save(newProduct));
        response.setCategory(category.getName());
        return response;
    }


    public ProductResponse updateProductImage(String id ,MultipartFile file)
    {
        if(file.isEmpty())
        {
            throw new AppException(ErrorCode.EMPTY_FILE);
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        String productDir = uploadDir
                + File.separator
                + product.getId()
                + File.separator;

        File directory = new File(productDir);
        if (!directory.exists()) {
            directory.mkdirs();  // Create folder if it is not existed
        }

        // Create file's name
        String fileName = "product_" + product.getId() + ".jpg";

        //Files.copy require path
        Path filePath = Paths.get(productDir+fileName);

        try {
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }

        product.setImageURL(filePath.toString());

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public ProductResponse updateProductDetails(String id, Map<String,String> updateFields)
    {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        updateFields.forEach((key,value) -> {
            try {
                Field field = Product.class.getDeclaredField(key);
                field.setAccessible(true);
                field.set(product, value);
            }
            catch (NoSuchFieldException | IllegalAccessException e) {
                throw new AppException(ErrorCode.FIELD_NOT_EXISTED);
            }
        });

        return productMapper.toProductResponse(productRepository.save(product));
    }

    public void deleteProduct(String id)
    {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        productRepository.delete(product);
    }

}
