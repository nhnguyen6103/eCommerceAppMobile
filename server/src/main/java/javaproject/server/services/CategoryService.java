package javaproject.server.services;


import javaproject.server.dtos.requests.CategoryRequest;
import javaproject.server.dtos.responses.CategoryResponse;
import javaproject.server.entities.Category;
import javaproject.server.exception.AppException;
import javaproject.server.exception.ErrorCode;
import javaproject.server.mappers.CategoryMapper;
import jakarta.transaction.Transactional;
import javaproject.server.repositories.CategoryRepository;
import javaproject.server.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final ProductRepository productRepository;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.productRepository = productRepository;
    }

    public CategoryResponse createCategory(CategoryRequest request)
    {
        //Check exists
        if(categoryRepository.existsById(request.getName().toUpperCase()))
            throw new AppException(ErrorCode.CATEGORY_EXISTED);

        Category newCategory = categoryMapper.toCategory(request);
        newCategory.setName(newCategory.getName().toUpperCase());

        return categoryMapper.toCategoryResponse(categoryRepository.save(newCategory));
    }

    public List<CategoryResponse> getAll()
    {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();
    }

    public CategoryResponse updateCategoryDetails (String id, Map<String,String> updateFields)
    {
        // Check exists
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        // Update following field
        updateFields.forEach((key,value) ->
        {
            try{
                Field field = Category.class.getDeclaredField(key);
                field.setAccessible(true);
                field.set(category,value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new AppException(ErrorCode.FIELD_NOT_EXISTED);
            }
        });

        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Transactional
    public void deleteCategory(String id)
    {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        if(productRepository.existsById(id))
        {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }

        categoryRepository.delete(category);
    }

}
