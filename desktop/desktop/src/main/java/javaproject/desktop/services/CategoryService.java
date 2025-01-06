package javaproject.desktop.services;

import javaproject.desktop.dtos.responses.CategoryResponse;
import javaproject.desktop.mapper.CategoryMapper;
import javaproject.desktop.untils.Constant;
import org.json.JSONObject;

import java.net.http.HttpResponse;
import java.util.List;

public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final ApiClient apiClient;


    public CategoryService() {
        this.categoryMapper = new CategoryMapper();
        this.apiClient = new ApiClient();
    }


    public List<CategoryResponse> getAllCategory() throws Exception {
        String url = STR."\{Constant.BASE_URL}category";
        HttpResponse<String> response = apiClient.sendGetRequest(url);

        String body = response.body();
        JSONObject object = new JSONObject(body);
        String dataResponse = object.get("data").toString();

        return categoryMapper.convertToCategoryList(dataResponse);
    }

    public void deleteCategory(String id) throws Exception {
        String url = STR."\{Constant.BASE_URL}category/\{id}";
        HttpResponse<String> response = apiClient.sendDeleteRequestWithBearerToken(url, Constant.getToken());
    }
}
