// COP 3503
//Francis Rukab N00961805
// 11/10/17
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class n00961805 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a clock and a label
        ClockPane clock = new ClockPane((int)(Math.random() * 12),
                ((int)(Math.random() * 2) == 1 ? 30 : 0), 0);
        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        clock.setSecondHandVisible(false); // Make second hand invisible
        Label time = new Label(timeString);
        Label name = new Label("FRANCIS RUKAB");
        name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));

        clock.setPadding(new Insets(10, 10, 10, 10));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(clock, name);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(stackPane, time);
        vBox.setAlignment(Pos.CENTER);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Create a pane
        Pane hangman = new Pane();

        // Create three polylines and set their properties
        Polyline polyline1 = new Polyline();
        hangman.getChildren().add(polyline1);
        polyline1.setStroke(Color.BLACK);
        ObservableList<Double> list = polyline1.getPoints();
        double x1 = 40.0;
        double y1 = 190.0;
        double y2 = 20.0;
        double x3 = 125.0;
        list.addAll(x1, y1, x1, y2, x3, y2, x3, y1 * .60);

        Polyline polyline2 = new Polyline();
        hangman.getChildren().add(polyline2);
        polyline2.setStroke(Color.BLACK);
        ObservableList<Double> list2 = polyline2.getPoints();
        list2.addAll((x1 + x3) * .5, y1 * .5, x3, y1 * .25,
                x3 + (x3 - x1) * .5, y1 * .5);

        Polyline polyline3 = new Polyline();
        hangman.getChildren().add(polyline3);
        polyline3.setStroke(Color.BLACK);
        ObservableList<Double> list3 = polyline3.getPoints();
        list3.addAll((x1 + x3) * .6, y1 * .80, x3, y1 * .60,
                x3 + (x3 - x1) * .3, y1 * .80);

        // Create a circle and set its properties
        Circle circle = new Circle(x3, y1 * .25, 15);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        hangman.getChildren().add(circle);

        // Create an arc and set its properties
        Arc arc = new Arc(x1, y1 + 1, 25, 15, 0, 180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        hangman.getChildren().add(arc);

        hangman.setPadding(new Insets(10, 10, 10, 10));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // Create a GridPane and set its properties
        GridPane fans = new GridPane();
        fans.setPadding(new Insets(10, 10, 10, 10));
        fans.setHgap(10);
        fans.setVgap(10);

        // Place nodes in the pane
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Create a stack pane
                StackPane stackPaneFan = new StackPane();

                // Add circle to stack pane
                Circle circle1 = getCircle();
                stackPaneFan.getChildren().add(circle1);

                // Add Arcs to stack pane
                getArcs(stackPaneFan);

                fans.add(stackPaneFan, i, j);
            }
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // Place items in border pane
        BorderPane pane = new BorderPane();

        FlowPane leftFlowpane = new FlowPane();
        leftFlowpane.getChildren().addAll(vBox);
        leftFlowpane.setAlignment(Pos.CENTER);


        FlowPane centerFlowpane = new FlowPane();
        centerFlowpane.getChildren().add(hangman);
        centerFlowpane.setAlignment(Pos.CENTER);

        FlowPane rightFlowpane = new FlowPane();
        rightFlowpane.getChildren().add(fans);
        rightFlowpane.setAlignment(Pos.CENTER);


        pane.setLeft(leftFlowpane);
        pane.setCenter(centerFlowpane);
        pane.setRight(rightFlowpane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 1200, 450);
        primaryStage.setTitle("Assignment a6 - N00961805"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage


    }

    /** Add four arcs to a pane and place them in a stack pane */
    private void getArcs(StackPane stackPane) {
        double angle = 30; // Start angle
        for (int i = 0; i < 4; i++) {
            Pane pane = new Pane();
            Arc arc1 = new Arc(100, 100, 80, 80, angle + 90, 35);
            arc1.setFill(Color.BLACK);
            arc1.setType(ArcType.ROUND);
            pane.getChildren().add(arc1);
            stackPane.getChildren().add(pane);
            angle += 90;
        }
    }

    /** Return a Circle */
    private Circle getCircle() {
        Circle c = new Circle();
        c.setRadius(100);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        return c;
    }

}

class ClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible;
    private boolean minuteHandVisible;
    private boolean secondHandVisible;

    // Clock pane's width and height
    private double w = 250, h = 250;

    /** Construct a default clock with the current time */
    public ClockPane() {
        setCurrentTime();
    }

    /** Construct a click with specified hour, minute, and second */
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        hourHandVisible = minuteHandVisible =
                secondHandVisible = true;
        paintClock();
    }

    /** Return hour */
    public int getHour() {
        return hour;
    }

    /** Set a new hour */
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    /** Return minute */
    public int getMinute() {
        return minute;
    }

    /** Set a new minute */
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    /** Return second */
    public int getSecond() {
        return second;
    }

    /** Set a new second */
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    /** Return clock pane's width */
    public double getW() {
        return w;
    }

    /** Set clock pane's width */
    public void getW(double w) {
        this.w = w;
        paintClock();
    }

    /** Return clock pane's height */
    public double getH() {
        return h;
    }

    /** Set clock pane's heigt */
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    /** Return hourHandVisible */
    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    /** set hourHandVisible */
    public void setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        paintClock(); // Repaint the clock
    }

    /** Return minuteHandVisible */
    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    /** set minuteHandVisible */
    public void setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        paintClock(); // Repaint the clock
    }

    /** Return secondHandVisible */
    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    /** set secondHandVisible */
    public void setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
        paintClock(); // Repaint the clock
    }

    /* Set the current time for the clock */
    public void setCurrentTime() {
        // Construct a Calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Set current hour, minute and second
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock(); // Repaint the clock
    }

    /** Paint the clock */
    protected void paintClock() {
        // Initialize clock parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        // Draw circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        // Draw hour hand
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4);
        if (secondHandVisible)
            getChildren().add(sLine);
        if (minuteHandVisible)
            getChildren().add(mLine);
        if (hourHandVisible)
            getChildren().add(hLine);

    }
}