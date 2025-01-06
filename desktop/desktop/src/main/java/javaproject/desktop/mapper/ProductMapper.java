package javaproject.desktop.mapper;

import javaproject.desktop.dtos.responses.ProductResponse;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public ProductResponse toProduct(String item) {
        // Loại bỏ dấu ngoặc nhọn
        item = item.replace("{", "").replace("}", "");

        String[] fields = item.split(",");

        int quantity = 0;
        double price = 0;
        String imageURL = "", name = "", description = "", id = "", category = "";

        for (String field : fields) {
            String[] keyValue = field.split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            // Phân tích từng thuộc tính
            switch (key) {
                case "quantity":
                    quantity = Integer.parseInt(value);
                    break;
                case "price":
                    price = Double.parseDouble(value);
                    break;
                case "imageURL":
                    imageURL = value;
                    break;
                case "name":
                    name = value;
                    break;
                case "description":
                    description = value;
                    break;
                case "id":
                    id = value;
                    break;
                case "category":
                    category = value;
                    break;
            }
        }

        // Trả về đối tượng ProductResponse
        return new ProductResponse(id,name,category,imageURL,description,quantity,price);
    }

    // Hàm chuyển đổi chuỗi JSON thành danh sách ProductResponse
    public List<ProductResponse> toProductList(String input) {
        List<ProductResponse> productList = new ArrayList<>();

        // Loại bỏ dấu ngoặc vuông
        input = input.substring(1, input.length() - 1);

        // Tách các đối tượng theo dấu phẩy
        String[] items = input.split("},\\{");

        for (String item : items) {
            // Sử dụng hàm toProduct để chuyển đối tượng thành ProductResponse
            productList.add(toProduct(item));
        }

        return productList;
    }
}
