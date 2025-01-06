package javaproject.desktop.mapper;


import javaproject.desktop.dtos.responses.UserResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public UserResponse toUserResponse (JSONObject jsonObject)
    {
        String id = jsonObject.getString("id");
        String username = jsonObject.getString("username");
        String email = jsonObject.getString("email");
        String imageURL = jsonObject.getString("imageURL");
        String phoneNumber = jsonObject.getString("phoneNumber");
        return new UserResponse(id,username,email,phoneNumber,imageURL);
    }

    public UserResponse toUserResponse(String data)
    {
        return null;
    }

    public List<UserResponse> toUserList(String data) {
        JSONArray jsonArray = new JSONArray(data);
        List<UserResponse> userList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            UserResponse userResponse = toUserResponse(jsonObject);
            userList.add(userResponse);
        }
        return userList;
    }
}
