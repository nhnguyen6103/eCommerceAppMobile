package javaproject.desktop.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javaproject.desktop.dtos.requests.UserRequest;
import javaproject.desktop.dtos.responses.CategoryResponse;
import javaproject.desktop.dtos.responses.ProductResponse;
import javaproject.desktop.dtos.responses.UserResponse;
import javaproject.desktop.services.AuthService;
import javaproject.desktop.services.CategoryService;
import javaproject.desktop.services.ProductService;
import javaproject.desktop.services.UserService;
import javaproject.desktop.untils.Constant;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private ImageView img;

    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;

    @FXML private JFXButton productBtn;
    @FXML private JFXButton cateBtn;
    @FXML private JFXButton userBtn;
    @FXML private JFXButton addBtn;

    private int flag = -1;

    private List<ProductResponse> lProduct = new ArrayList<>();
    private List<CategoryResponse> lCate = new ArrayList<>();
    private List<UserResponse> lUser = new ArrayList<>();
    @FXML
    private void loadProducts(ActionEvent event) throws Exception {
        System.out.println("Product Button onClick");

        if(Constant.isChanged())
        {
            flag = -1;
            reload();
            Constant.setChanged(false);
        }

        if(flag == 0)
        {
            return;
        }



        flag = 0;
        grid.getChildren().clear();

        int col = 1;
        int row = 0;

        for(int i = 0; i < lProduct.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/javaproject/desktop/fxml/product_item.fxml"));
            AnchorPane pane = loader.load();

            ProductController productController = loader.getController();
            productController.setData(lProduct.get(i));

            if (col == 4)
            {
                col = 1;
                ++row;
            }

            grid.add(pane,col++,row);
            GridPane.setMargin(pane,new Insets(30));
        }
    }

    @FXML
    private void loadCates(ActionEvent event) throws Exception {
        System.out.println("Category Button onClick");

        if(Constant.isChanged())
        {
            flag = -1;
            reload();
            Constant.setChanged(false);
        }

        if(flag == 1)
        {
            return;
        }



        grid.getChildren().clear();
        flag = 1;

        int col = 1;
        int row = 0;

        for(int i = 0; i < lCate.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/javaproject/desktop/fxml/cate_item.fxml"));
            AnchorPane pane = loader.load();

            CategoryController controller = loader.getController();
            controller.setData(lCate.get(i));


            if (col == 4)
            {
                col = 1;
                row ++;
            }

            grid.add(pane,col++,row);
            GridPane.setMargin(pane,new Insets(30));
        }
    }



    @FXML
    private void loadUsers(ActionEvent event) throws Exception {
        System.out.println("User Button onClick");

        if(Constant.isChanged())
        {
            flag = -1;
            reload();
            Constant.setChanged(false);
        }

        if(flag == 2)
        {
            return;
        }

        grid.getChildren().clear();
        flag = 2;

        int col = 1;
        int row = 0;

        for(int i = 0; i < lUser.size(); i++) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/javaproject/desktop/fxml/user_item.fxml"));
            AnchorPane pane = loader.load();

            UserController controller = loader.getController();
            controller.setData(lUser.get(i));

            if (col == 4)
            {
                col = 1;
                row ++;
            }

            grid.add(pane,col++,row);
            GridPane.setMargin(pane,new Insets(30));
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
        AuthService authService = new AuthService();
        UserRequest request = new UserRequest("admin@ad.com","admin123");
        UserResponse admin =  authService.signin(request);

        nameLabel.setText(admin.getUsername());
        emailLabel.setText(admin.getEmail());
        phoneLabel.setText(admin.getPhoneNumber());

        String fullPath = STR."D:\\Study\\JAVA\\Project\\server\\\{admin.getImageURL()}";
        Image image = new Image(STR."file:\{fullPath}");
        img.setImage(image);

        reload();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void reload() throws Exception {
        ProductService productService = new ProductService();
        lProduct = productService.getAllProducts();

        CategoryService categoryService = new CategoryService();
        lCate = categoryService.getAllCategory();

        UserService userService = new UserService();
        lUser = userService.getAllUser();
    }

    @FXML
    private void setAddBtn(ActionEvent event)
    {
        switch (flag)
        {
            case 0: addProduct();   break;
            case 1: addCate();      break;
            case 2: addUser();      break;
        }
    }

    private void addProduct()
    {

    }

    private void addCate()
    {

    }

    private void addUser()
    {

    }
}
