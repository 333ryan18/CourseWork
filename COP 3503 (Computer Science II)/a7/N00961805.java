// Francis Rukab - n00961805 COP3503 Assignment A7
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.control.Slider;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.util.Duration;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.beans.binding.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Priority;


public class n00961805 extends BounceBallSlider{
    public static void main(String[] args) throws Exception{
        Application.launch(args);
    }
}

class ButtonDemo extends Application {
    private static final String MEDIA_URL = "http://www.unf.edu/~n00961805/video.mp4";
    protected Text text = new Text(50, 200, "Francis Rukab");
    boolean paused = true;

    protected BorderPane getPane() {
        BorderPane pane =  new BorderPane();

        HBox paneForButtons = new HBox(20);
        Button btUp = new Button("Up",
                new ImageView("http://www.unf.edu/~n00961805/up.png"));
        Button btDown = new Button("Down",
                new ImageView("http://www.unf.edu/~n00961805/down.png"));
        paneForButtons.getChildren().addAll(btUp, btDown);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-width: 1px; -fx-border-color: gray");

        pane.setBottom(paneForButtons);

        btUp.setOnAction(e -> text.setY(text.getY() - 10));
        btDown.setOnAction(e -> text.setY(text.getY() + 10));

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);

        String topStringTest = "                                 ";
        Label lblTop = new Label (topStringTest);

        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        String playString = "http://www.unf.edu/~n00961805/play.png";
        String pauseString = "http://www.unf.edu/~n00961805/pause.png";
        String rewindString = "http://www.unf.edu/~n00961805/rewind.png";

        ImageView imgPlayButton = new ImageView(playString);
        ImageView imgPauseButton = new ImageView(pauseString);
        ImageView imgRewindButton = new ImageView(rewindString);

        Button playButton = new Button("", imgPlayButton);

        playButton.setOnAction(e -> {
            if(paused){
                mediaPlayer.play();
                playButton.setGraphic(imgPauseButton);
            }
            else{
                mediaPlayer.pause();
                playButton.setGraphic(imgPlayButton);
            }
            paused = !paused;
        });

        Button rewindButton = new Button("", imgRewindButton);
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, rewindButton,
                new Label("Volume"), slVolume);

        BorderPane pane2 = new BorderPane();
        pane2.setCenter(mediaView);
        pane2.setBottom(hBox);


        mediaView.setFitWidth(600);
        mediaView.setFitHeight(300);


        Pane paneForMedia = new Pane(pane2);

        GridPane gridPaneCenter = new GridPane();
        gridPaneCenter.add(paneForText, 0, 0);
        gridPaneCenter.add(lblTop, 1, 0);
        gridPaneCenter.add(paneForMedia, 2, 0);

        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);
        gridPaneCenter.getRowConstraints().add(row);

        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);
        gridPaneCenter.getColumnConstraints().add(col);

        pane.setCenter(gridPaneCenter);

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane gridPaneMain = new GridPane();

        gridPaneMain.setMaxSize(1000,500);
        gridPaneMain.setMinSize(1000,500);

        StackPane root = new StackPane(gridPaneMain);//Main Stack Pane
        NumberBinding maxScale = Bindings.min(root.widthProperty().divide(1000),
                root.heightProperty().divide(500));

        gridPaneMain.scaleXProperty().bind(maxScale);
        gridPaneMain.scaleYProperty().bind(maxScale);

        gridPaneMain.add(getPane(), 0,0);

        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);
        gridPaneMain.getRowConstraints().add(row);

        ColumnConstraints col = new ColumnConstraints();
        col.setHgrow(Priority.ALWAYS);
        col.setPercentWidth(100.0);
        gridPaneMain.getColumnConstraints().add(col);


        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("Multiple Functions");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

