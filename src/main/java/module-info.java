module project.sportsequipmentmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.sql;

    opens project.sportsequipmentmanagementsystem to javafx.fxml;
    exports project.sportsequipmentmanagementsystem;
    exports project.sportsequipmentmanagementsystem.UIControllers;
    opens project.sportsequipmentmanagementsystem.UIControllers to javafx.fxml;
}