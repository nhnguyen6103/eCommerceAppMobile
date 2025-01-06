package javaproject.desktop.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javaproject.desktop.dtos.responses.CategoryResponse;
import javaproject.desktop.services.CategoryService;
import javaproject.desktop.untils.Constant;

public class CategoryController {

    private String id;

    @FXML
    private Label cateName;

    @FXML
    private Label cateDesc;

    @FXML
    private JFXButton delBtn;

    @FXML
    private void deleteItem(ActionEvent event) throws Exception {
        CategoryService service = new CategoryService();
        service.deleteCategory(id);
        Constant.setChanged(true);
    }

    public void setData(CategoryResponse item)
    {
        cateName.setText(item.getName());
        cateDesc.setText(item.getDescription());
        id = item.getId();
    }
}
