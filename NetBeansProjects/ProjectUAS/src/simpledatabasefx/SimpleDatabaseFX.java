
package simpledatabasefx;
 
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import simpledatabasefx.connectdb.DatabaseConnect;
import simpledatabasefx.model.modelDatabase;
 
/**
 *
 * @author arief
 */
 
/**
 * Modifikasi dari kode sumber
 * http://fx-007.blogspot.com/2014/11/crud-javafx.html (SceneBuilder 2.0)
 **/
public class SimpleDatabaseFX extends Application {
    public TableView tblView;
    private Text txtInfo;
    private Label lblTitle,lblData,lblNIM,lblNAMA,lblJURUSAN,lblALAMAT,lblCari;
    public TextField txtNIM,txtNAMA,txtJURUSAN,txtALAMAT,txtCARI;
    public TableColumn tblColumn1,tblColumn2,tblColumn3,tblColumn4;
    private SplitPane splitPaneH;
    private VBox panevbox,panevbox2;
    private AnchorPane pane;
    private GridPane grid;
    private HBox panehbox,searchbox;
    private Button btnAdd,btnUpdate,btnDelete,btnClear,btnClose,btnRefresh;
    modelDatabase modelDb;
    ObservableList data = FXCollections.observableArrayList();
   
    public void initComponent(){
      //========================================================================
        lblData    = new Label("FORM DATA");
        lblTitle   = new Label();
        lblNIM     = new Label("NIM");
        lblNAMA    = new Label("NAMA");
        lblJURUSAN = new Label("JURUSAN");
        lblALAMAT  = new Label("ALAMAT");
        lblCari    = new Label("CARI DATA :");
        txtInfo    = new Text("No data");
        tblColumn1 = new TableColumn("NIM");
        tblColumn2 = new TableColumn("NAMA");
        tblColumn3 = new TableColumn("JURUSAN");
        tblColumn4 = new TableColumn("ALAMAT");
        txtNIM     = new TextField();
        txtNAMA    = new TextField();
        txtJURUSAN = new TextField();
        txtALAMAT  = new TextField();
        txtCARI    = new TextField();
        splitPaneH = new SplitPane();
        pane       = new AnchorPane();
        panevbox   = new VBox();
        panevbox2  = new VBox();
        grid       = new GridPane();
        panehbox   = new HBox(5);
        searchbox  = new HBox(5);
        tblView    = new TableView();
        btnAdd     = new Button("ADD");
        btnUpdate  = new Button("UPDATE");
        btnDelete  = new Button("DELETE");
        btnClear   = new Button("CLEAR");
        btnClose   = new Button("CLOSE");
        btnRefresh = new Button("REFRESH");
      //========================================================================
        tblColumn1.setCellValueFactory(new PropertyValueFactory("nim"));
        tblColumn2.setCellValueFactory(new PropertyValueFactory("nama"));
        tblColumn3.setCellValueFactory(new PropertyValueFactory("jurusan"));
        tblColumn4.setCellValueFactory(new PropertyValueFactory("alamat"));
       
        txtNIM.setPromptText("Masukkan NIM Anda");
        txtNAMA.setPromptText("Masukkan Nama Anda");
        txtJURUSAN.setPromptText("Masukkan Jurusan Anda");
        txtALAMAT.setPromptText("Masukkan Alamat Anda");
        txtCARI.setPromptText("Masukkan data yang ingin dicari");
       
        lblCari.setPadding(new Insets(10));
        lblCari.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM, 12));
        lblCari.setAlignment(Pos.CENTER);
        lblCari.setUnderline(true);
       
        lblData.setPadding(new Insets(10));
        lblData.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM, 22));
        lblData.setUnderline(true);
        lblData.setAlignment(Pos.CENTER);
       
        lblTitle.setText("Database Universitas");
        lblTitle.setUnderline(true);
        lblTitle.setPadding(new Insets(10));
        lblTitle.setFont(Font.font("Comic Sans MS", FontWeight.MEDIUM, 22));
        lblTitle.setAlignment(Pos.CENTER);
       
        lblNIM.setPrefSize(100, 30);
        lblNAMA.setPrefSize(100, 30);
        lblJURUSAN.setPrefSize(100, 30);
        lblALAMAT.setPrefSize(100, 30);
       
        txtNIM.setPrefSize(250, 30);
        txtNAMA.setPrefSize(250, 30);
        txtJURUSAN.setPrefSize(250, 30);
        txtALAMAT.setPrefSize(250, 30);
        txtCARI.setPrefSize(250, 30);
       
        tblView.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        tblView.setPlaceholder(txtInfo);
        tblView.setPadding(new Insets(10));
        tblView.getColumns().addAll(tblColumn1,tblColumn2,tblColumn3,tblColumn4);
        tblView.setPrefHeight(250);
        tblView.setBackground(new Background(
                new BackgroundFill(Color.LIGHTBLUE,new CornerRadii(15),Insets.EMPTY)));
       
        panehbox.setAlignment(Pos.CENTER);
        panehbox.setPadding(new Insets(10));
        panehbox.setLayoutX(23);
        panehbox.setLayoutY(194);
        panehbox.getChildren().addAll(btnAdd,btnUpdate,btnDelete,btnClear,btnClose);
        panehbox.setBackground(new Background(new BackgroundFill(
                Color.DARKGRAY, new CornerRadii(10), Insets.EMPTY)));
       
        searchbox.setAlignment(Pos.CENTER_LEFT);
        searchbox.setPadding(new Insets(5));
        searchbox.getChildren().addAll(lblCari,txtCARI,btnRefresh);
        searchbox.setBackground(new Background(new BackgroundFill(
                Color.DARKGRAY, new CornerRadii(10), Insets.EMPTY)));
       
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setLayoutX(5);
        grid.setLayoutY(5);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.addRow(0, lblNIM,txtNIM);
        grid.addRow(1, lblNAMA,txtNAMA);
        grid.addRow(2, lblJURUSAN,txtJURUSAN);
        grid.addRow(3, lblALAMAT,txtALAMAT);
        grid.setGridLinesVisible(false);
       
        pane.setBorder(new Border(new BorderStroke(
                Color.WHITESMOKE,BorderStrokeStyle.DASHED,
                new CornerRadii(15),new BorderWidths(5),Insets.EMPTY)));
        pane.setBackground(new Background(new BackgroundFill(
                Color.LIGHTGRAY, new CornerRadii(15),Insets.EMPTY)));
        pane.getChildren().addAll(grid,panehbox);
       
        panevbox.getChildren().addAll(lblTitle,tblView,searchbox);
        panevbox.setPadding(new  Insets(5));
        panevbox.setSpacing(5);
        panevbox.minWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));
        panevbox.maxWidthProperty().bind(splitPaneH.widthProperty().multiply(0.70));
       
        panevbox2.getChildren().addAll(lblData,pane);
        panevbox2.setPadding(new Insets(5));
        panevbox2.setSpacing(5);
       
        splitPaneH.setOrientation(Orientation.HORIZONTAL);
        splitPaneH.getItems().addAll(panevbox,panevbox2);
        splitPaneH.setPadding(new Insets(2));
        splitPaneH.setBackground(new Background(
                   new BackgroundFill(Color.GRAY,CornerRadii.EMPTY,Insets.EMPTY)));
        splitPaneH.setDividerPositions(0.5);
    }
    /**=======================================================================================
     *                       UNTUK MENAMPUNG DATA DARI DATABASE
     * =======================================================================================
     **/
   
    /**
    * @return
    **/
    private ObservableList loadData(){
            ObservableList listData = FXCollections.observableArrayList();
            try {
            Connection c    = DatabaseConnect.tryConnect();
            String sql1     = "select * from mhs;";
            ResultSet rs1   = c.createStatement().executeQuery(sql1);
            while(rs1.next()){
                modelDb         = new modelDatabase(rs1.getString(1),rs1.getString(2),
                                                    rs1.getString(3),rs1.getString(4));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseFX.class.getName()).log(Level.SEVERE, null, ex);
        }
            return listData;
           
    }
   
    private ObservableList searchByNIM(String n){
        ObservableList listData = FXCollections.observableArrayList();
        try {
            Connection c = DatabaseConnect.tryConnect();
            String sql2 = " select distinct * from mhs where nim like '%"+n+"%';";
            ResultSet rs2 = c.createStatement().executeQuery(sql2);
            while(rs2.next()){
                modelDb         = new modelDatabase(rs2.getString(1),rs2.getString(2),
                                                    rs2.getString(3),rs2.getString(4));
                listData.add(modelDb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseFX.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
    //=======================================================================================
   
    /**======================================================================================
     *                      UNTUK MELAKUKAN INSERT, DELETE DAN UPDATE
     *              DIMANA DATA DIAMBIL DARI FORM KEMUDIAN DIKUMPULKAN DI MODEL
     * ======================================================================================
     **/
    private void insert(modelDatabase m){
        Connection c = DatabaseConnect.tryConnect();
        PreparedStatement ps;
        try {
            String sql = "insert into mhs values (?,?,?,?);";
            ps  = c.prepareStatement(sql);
            ps.setString(1,m.getNim());
            ps.setString(2,m.getNama());
            ps.setString(3,m.getJurusan());
            ps.setString(4,m.getAlamat());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseFX.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
   
    private void delete(modelDatabase m){
        try {
            Connection c = DatabaseConnect.tryConnect();
            PreparedStatement ps;
            String sql = "delete from mhs where nim = ?;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNim());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseFX.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    private void update(modelDatabase m){
        try {
            Connection c = DatabaseConnect.tryConnect();
            PreparedStatement ps;
            String sql = "update mhs set nama = ? ,jurusan = ? , alamat = ? where nim = ? ;";
            ps = c.prepareStatement(sql);
            ps.setString(1, m.getNama());
            ps.setString(2, m.getJurusan());
            ps.setString(3, m.getAlamat());
            ps.setString(4, m.getNim());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //=======================================================================================
   
    /**======================================================================================
     *                                   ACTIONEVENT  
     * ======================================================================================
     **/
    private void selectData(){
        modelDb = (modelDatabase) tblView.getSelectionModel().getSelectedItems().get(0);
        txtNIM.setText(modelDb.getNim());
        txtNAMA.setText(modelDb.getNama());
        txtJURUSAN.setText(modelDb.getJurusan());
        txtALAMAT.setText(modelDb.getAlamat());
        txtNIM.setDisable(true);
    }
   
    private void deleteData(){
        modelDb = new modelDatabase(txtNIM.getText(), "", "", "");
        delete(modelDb);
        clearData();
        showData();
    }
   
    private void updateData(){
        modelDb = new modelDatabase(txtNIM.getText(),txtNAMA.getText(),
                                    txtJURUSAN.getText(),txtALAMAT.getText());
        update(modelDb);
        clearData();
        showData();
    }
   
    private void searchbyNIM(){
        data.clear(); // <- menghapus data pada penampung data
        data = searchByNIM(txtCARI.getText().trim());
        tblView.setItems(data); // <- menaruh data pada tabel agar bisa tampil
        tblView.getSelectionModel().clearSelection(); // <- menghapus seleksi baris pada tabel
    }
   
    private void refresh(){
        showData();
        clearData();
        txtCARI.clear();
    }
   
    private void showData(){
        data.clear();
        data = loadData();
        tblView.setItems(data);
        tblView.getSelectionModel().clearSelection();
    }
   
    private void clearData(){
        txtNIM.clear();
        txtNAMA.clear();
        txtJURUSAN.clear();
        txtALAMAT.clear();
        txtNIM.setDisable(false);
        tblView.getSelectionModel().clearSelection();
    }
   
    private void addData(){
        // mengambil data dari form, kemudian disusun seperti array
        modelDb = new modelDatabase(txtNIM.getText(),txtNAMA.getText(),
                                    txtJURUSAN.getText(),txtALAMAT.getText());
        insert(modelDb); //<- data dikirim ke SQL
        showData();
        clearData();
    }
  //====================================================================================    
    @Override
    public void start(Stage primaryStage) {
        initComponent(); // <- VIEW
        showData();     // <- MENAMPILKAN DATA
        tblView.setOnMousePressed((MouseEvent event) -> {
            selectData(); // <- EVENT BARIS KETIKA DIPILIH
        });
        btnAdd.setOnAction((ActionEvent e) -> {
            addData(); // <- INSERT DATA
        });
        btnClear.setOnAction((ActionEvent e) -> {
            clearData(); // <- CLEAR FIELD INPUT DATA
        });
        btnClose.setOnAction((ActionEvent e) -> {
            primaryStage.close(); // <- CLOSE SCENE WINDOW
        });
        btnUpdate.setOnAction((ActionEvent e) -> {
            updateData(); // <- UPDATE DATA
        });
        btnDelete.setOnAction((ActionEvent e) -> {
            deleteData(); // <- DELETE DATA
        });
        btnRefresh.setOnAction((ActionEvent e) -> {
            refresh(); // <- MENGEMBALIKAN TAMPILAN SEPERTI SEMULA
        });
        txtCARI.setOnKeyTyped((KeyEvent ke) -> {
            searchbyNIM(); // <- SEARCH DATA BY NIM
        });
        Scene scene = new Scene(splitPaneH, 1366, 768);
        primaryStage.setTitle("APLIKASI SIMPLE DATABASE FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        launch(args);
       
    }
   
}