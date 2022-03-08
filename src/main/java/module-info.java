module com.example.jotto_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.berryroe.jotto_ to javafx.fxml;
    exports com.berryroe.jotto_;
}