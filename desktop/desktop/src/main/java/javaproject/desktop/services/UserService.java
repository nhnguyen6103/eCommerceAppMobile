package javaproject.desktop.services;

import javaproject.desktop.dtos.responses.UserResponse;
import javaproject.desktop.mapper.UserMapper;
import javaproject.desktop.untils.Constant;
import org.json.JSONObject;

import java.net.http.HttpResponse;
import java.util.List;

public class UserService {
    private final ApiClient apiClient;
    private final UserMapper userMapper;

    public UserService() {
        this.apiClient = new ApiClient();
        this.userMapper = new UserMapper();
    }

    public List<UserResponse> getAllUser() throws Exception {
        String url = STR."\{Constant.BASE_URL}user";
        HttpResponse<String> response = apiClient.sendGetRequestWithToken(url,Constant.getToken());

        String body = response.body();
        JSONObject object = new JSONObject(body);
        String dataResponse = object.get("data").toString();

        return userMapper.toUserList(dataResponse);
    }

    public void deleteUser(String id) throws Exception {
        String url = STR."\{Constant.BASE_URL}user/\{id}";
        HttpResponse<String> response = apiClient.sendDeleteRequestWithBearerToken(url, Constant.getToken());
    }
}
