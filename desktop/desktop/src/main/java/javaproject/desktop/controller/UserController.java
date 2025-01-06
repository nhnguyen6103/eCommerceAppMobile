package javaproject.desktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javaproject.desktop.dtos.responses.UserResponse;
import javaproject.desktop.services.ProductService;
import javaproject.desktop.services.UserService;
import javaproject.desktop.untils.Constant;

public class UserController {

    private String id;

    @FXML
    private Button delBtn;

    @FXML
    private ImageView userImg;

    @FXML
    private Label userName;

    @FXML
    private Label userPhone;
    @FXML
    private Label userEmail;

    @FXML
    private void deleteItem(ActionEvent event) throws Exception {
        UserService service = new UserService();
        service.deleteUser(id);
        Constant.setChanged(true);
    }

    public void setData(UserResponse user)
    {
        String fullPath = STR."D:\\Study\\JAVA\\Project\\server\\\{user.getImageURL()}";
        Image image = new Image(STR."file:\{fullPath}");
        userImg.setImage(image);

        userName.setText(user.getUsername());
        userPhone.setText(user.getPhoneNumber());
        userEmail.setText(user.getEmail());

        id = user.getId();
    }

}
