package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    String username;
    int step = 0;
    @FXML
    private Text nameText;
    @FXML
    private Text aPubText;
    @FXML
    private Text aPriText;
    @FXML
    private Text bPubText;
    @FXML
    private Text bPriText;
    @FXML
    private TextArea promptText;
    @FXML
    private TextField entryText;
    @FXML
    private Button nextButton;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        promptText.setText("Welcome to the Simulated Encrypted Chat program, an educational tool for understanding encryption! Please enter your name below!");

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exampleStep();
            }
        });

    }

    public void exampleStep(){
        username = entryText.getText();
        nameText.setText(username + "!");
        promptText.setText("Hi, " + username + "!  \n" + "Encryption is the process of encoding information so only authorized parties can access it. Encryption does NOT prevent your message from being intercepted by the privacy invaders of the Internet. However, encryption does ensure that only the intended recipient(s) will be able to decode your message.");
        aPubText.setText("blah blah blah");
        aPriText.setText("bleh bleh bleh");
        bPubText.setText("I'm bob public");
        bPriText.setText("I'm bob private");
    }

}
