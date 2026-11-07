package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.BackendManager;

public class JavaFXApplication extends Application {

    private BackendManager backendManager;

    @Override
    public void init() throws Exception {
        super.init();
        backendManager = new szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.SpringBackendManager();
        backendManager.start();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(JavaFXApplication.class.getResource("/szoftver_fejlesztes_mozi/szoftver_fejlesztes_mozi/sablon.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Mozi Menedzser Rendszer");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        if (backendManager != null) {
            backendManager.stop();
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}