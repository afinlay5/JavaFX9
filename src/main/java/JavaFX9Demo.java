/**
* This is a sample Java FX Application written to 
* show basic structure and the lifecyle methods as well
* a few other features such as event handling & backgrounds.
*   
*
* @author  Adrian D. Finlay
* @version 1.0
* @since   2017-09-30
*/

package src.main.java;

import java.io.File;
import java.io.FileInputStream;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import static java.lang.System.out;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
 
//Hello JavaFX World Application
public class JavaFX9Demo extends Application {

    //Keep track of how many times we hit "Hello World"
    static int ctr =0;
    
    //Collection to store the Background Images. 
    // We need an ordered collection.
    // We do not need to mutate the values.
    // While an array is ordered is does not implement Iterable<T>,
    // which we will need. We need something like an Ordered Set.
    // A LinkedHashSet might be a good selection, it uses a doubly-linked
    // list to maintain insertion order (the order in which elements are inserted).
    // which defines the iteration order. We also don't need to worry about accessing
    // by index, just that it maintains insertion order. It is a more efficient than a TreeSet for our purposes.
    // The LinkedHashMap collection is similar to the LinkedHashSet but it offers a key-value pair
    // This will be useful to keeping track of the images.
    LinkedHashMap<String, Background> collection = new LinkedHashMap<>(3);
    
    //An Interator to cycle through array
    Iterator <String> it = collection.keySet().iterator();
    
    //Launches the application: Application.launch()
    public static void main(String[] args) { launch(args); }
    
    @Override //init() not mandatory to override
    public void init() {out.println("This is the first lifecycle method -- init().");}

    @Override //start(Stage stage) mandatory to override
    public void start(Stage main) {
        //Notice when the lifecycle methods are called.
        out.println("This is the second lifecycle method -- start(Stage stage).");

        String user_dir = System.getProperty("user.dir");
        File root = null;

        //Root for .class file $ProjectRoot/
        if (user_dir.endsWith("JavaFX9Demo")) {
            root = new File ( System.getProperty("user.dir"), "build/resources/main/").getAbsoluteFile();
        }
        //Root for .jar file $ProjectRoot/build/jfx/app
        else if (user_dir.endsWith("build/jfx/app")) {
            root = new File ( user_dir.substring(0, user_dir.lastIndexOf("/build/jfx/app")) , "build/resources/main/").getAbsoluteFile();
            out.println(root);
        }
        //Root for Native executables $ProjectRoot/build/jfx/native/JavaFX9Demo
        else if (user_dir.endsWith("build/jfx/native/JavaFX9Demo/")) {
            root = new File ( user_dir.substring(0, user_dir.lastIndexOf("build/jfx/native/JavaFX9Demo/")) , "build/resources/main/").getAbsoluteFile();
        }
        else {
            out.println(user_dir);
            System.err.println("Application did not configure settings for this root directory.");
            System.exit(0);
        }

                    
        //Let's give it an icon
        try{ main.getIcons().add( new Image( new FileInputStream (new File(root , "/JavaFX9Demo.png") ) ) ); }
        catch (java.io.FileNotFoundException fnfe) { out.println("The app's icon file is missing."); }

        //Let's give it two Images to toggle in the background
        Image bkg = null;
        try{ bkg = new Image( new FileInputStream (new File(root , "Java1.jpg") ) ); }
        catch (java.io.FileNotFoundException fnfe) { out.println("The app's image file is missing."); }
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(bkg, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        collection.put("JAVA1",background);

        Image bkg2 = null;
        try{ bkg2 = new Image( new FileInputStream (new File(root , "/Java2.png") ) ); }
        catch (java.io.FileNotFoundException fnfe) { out.println("The app's image file is missing."); }
        BackgroundSize backgroundSize2 = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage2 = new BackgroundImage(bkg2, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize2);
        Background background2 = new Background(backgroundImage2);
        collection.put("JAVA2", background2);

        Image bkg3 = null;
        try{ bkg3 = new Image( new FileInputStream (new File(root , "/Java3.png") ) ); }
        catch (java.io.FileNotFoundException fnfe) { out.println("The app's image file is missing."); }
        BackgroundSize backgroundSize3 = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage3 = new BackgroundImage(bkg3, BackgroundRepeat.NO_REPEAT, 
            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize3);
        Background background3 = new Background(backgroundImage3);
        collection.put("JAVA3", background3);

        //Let's give it a UI pane that will be the root node
        StackPane rootNode = new StackPane();

        //Let's add the UI pane to the Scene and configure the Scene size
        Scene scene = new Scene(rootNode, 200, 273);

        //Let's give it a button and configure the button
        Button btn = new Button();
        btn.setText("'Hello JavaFX World!'");
        btn.setOnAction( (x) -> { 
            //Increment the counter to track the amount of events fired
            ctr++;
            
            //If we're at the end let's go back
            //to the beginning.
            if (!it.hasNext())
                it = collection.keySet().iterator();

            //By this point we know that it has next()
            String selected = (String)it.next();
            out.println("Hello JavaFX World! #" + ctr + " | "
                        + "Current Background,\"" + selected + "\": " 
                        + collection.get(selected).toString());

            //Now let's assign the background image 
            //and the correct size properties

            if (selected.equals("JAVA1")) { 
                main.setWidth(200);
                main.setHeight(273);
                rootNode.setBackground(collection.get(selected)); 
            }
            else if (selected.equals("JAVA2")) {
                main.setWidth(200); 
                main.setHeight(200); 
                rootNode.setBackground(collection.get(selected));
            }
            else if (selected.equals("JAVA3")) {
                main.setWidth(226); 
                main.setHeight(407);
                rootNode.setBackground(collection.get(selected));
            }
            else { out.println("Congratulations, you're a jedi.");}

        });
 
        //Let's add the button to the root node
        rootNode.getChildren().add(btn);

        //Let's set the Stage's Title (Application Title)
        main.setTitle("Hello World!");
        //Let's set the scene on the Stage!
        main.setScene(scene);
        //Let's display the Stage: Displaying the Application
        main.show();
    }

    @Override //stop() not mandatory to override
    public void stop() {out.println("This is the last lifecycle method -- stop().");}
}