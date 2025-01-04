package javaproject.desktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javaproject.desktop.dtos.responses.ProductResponse;
import javaproject.desktop.services.ProductService;

public class ProductController {

    private String id;

    @FXML
    private Button delBtn;

    @FXML
    private ImageView itemImg;

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;

    @FXML
    private void deleteItem(ActionEvent event)
    {
        ProductService productService = new ProductService();


    }

    public void setData(ProductResponse item)
    {
        String fullPath = STR."D:\\Study\\JAVA\\Project\\server\\\{item.getImageURL()}";
        Image image = new Image(STR."file:\{fullPath}");
        itemImg.setImage(image);

        itemName.setText(item.getName());
        itemPrice.setText(STR."$ \{item.getPrice().toString()}");

        id = item.getId();
    }

}