class CheckBoxDemo extends ButtonDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        Font fontBoldItalic = Font.font("Calibri",
                FontWeight.BOLD, FontPosture.ITALIC, 20);
        Font fontBold = Font.font("Calibri",
                FontWeight.BOLD, FontPosture.REGULAR, 20);
        Font fontItalic = Font.font("Calibri",
                FontWeight.NORMAL, FontPosture.ITALIC, 20);
        Font fontNormal = Font.font("Calibri",
                FontWeight.NORMAL, FontPosture.REGULAR, 20);

        text.setFont(fontNormal);

        VBox paneForCheckBoxes = new VBox(20);
        paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5));
        paneForCheckBoxes.setStyle("-fx-border-width: 1px; -fx-border-color: gray");
        CheckBox chkBold = new CheckBox("Bold");
        CheckBox chkItalic = new CheckBox("Italic");
        paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
        pane.setLeft(paneForCheckBoxes);

        EventHandler<ActionEvent> handler = e -> {
            if (chkBold.isSelected() && chkItalic.isSelected()) {
                text.setFont(fontBoldItalic);
            }
            else if (chkBold.isSelected()) {
                text.setFont(fontBold);
            }
            else if (chkItalic.isSelected()) {
                text.setFont(fontItalic);
            }
            else {
                text.setFont(fontNormal);
            }
        };

        chkBold.setOnAction(handler);
        chkItalic.setOnAction(handler);

        return pane;
    }
}

class RadioButtonDemo extends CheckBoxDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        VBox paneForRadioButtons = new VBox(20);
        paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
        paneForRadioButtons.setStyle
                ("-fx-border-width: 1px; -fx-border-color: gray");
        RadioButton rbDarkGray = new RadioButton("Dark Gray");
        RadioButton rbPink = new RadioButton("Pink");
        RadioButton rbBrown = new RadioButton("Brown");
        paneForRadioButtons.getChildren().addAll(rbDarkGray, rbPink, rbBrown);
        pane.setRight(paneForRadioButtons);

        ToggleGroup group = new ToggleGroup();
        rbDarkGray.setToggleGroup(group);
        rbPink.setToggleGroup(group);
        rbBrown.setToggleGroup(group);

        rbDarkGray.setOnAction(e -> {
            if (rbDarkGray.isSelected()) {
                text.setFill(Color.DARKGRAY);
            }
        });

        rbPink.setOnAction(e -> {
            if (rbPink.isSelected()) {
                text.setFill(Color.PINK);
            }
        });

        rbBrown.setOnAction(e -> {
            if (rbBrown.isSelected()) {
                text.setFill(Color.BROWN);
            }
        });

        return pane;
    }
}

class BounceBallSlider extends RadioButtonDemo {
    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        RectanglePane rectanglePane = new RectanglePane();

        Slider slSpeed = new Slider();
        slSpeed.setMax(20);
        rectanglePane.rateProperty().bind(slSpeed.valueProperty());

        BorderPane pane1 = new BorderPane();
        pane1.setCenter(rectanglePane);
        pane1.setBottom(slSpeed);
        pane1.setStyle
                ("-fx-border-width: 1px; -fx-border-color: gray");
        pane1.setPrefSize(200,100);

        pane.setTop(pane1);

        return pane;
    }

    class RectanglePane extends Pane {
        public final double width = 50;
        public final double height = 20;
        private double x = width, y = height;
        private double dx = 1, dy = 1;
        private Rectangle rectangle = new Rectangle(x,y);
        private Timeline animation;

        public RectanglePane() {
            rectangle.setFill(Color.RED);
            getChildren().add(rectangle);

            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> moveRectangle()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        public DoubleProperty rateProperty(){
            return animation.rateProperty();

        }

        protected void moveRectangle(){
            if (x < width || x > getWidth()-width){
                dx *= -1;
            }

            if (y < height || y > getHeight()-height){
                dy *= -1;
            }

            x += dx;
            y += dy;

            rectangle.setX(x);
            rectangle.setY(y);

        }
    }}