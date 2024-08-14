module pprog.ui.gui {
    requires AuthLib;
    requires java.logging;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.commons.lang3;

    opens app.ui.gui to javafx.fxml;
    exports app.ui.gui to javafx.graphics;
    opens app.domain to javafx.base;
    opens app.interfaces to javafx.base;
    exports app.ui to javafx.graphics;
    opens app.ui to javafx.fxml;
    opens app.domain.model to javafx.base;
    opens app.domain.interfaces to javafx.base;

}