package javaproject.desktop.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javaproject.desktop.dtos.responses.ProductResponse;
import javaproject.desktop.services.ProductService;
import javaproject.desktop.untils.Constant;

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
    private void deleteItem(ActionEvent event) throws Exception {
        ProductService productService = new ProductService();
        productService.deleteProduct(id);
        Constant.setChanged(true);
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
