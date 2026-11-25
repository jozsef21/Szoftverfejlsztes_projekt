package szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.backend.MoziSzerverApplication;
import szoftver_fejlesztes_mozi.szoftver_fejlesztes_mozi.frontend.Alkalmazas.Controller.Navigator;

import java.util.Optional;

public class JavaFXApplication extends Application {

    private static ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception {
        leallas();

        springContext = SpringApplication.run(MoziSzerverApplication.class);

        Navigator.setApplicationContext(springContext);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(JavaFXApplication.class.getResource("/szoftver_fejlesztes_mozi/szoftver_fejlesztes_mozi/Bejelentkezes.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/static/css/manager.css").toExternalForm());
        stage.setTitle("Mozi Menedzser Rendszer");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        if (springContext != null) {
            springContext.close();
        }
        super.stop();
        Platform.exit();
        System.exit(0);
    }

    private void leallas() {
        Optional<ProcessHandle> szulo = ProcessHandle.current().parent();
        while (szulo.isPresent()) {
            ProcessHandle folyamat = szulo.get();
            folyamat.onExit().thenRun(() -> {
                Platform.exit();
                System.exit(0);
            });
            szulo = folyamat.parent();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}