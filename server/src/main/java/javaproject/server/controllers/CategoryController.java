package javaproject.server.controllers;

import javaproject.server.dtos.requests.CategoryRequest;
import javaproject.server.dtos.responses.ApiResponse;
import javaproject.server.dtos.responses.CategoryResponse;
import javaproject.server.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;


    //Constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest request)
    {

        return ApiResponse.<CategoryResponse>builder()
                .status(HttpStatus.OK.value())
                .message("ADD CATEGORY SUCCESSFULLY")
                .data(categoryService.createCategory(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<CategoryResponse>> getAllCategories()
    {
        return ApiResponse.<List<CategoryResponse>>builder()
                .status(HttpStatus.OK.value())
                .message("GET CATEGORIES SUCCESSFULLY")
                .data(categoryService.getAll())
                .build();
    }

    @PatchMapping("/{cateID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<CategoryResponse> updateCategory(@PathVariable  String cateID,
                                         @RequestBody Map<String,String> updateFields)
    {
        return ApiResponse.<CategoryResponse>builder()
                .status(HttpStatus.OK.value())
                .message("UPDATE CATEGORY DETAILS SUCCESSFULLY")
                .data(categoryService.updateCategoryDetails(cateID, updateFields))
                .build();
    }

    @DeleteMapping("/{cateID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<?> deleteCategory(@PathVariable String cateID)
    {
        categoryService.deleteCategory(cateID);
        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message("DELETE CATEGORY SUCCESSFULLY")
                .build();
    }




}
