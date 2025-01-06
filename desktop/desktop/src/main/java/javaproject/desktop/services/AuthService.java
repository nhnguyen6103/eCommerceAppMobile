package javaproject.desktop.services;

import javaproject.desktop.dtos.requests.UserRequest;
import javaproject.desktop.dtos.responses.UserResponse;
import javaproject.desktop.mapper.UserMapper;
import javaproject.desktop.untils.Constant;
import org.json.JSONObject;

import java.net.http.HttpResponse;

public class AuthService {

    private final ApiClient apiClient;
    private final UserMapper userMapper;

    public AuthService() {
        this.apiClient = new ApiClient();
        this.userMapper = new UserMapper();
    }

    public UserResponse signin(UserRequest request) throws Exception {
        String url = STR."\{Constant.BASE_URL}auth/signin";
        HttpResponse<String> response = apiClient.sendPostRequest(url,request.toJSonString());

        //Convert to Json
        JSONObject jsonObject = new JSONObject(response.body());
        jsonObject = jsonObject.getJSONObject("data");

        //Set token
        String token = jsonObject.getString("token");
        Constant.setToken(token);

        //Convert to User Object and return
        return userMapper.toUserResponse(jsonObject.getJSONObject("user"));
    }
}
