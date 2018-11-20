import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Leaving this here as an example, not currently used
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("At least it isn't notepad");

        TextArea inputArea = new TextArea();
        VBox vertBox = new VBox(inputArea);

        //Makes inputArea resize as you resize the window
        inputArea.prefWidthProperty().bind(vertBox.widthProperty());
        inputArea.prefHeightProperty().bind(vertBox.heightProperty());

        Scene mainScene = new Scene(vertBox, 400, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
