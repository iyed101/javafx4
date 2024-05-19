module com.example {
    requires java.sql;
    requires transitive javafx.controls;
    requires javafx.fxml;
    
    opens com.example to javafx.fxml;
    exports com.example;
}
