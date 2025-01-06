package javaproject.desktop.services;

import javaproject.desktop.dtos.responses.ProductResponse;
import javaproject.desktop.mapper.ProductMapper;
import javaproject.desktop.untils.Constant;
import org.json.JSONObject;

import java.net.http.HttpResponse;
import java.util.List;

public class ProductService {
    private final ApiClient apiClient;
    private final ProductMapper productMapper;


    public ProductService() {
        this.apiClient = new ApiClient();
        this.productMapper = new ProductMapper();
    }

    public List<ProductResponse> getAllProducts() throws Exception {
        String url = STR."\{Constant.BASE_URL}product";
        HttpResponse<String> response = apiClient.sendGetRequest(url);

        String body = response.body();
        JSONObject object = new JSONObject(body);
        String dataResponse = object.get("data").toString();

        return productMapper.toProductList(dataResponse);
    }

    public void deleteProduct(String id) throws Exception {
        String url = STR."\{Constant.BASE_URL}product/\{id}";
        HttpResponse<String> response = apiClient.sendDeleteRequestWithBearerToken(url, Constant.getToken());
    }
}
