package javaproject.desktop.mapper;

import javaproject.desktop.dtos.responses.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {


    // Hàm chuyển đổi một đối tượng JSON thành CategoryResponse
    public CategoryResponse convertToCategory(String item) {
        // Loại bỏ dấu ngoặc nhọn
        item = item.replace("{", "").replace("}", "");

        String[] fields = item.split(",");

        String name = "", description = "", id = "";

        for (String field : fields) {
            String[] keyValue = field.split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            // Phân tích từng thuộc tính
            if ("name".equals(key)) {
                name = value;
            } else if ("description".equals(key)) {
                description = value;
            } else if ("id".equals(key)) {
                id = value;
            }
        }

        // Trả về đối tượng CategoryResponse
        return new CategoryResponse(id, name, description);
    }

    // Hàm chuyển đổi chuỗi JSON thành danh sách CategoryResponse
    public List<CategoryResponse> convertToCategoryList(String input) {
        List<CategoryResponse> categoryList = new ArrayList<>();

        // Loại bỏ dấu ngoặc vuông
        input = input.substring(1, input.length() - 1);

        // Tách các đối tượng theo dấu phẩy
        String[] items = input.split("},\\{");

        for (String item : items) {
            // Sử dụng hàm convertToCategory để chuyển đối tượng thành CategoryResponse
            categoryList.add(convertToCategory(item));
        }

        return categoryList;
    }
}
