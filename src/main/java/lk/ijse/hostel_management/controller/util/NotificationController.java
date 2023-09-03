package lk.ijse.hostel_management.controller.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.util.Optional;

public class NotificationController {
    public static void ErrorMasseage(String messeage) {

        VBox vBox=new VBox();
//        Label label=new Label(messeage);
        Text text=new Text(messeage);
        text.setFill(Color.WHITE);
        TextFlow textFlow=new TextFlow(text);
        vBox.getChildren().add(textFlow);

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.getDialogPane().setContent(vBox);

        alert.getDialogPane().setPrefSize(300, 150);
        alert.getDialogPane().setStyle("-fx-background-color: black ");
        alert.getDialogPane().setHeaderText(null);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("assets/error.png"));
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(cancelButton);

        alert.showAndWait();

    }

    public static void animationMesseage(String image, String title, String text) {
        Image img = new Image(String.valueOf(image), 96, 96, false, false);
        Notifications notificationBuilder = Notifications.create()
                .title(title)
                .text(text)
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(3));
        notificationBuilder.darkStyle();
        notificationBuilder.show();

    }


    public static boolean confirmationMasseage(String messeage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmation");
        alert.setHeaderText(null);
        alert.setContentText(messeage);

        alert.getDialogPane().setPrefSize(300, 150);
        alert.getDialogPane().setStyle("-fx-background-color: #dfa47e;");
        alert.getDialogPane().setHeaderText(null);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/assets/error.png"));
        ButtonType okButton = new ButtonType("ok", ButtonBar.ButtonData.CANCEL_CLOSE);
        ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        return result.orElse(cancelButton) == okButton;
    }
    public static void notificationBar(String title, String massage) throws AWTException {
        SystemTray tray = SystemTray.getSystemTray();
        java.awt.Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Notification Example");
        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Click me to see the message");
        tray.add(trayIcon);
        trayIcon.displayMessage(title, massage, TrayIcon.MessageType.INFO);
    }
}
