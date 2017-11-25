package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private int step = 0;
    private String answers;

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
    @FXML
    private Text aMess1;
    @FXML
    private Text aMess2;
    @FXML
    private Text aMess3;
    @FXML
    private Text aMess4;
    @FXML
    private Text aMess5;
    @FXML
    private Text aMess6;
    @FXML
    private Text aMess7;
    @FXML
    private Text aMess8;
    @FXML
    private Text aMess9;
    @FXML
    private Text aMess10;
    @FXML
    private Text aMess11;
    @FXML
    private Text aMess12;
    @FXML
    private Text bMess1;
    @FXML
    private Text bMess2;
    @FXML
    private Text bMess3;
    @FXML
    private Text bMess4;
    @FXML
    private Text bMess5;
    @FXML
    private Text bMess6;
    @FXML
    private Text bMess7;
    @FXML
    private Text bMess8;
    @FXML
    private Text bMess9;
    @FXML
    private Text bMess10;
    @FXML
    private Text bMess11;
    @FXML
    private Text bMess12;
    @FXML
    private TextArea messSent;
    @FXML
    private TextArea encryptedMess;

    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        promptText.setText("Welcome to the Simulated Encrypted Chat program, an educational tool for understanding encryption! \n\n Please enter your name below.");

        nextButton.setOnAction(e -> {
                runStep(step);
                step++;
            });
    }

    private void runStep(int s){
        switch(s) {
            case 0: Step0();
                    break;
            case 1: Step1();
                    break;
            case 2: Step2();
                    break;
            case 3: Step3();
                    break;
            case 4: Step4();
                    break;
            case 5: Step5();
                    break;
            case 6: Step6();
                    break;
            case 7: Step7();
                    break;
            case 8: Step8();
                    break;
            case 9: Step9();
                    break;
            case 10: Step10();
                    break;
            case 11: Step11();
                    break;
            case 12: Step12();
                    break;
        }
    }

    private void Step0(){
        String username;
        username = entryText.getText();
        nameText.setText(username + " !");
        promptText.setText("Hi, " + username + "!  \n\n" + "Encryption is the process of encoding information so only authorized parties can access it. Encryption does NOT prevent your message from being intercepted by the privacy invaders of the Internet. However, encryption does ensure that only the intended recipient(s) will be able to decode your message.");
        entryText.setText("");
    }

    private void Step1(){
        promptText.setText("As a dedicated protector of privacy, this program strives to deliver effective chat encryption so information is only accessible by intended recipients. \n\n Let’s get started!");
    }

    private void Step2(){
        promptText.setText("To encrypt anything, a key must be used alongside an encryption algorithm to encode and decode the information.\n\n" +
                "Symmetric encryption is a simple method, that requires a single key for encrypting and decrypting data. \n\n" +
                "Asymmetric encryption is a more secure method and requires different keys for encrypting and decrypting data.");
    }

    private void Step3(){
        promptText.setText("Since this program aims to provide the highest security, we use asymmetric encryption.\n\n" +
                "A key pair is generated for all our users, containing:\n\n" +
                "A public key, used to encrypt. You share this key with other users so they can send you encrypted messages.\n\n" +
                "A private key, used to decrypt. ONLY YOU should have this key. If someone else gets access to your private key, they can decrypt messages that were meant for your eyes only.\n" +
                "\n" +
                "Let’s generate your key pair, now!\n");
    }

    private void Step4(){
        Encrypt Aenc = new Encrypt();
        try {
            Aenc.generateRSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String aPri = Aenc.privatekey;
        String aPub = Aenc.publickey;
        aPriText.setText(aPri);
        aPubText.setText(aPub);

        Encrypt Benc = new Encrypt();
        try {
            Benc.generateRSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String bPri = Benc.privatekey;
        String bPub = Benc.publickey;
        bPriText.setText(bPri);
        bPubText.setText(bPub);

        promptText.setText("Your RSA key pair has been generated! Take a look!" +
                "\n" +
                "For learning purposes, we'll show Bob's keys as well!");

    }

    private void Step5(){
        promptText.setText("Let’s send a message to your good ‘ol friend, Bob!" +
                "\n\n" +
                "Enter your message below.");
    }

    private void Step6(){
        messSent.setText(entryText.getText());
        entryText.setText("");
        promptText.setText("To ensure nobody but Bob can read the contents of your message, let’s encrypt it!\n\n" +
                "Which key are we going to encrypt with?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
    }

    private void Step7(){
        answers = entryText.getText();
        if( answers.equals("a") || answers.equals("a.") || answers.equals("A") || answers.equals("A."))
        {
            promptText.setText("Correct! The message should be encrypted using Bob’s public key.\n\n" +
                    "Then the message can only be decrypted with Bob’s private key, which only Bob should have.\n" +
                    "This ensures only Bob will be able to decode your message. \n");
            entryText.setText("");
        } else
        {
            promptText.setText("Not quite! The message should be encrypted using Bob’s public key.\n\n" +
                    "Then the message can only be decrypted with Bob’s private key, which only Bob should have.\n" +
                    "This ensures only Bob will be able to decode your message. \n");
            entryText.setText("");
        }

    }

    private void Step8(){
        promptText.setText("We have a database of all of our users’ public keys.\n" +
                "We will retrieve Bob’s public key and use it to encrypt your message.");
    }

    private void Step9(){
        promptText.setText("Your message has been encrypted!\n" +
                "Check out the original and encrypted versions.");
        encryptedMess.setText("Insert encrypted version here! :)");
    }

    private void Step10(){
        promptText.setText("Your message has been sent! While we’re waiting for a reply.. \n\n" +
                "Which key will Bob use to decrypt your message?\n" +
                "a. Bob’s public key\n" +
                "b. Bob’s private key\n" +
                "c. Your public key\n" +
                "d. Your private key\n");
    }

    private void Step11(){
        answers = entryText.getText();
        if( answers.equals("b") || answers.equals("b.") || answers.equals("B") || answers.equals("B."))
        {
            promptText.setText("Correct! Bob will decrypt using his private key!");
        } else
        {
            promptText.setText("Not quite! Bob will decrypt using his private key.");
        }
        entryText.setText("");
        aMess1.setFill(Color.BLUE);
        aMess1.setText(messSent.getText());
        aMess1.setTextAlignment(TextAlignment.RIGHT);
        bMess1.setFill(Color.BLACK);
        bMess1.setText(messSent.getText());
        bMess1.setTextAlignment(TextAlignment.LEFT);

    }

    private void Step12(){
        promptText.setText("Bob has sent you a message!");
    }
}
