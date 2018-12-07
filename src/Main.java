import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.util.ArrayList;
import java.util.ArrayDeque;

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

    private final Menu createFileMenu() {
	// File Menu
	ArrayDeque<MenuItem> menuItems = new ArrayDeque<MenuItem>();

        Menu menu = new Menu("File");

	menuItems.add(new MenuItem("Open..."));

	menuItems.getLast().setOnAction(new EventHandler<ActionEvent>() {
	    @Override 
	    public void handle(ActionEvent e) {
	        System.out.println("This is what happens when you copypasta...");

		//TODO Open File Chooser on correct stage
		//FileChooser fileChooser = new FileChooser();
	        //fileChooser.setTitle("Open File");
	        //fileChooser.showOpenDialog(fc);
    	    }
	});

	menuItems.add(new MenuItem("Save"));
	menuItems.add(new MenuItem("Save As..."));
	menuItems.add(new CheckMenuItem("Autosave"));
        menuItems.add(new MenuItem("Refresh"));
	menuItems.add(new MenuItem("Exit"));

	return createMenuItems(menu, menuItems);
    }

    private final Menu createEditMenu() {
	// Edit Menu
	ArrayDeque<MenuItem> menuItems = new ArrayDeque<MenuItem>();

        Menu menu = new Menu("Edit");

	menuItems.add(new MenuItem("Preferences"));

	return createMenuItems(menu, menuItems);
    }

    private final Menu createViewMenu() {
	// View Menu
	ArrayDeque<MenuItem> menuItems = new ArrayDeque<MenuItem>();

        Menu menu = new Menu("View");

	menuItems.add(new MenuItem("Split Horizontal"));
	menuItems.add(new MenuItem("Split Vertical"));
	menuItems.add(new MenuItem("Undo Split"));

	return createMenuItems(menu, menuItems);
    }

    private final Menu createHelpMenu() {
	// Help Menu
	ArrayDeque<MenuItem> menuItems = new ArrayDeque<MenuItem>();

        Menu menu = new Menu("Help");

	menuItems.add(new MenuItem("Keyboard Shortcuts"));
	menuItems.add(new MenuItem("About"));

	return createMenuItems(menu, menuItems);
    }

    private final Menu createMenuItems(Menu menu, ArrayDeque<MenuItem> menuItems) {
	// Helper for createXYZMenu functions
	for (MenuItem mi : menuItems) 
	    menu.getItems().add((menuItems.remove()));

	return menu;
    }


    private final MenuBar createMenuBar() {
        
	final String os = System.getProperty("os.name");
	final MenuBar menuBar = new MenuBar();

	if (os != null && os.startsWith("Mac"))
  	    menuBar.useSystemMenuBarProperty().set(true);

	ArrayList<Menu> menuBarMenus = new ArrayList<Menu>();

	menuBarMenus.add(createFileMenu());

        menuBarMenus.add(createEditMenu());

        menuBarMenus.add(createViewMenu());

        menuBarMenus.add(createHelpMenu());

	menuBar.getMenus().addAll(menuBarMenus);

	return menuBar;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
