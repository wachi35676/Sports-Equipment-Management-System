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
    exports project.sportsequipmentmanagementsystem.UIControllers.PrincipalScreenControllers;
    opens project.sportsequipmentmanagementsystem.UIControllers.PrincipalScreenControllers to javafx.fxml;
    exports project.sportsequipmentmanagementsystem.UIControllers.StudentScreenControllers;
    opens project.sportsequipmentmanagementsystem.UIControllers.StudentScreenControllers to javafx.fxml;
    exports project.sportsequipmentmanagementsystem.UIControllers.TeacherScreenController;
    opens project.sportsequipmentmanagementsystem.UIControllers.TeacherScreenController to javafx.fxml;
}