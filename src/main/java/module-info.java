module com.sae.sae2_02 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.sae.sae2_02 to javafx.fxml;
    exports com.sae.sae2_02.modele;
}