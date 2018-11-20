import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Leaving this here as an example, not currently used
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("At least it isn't notepad");

        VBox vertBox = new VBox();

        MenuBar menuBar = createMenuBar();
        TextArea inputArea = new TextArea();

        //Adding the items to the mainLayout
        vertBox.getChildren().add(menuBar);
        vertBox.getChildren().add(inputArea);

        //Makes inputArea resize as you resize the window
        inputArea.prefWidthProperty().bind(vertBox.widthProperty());
        inputArea.prefHeightProperty().bind(vertBox.heightProperty());

        Scene mainScene = new Scene(vertBox, 400, 500);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private final MenuBar createMenuBar(){
        final String FILE_MENU_TITLE = "File";
        final String HELP_MENU_TITLE = "Help";

        final MenuBar menuBar = new MenuBar();

        final Menu fileMenu = new Menu(FILE_MENU_TITLE);
        final Menu helpMenu = new Menu(HELP_MENU_TITLE);

        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
