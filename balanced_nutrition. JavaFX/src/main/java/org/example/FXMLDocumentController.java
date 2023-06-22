package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.hpsf.Decimal;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.StyledEditorKit;
import java.sql.*;

public class FXMLDocumentController implements Initializable{
    public Button button;
    public Button addGroup;
    public Button updateListGroupList;
    public TextField groupTextFieldForUpdate;
    public Button updateGroup;
    public Button deleteGroup;
    @FXML
    private Label label;
    @FXML
    private TextField groupTextFieldForAdd;
    @FXML
    private ComboBox<String> groupTextField;
    @FXML
    private TextField dateTextField;
    private final ObservableList<Menu> menu = FXCollections.observableArrayList();
    private  final ObservableList<Products> products = FXCollections.observableArrayList();
    @FXML
    private TableView<Menu> tableMenu;
    @FXML
    private  TableView<Products> tableProducts;
    @FXML
    private TableColumn<Menu, Integer> planned_menu_id;
    @FXML
    private TableColumn<Menu, String> group_pm_name;
    @FXML
    private TableColumn<Menu, LocalDate> day_date;
    @FXML
    private TableColumn<Menu, String> meal_name;
    @FXML
    private TableColumn<Menu, String> dish_name;
    @FXML
    private TableColumn<Products, Integer> id_planned_menu;
    @FXML
    private TableColumn<Products, String> product_name;
    @FXML
    private TableColumn<Products, Decimal> product_weight;
    @FXML
    private TableColumn<Products, String> product_measure;
    @FXML
    private void addButtonAction (ActionEvent event){
        String groupForAdd = groupTextFieldForAdd.getText();
        AddGroup(groupForAdd);
    }
    
