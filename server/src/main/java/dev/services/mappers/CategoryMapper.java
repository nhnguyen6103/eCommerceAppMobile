package dev.services.mappers;

import dev.dtos.requests.CategoryRequest;
import dev.dtos.responses.CategoryResponse;
import dev.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryMapper() {
    }

    public Category toCategory(CategoryRequest request) {
        if (request == null) {
            return null;
        } else {
            Category.CategoryBuilder category = Category.builder();
            category.name(request.getName());
            category.description(request.getDescription());
            return category.build();
        }
    }
    public CategoryResponse toCategoryResponse(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryResponse.CategoryResponseBuilder categoryResponse = CategoryResponse.builder();
            categoryResponse.id(category.getId());
            categoryResponse.name(category.getName());
            categoryResponse.description(category.getDescription());
            return categoryResponse.build();
        }
    }
}