    @FXML
    private void updateListButtonAction (ActionEvent event){
        groupTextField.setItems(getGroups());
        groupTextField.getSelectionModel().select(0);
    }
    @FXML
    private void updateGroupByName (ActionEvent event){
        String oldName = groupTextField.getValue();
        String newName = groupTextFieldForUpdate.getText();
        UpdateGroup(oldName, newName);
    }
    @FXML
    private void deleteGroupByName (ActionEvent event){
        String groupName = groupTextField.getValue();
        DeleteGroup(groupName);
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        //startDate = LocalDate.parse("2023-04-12");
        if (groupTextField.getSelectionModel().getSelectedItem() != "" && dateTextField.getText() != ""){
            String groupName = groupTextField.getSelectionModel().getSelectedItem();
            LocalDate startDate = LocalDate.parse((dateTextField.getText()));
            menu.clear();
            initData(groupName, startDate);
            planned_menu_id.setCellValueFactory(new PropertyValueFactory<Menu, Integer>("planned_menu_id"));
            group_pm_name.setCellValueFactory(new PropertyValueFactory<Menu, String>("group_pm_name"));
            day_date.setCellValueFactory(new PropertyValueFactory<Menu, LocalDate>("day_date"));
            meal_name.setCellValueFactory(new PropertyValueFactory<Menu, String>("meal_name"));
            dish_name.setCellValueFactory(new PropertyValueFactory<Menu, String>("dish_name"));
            tableMenu.setItems(menu);


            initProducts(groupName, startDate);
            writeIntoExcel("C://Users//79536//OneDrive//Рабочий стол//JavaFX_practice CP//src//main//resources//Products.xls");
            id_planned_menu.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
            product_name.setCellValueFactory(new PropertyValueFactory<Products, String>("name"));
            product_weight.setCellValueFactory(new PropertyValueFactory<Products, Decimal>("weight"));
            product_measure.setCellValueFactory(new PropertyValueFactory<Products, String>("measure"));
            tableProducts.setItems(products);

            label.setText("Данные выведены в таблицу");
        }
        else{
            label.setText("Заполните поля!");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        groupTextField.setItems(getGroups());
        groupTextField.getSelectionModel().select(0);
    }
    @SuppressWarnings("deprecation")
    public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {
        try {
            Workbook book = new HSSFWorkbook();
            Sheet sheet = book.createSheet("Products");
            Row row = sheet.createRow(0);

            book.createFont().getBold();

            Cell menuId = row.createCell(0);
            menuId.setCellValue("N меню");

            Cell productName = row.createCell(1);
            productName.setCellValue("Продукт");

            Cell productWeight = row.createCell(2);
            productWeight.setCellValue("Суммарный объём");

            Cell productMeasure = row.createCell(3);
            productMeasure.setCellValue("Единица измерения");



            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select planned_menu.id_planned_menu, product.name, sum(product.product_weight)," +
                    " product_measure from planned_menu join day on planned_menu.id_planned_menu = day.id_planned_menu" +
                    " join meal on day.id_day = meal.id_day join meal_dish on meal.id_meal = meal_dish.id_meal" +
                    " join dish on dish.id_dish = meal_dish.id_dish join dish_product on dish.id_dish = dish_product.id_dish" +
                    " join product on dish_product.id_product = product.id_product" +
                    " group by product.name, product.product_measure, planned_menu.id_planned_menu;");
            int count = 0;
            while (rs.next()){
                row = sheet.createRow(count + 1);

                Products dataFromDB = new Products();
                dataFromDB.setId(rs.getInt(1));
                dataFromDB.setName(rs.getString("name"));
                dataFromDB.setWeight(rs.getDouble(3));
                dataFromDB.setMeasure(rs.getString("product_measure"));

                menuId = row.createCell(0);
                menuId.setCellValue(dataFromDB.id_planned_menu);

                productName = row.createCell(1);
                productName.setCellValue(dataFromDB.name);

                productWeight = row.createCell(2);
                productWeight.setCellValue(dataFromDB.weight);

                productMeasure = row.createCell(3);
                productMeasure.setCellValue(dataFromDB.measure);

                count++;

            }
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            book.write(new FileOutputStream(file));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void initData(String groupName, LocalDate dayDate){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select planned_menu.id_planned_menu planned_menu_id, group_pm.name group_pm_name, day.day_date day_date,\n" +
                    "       meal.name meal_name, dish.name dish_name from group_pm join planned_menu\n" +
                    "           on group_pm.id_group_pm = planned_menu.id_group_pm join\n" +
                    "           day on planned_menu.id_planned_menu = day.id_planned_menu\n" +
                    "           join meal on day.id_day = meal.id_day\n" +
                    "            join meal_dish on meal_dish.id_meal = meal.id_meal\n" +
                    "    join dish on meal_dish.id_dish = dish.id_dish where" +
                    " planned_menu.id_planned_menu =" + "'" + getPlannedMenuId(groupName, dayDate) + "';");
            while (rs.next()){
                Menu dataFromDB = new Menu();
                dataFromDB.setPlanned_menu_id(rs.getInt("planned_menu_id"));
                dataFromDB.setGroup_pm_name(rs.getString("group_pm_name"));
                dataFromDB.setDay_date(rs.getDate("day_date").toLocalDate());
                dataFromDB.setMeal_name(rs.getString("meal_name"));
                dataFromDB.setDish_name(rs.getString("dish_name"));
                menu.add(dataFromDB);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void initProducts(String groupName, LocalDate dayDate){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select planned_menu.id_planned_menu, product.name, sum(product.product_weight)," +
                    " product_measure from planned_menu join day on planned_menu.id_planned_menu = day.id_planned_menu" +
                    " join meal on day.id_day = meal.id_day join meal_dish on meal.id_meal = meal_dish.id_meal" +
                    " join dish on dish.id_dish = meal_dish.id_dish join dish_product on dish.id_dish = dish_product.id_dish" +
                    " join product on dish_product.id_product = product.id_product" +
                    " group by product.name, product.product_measure, planned_menu.id_planned_menu;");
            while (rs.next()){

                Products dataFromDB = new Products();
                dataFromDB.setId(rs.getInt(1));
                dataFromDB.setName(rs.getString("name"));
                dataFromDB.setWeight(rs.getDouble(3));
                dataFromDB.setMeasure(rs.getString("product_measure"));
                products.add(dataFromDB);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int getPlannedMenuId(String groupName, LocalDate dayDate){
        int id = 0;
        try{
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select planned_menu.id_planned_menu from planned_menu join " +
                    "group_pm on planned_menu.id_group_pm = group_pm.id_group_pm join " +
                    "day d on planned_menu.id_planned_menu = d.id_planned_menu where " +
                    "group_pm.name =" + "'" + groupName + "'" +
                                        " and d.day_date =" + "'" + dayDate + "';");
            while (rs.next()){
                id = rs.getInt("id_planned_menu");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }
    public ObservableList<String> getGroups(){
        List<String> groups = new ArrayList<String>();
        try{
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name from group_pm");
            while (rs.next()){
                groups.add(rs.getString(1));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return FXCollections.observableArrayList( groups);
    }
    public void AddGroup(String name){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            st.executeUpdate("insert into group_pm (name) values " +
                    " ("+ "'" + name + "')" );
            System.out.println("Данные добавлены");
        }
        catch (SQLException e){
            System.out.println("Данные не были добавлены");
            e.printStackTrace();
        }
    }
    public void UpdateGroup(String oldName, String newName){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            st.executeUpdate("update group_pm set name =" + "'" + newName + "'" +
                    " where name = " + "'" + oldName + "'");
            System.out.println("Данные изменены");
        }
        catch (SQLException e){
            System.out.println("Данные не были изменены");
            e.printStackTrace();
        }
    }
    public void DeleteGroup(String name){
        try {
            Properties props = new Properties();
            props.setProperty("options", "-c search_path=cp,public,pg_catalog -c statement_timeout=90000");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/balancednutrition?user=postgres&ssl=false",props);
            Statement st = con.createStatement();
            st.executeUpdate("delete from group_pm" +
                    " where id_group_pm  in (select id_group_pm from group_pm where " +
                    "name =" +"'" + name + "')");
            System.out.println("Данные удалены");
        }
        catch (SQLException e){
            System.out.println("Данные не были удалены");
            e.printStackTrace();
        }
    }
}
