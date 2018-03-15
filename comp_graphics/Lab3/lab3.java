import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.*;

import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.RadialGradient;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.ParallelTransition;
import javafx.util.Duration;





public class lab3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 600);

        // BACKGROUND --------------------------------------------------
        RadialGradient gradientSky = new RadialGradient(0,
                .1,
                170,
                150,
                160,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("3DB0EA")),
                new Stop(1, Color.WHITE));



        Arc backgroundPart1 = new Arc();
        backgroundPart1.setCenterX(170.0f);
        backgroundPart1.setCenterY(150.0f);
        backgroundPart1.setRadiusX(120.0f);
        backgroundPart1.setRadiusY(120.0f);
        backgroundPart1.setStartAngle(0.0f);
        backgroundPart1.setLength(180.0f);
        backgroundPart1.setType(ArcType.ROUND);
        backgroundPart1.setFill(gradientSky);

        RadialGradient gradientGround = new RadialGradient(0,
                .1,
                170,
                150,
                400,
                false,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("FFFE18")),
                new Stop(1, Color.WHITE));

        Arc backgroundPart2 = new Arc();
        backgroundPart2.setCenterX(170.0f);
        backgroundPart2.setCenterY(150.0f);
        backgroundPart2.setRadiusX(120.0f);
        backgroundPart2.setRadiusY(120.0f);
        backgroundPart2.setStartAngle(180.0f);
        backgroundPart2.setLength(180.0f);
        backgroundPart2.setType(ArcType.ROUND);
        backgroundPart2.setFill(gradientGround);
        //---------------------------------------------------------------------------------------------

        // APPLE --------------------------------------------------------------------------------------
        Stop[] stops = new Stop[] { new Stop(0, Color.web("FF2A00")), new Stop(1, Color.web("FF2A00"))};
        LinearGradient lg1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);

        Stop[] stops1 = new Stop[] { new Stop(0, Color.web("FF2A00")), new Stop(1, Color.web("9CE314"))};
        LinearGradient lg12 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops1);

        Ellipse applePart1 = new Ellipse(150,160,52,60);
        Ellipse applePart2 = new Ellipse(180,161,52,60);
        applePart1.setFill(lg1);
        applePart2.setFill(lg12);

        Ellipse applePart1Border = new Ellipse(150,160,53,61);
        Ellipse applePart2Border = new Ellipse(180,161,53,61);
        applePart1Border.setFill(Color.BLACK);
        applePart2Border.setFill(Color.BLACK);
        //---------------------------------------------------------------------------------

        // POLYGON ------------------------------------------------------------------------
        Polygon polygon = new Polygon(155, 82, 150, 65, 160, 65, 163, 82);
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(1);
        polygon.setFill(Color.web("3A1B0D"));

        Ellipse elToPol = new Ellipse(156,68,3,1);
        elToPol.setFill(Color.web("967E3A"));
        //---------------------------------------------------------------------------------

        // LEAF ---------------------------------------------------------------------------
        Circle leafPart1 = new Circle(160,105,25);
        leafPart1.setFill(Color.web("50C21B"));

        CubicCurve leafPart2 = new CubicCurve();
        leafPart2.setStartX(158);
        leafPart2.setStartY(81);
        leafPart2.setControlX1(200);
        leafPart2.setControlY1(60);
        leafPart2.setControlX2(218);
        leafPart2.setControlY2(123);
        leafPart2.setEndX(200);
        leafPart2.setEndY(150);
        leafPart2.setStroke(Color.web("50C21B"));
        leafPart2.setStrokeWidth(1);
        leafPart2.setStrokeLineCap(StrokeLineCap.ROUND);
        leafPart2.setFill(Color.web("50C21B").deriveColor(0, 1.2, 1, 1));

        CubicCurve leafPart3 = new CubicCurve();
        leafPart3.setStartX(200);
        leafPart3.setStartY(150);
        leafPart3.setControlX1(191);
        leafPart3.setControlY1(145);
        leafPart3.setControlX2(90);
        leafPart3.setControlY2(119);
        leafPart3.setEndX(160);
        leafPart3.setEndY(81);
        leafPart3.setStroke(Color.web("50C21B"));
        leafPart3.setStrokeWidth(1);
        leafPart3.setStrokeLineCap(StrokeLineCap.ROUND);
        leafPart3.setFill(Color.web("50C21B").deriveColor(0, 1.2, 1, 1));

        Circle leafPart1Border = new Circle(160,105,26);
        leafPart1Border.setFill(Color.BLACK);

        CubicCurve leafPart2Border = new CubicCurve();
        leafPart2Border.setStartX(159);
        leafPart2Border.setStartY(80);
        leafPart2Border.setControlX1(201);
        leafPart2Border.setControlY1(59);
        leafPart2Border.setControlX2(219);
        leafPart2Border.setControlY2(122);
        leafPart2Border.setEndX(201);
        leafPart2Border.setEndY(149);
        leafPart2Border.setStroke(Color.BLACK);
        leafPart2Border.setStrokeWidth(1);
        leafPart2Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leafPart2Border.setFill(Color.BLACK.deriveColor(0, 1.2, 1, 1));

        CubicCurve leafPart3Border = new CubicCurve();
        leafPart3Border.setStartX(199);
        leafPart3Border.setStartY(151);
        leafPart3Border.setControlX1(190);
        leafPart3Border.setControlY1(146);
        leafPart3Border.setControlX2(89);
        leafPart3Border.setControlY2(120);
        leafPart3Border.setEndX(159);
        leafPart3Border.setEndY(82);
        leafPart3Border.setStroke(Color.BLACK);
        leafPart3Border.setStrokeWidth(1);
        leafPart3Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leafPart3Border.setFill(Color.BLACK.deriveColor(0, 1.2, 1, 1));

        CubicCurve leafPart4Border = new CubicCurve();
        leafPart4Border.setStartX(163);
        leafPart4Border.setStartY(79);
        leafPart4Border.setControlX1(190);
        leafPart4Border.setControlY1(91);
        leafPart4Border.setControlX2(200);
        leafPart4Border.setControlY2(140);
        leafPart4Border.setEndX(200);
        leafPart4Border.setEndY(150);
        leafPart4Border.setStroke(Color.BLACK);
        leafPart4Border.setStrokeWidth(1);
        leafPart4Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leafPart4Border.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        CubicCurve leaf2Part1 = new CubicCurve();
        leaf2Part1.setStartX(159);
        leaf2Part1.setStartY(124);
        leaf2Part1.setControlX1(216);
        leaf2Part1.setControlY1(151);
        leaf2Part1.setControlX2(242);
        leaf2Part1.setControlY2(110);
        leaf2Part1.setEndX(240);
        leaf2Part1.setEndY(72);
        leaf2Part1.setStroke(Color.web("50C21B"));
        leaf2Part1.setStrokeWidth(1);
        leaf2Part1.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part1.setFill(Color.web("50C21B").deriveColor(0, 1.2, 1, 1));

        CubicCurve leaf2Part2 = new CubicCurve();
        leaf2Part2.setStartX(159);
        leaf2Part2.setStartY(134);
        leaf2Part2.setControlX1(123);
        leaf2Part2.setControlY1(83);
        leaf2Part2.setControlX2(130);
        leaf2Part2.setControlY2(95);
        leaf2Part2.setEndX(240);
        leaf2Part2.setEndY(72);
        leaf2Part2.setStroke(Color.web("50C21B"));
        leaf2Part2.setStrokeWidth(1);
        leaf2Part2.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part2.setFill(Color.web("50C21B").deriveColor(0, 1.2, 1, 1));

        CubicCurve leaf2Part1Border = new CubicCurve();
        leaf2Part1Border.setStartX(160);
        leaf2Part1Border.setStartY(125);
        leaf2Part1Border.setControlX1(217);
        leaf2Part1Border.setControlY1(152);
        leaf2Part1Border.setControlX2(243);
        leaf2Part1Border.setControlY2(111);
        leaf2Part1Border.setEndX(241);
        leaf2Part1Border.setEndY(73);
        leaf2Part1Border.setStroke(Color.BLACK);
        leaf2Part1Border.setStrokeWidth(1);
        leaf2Part1Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part1Border.setFill(Color.BLACK.deriveColor(0, 1.2, 1, 1));

        CubicCurve leaf2Part2Border = new CubicCurve();
        leaf2Part2Border.setStartX(158);
        leaf2Part2Border.setStartY(133);
        leaf2Part2Border.setControlX1(122);
        leaf2Part2Border.setControlY1(82);
        leaf2Part2Border.setControlX2(129);
        leaf2Part2Border.setControlY2(94);
        leaf2Part2Border.setEndX(239);
        leaf2Part2Border.setEndY(71);
        leaf2Part2Border.setStroke(Color.BLACK);
        leaf2Part2Border.setStrokeWidth(1);
        leaf2Part2Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part2Border.setFill(Color.BLACK.deriveColor(0, 1.2, 1, 1));

        CubicCurve leaf2Part3Border = new CubicCurve();
        leaf2Part3Border.setStartX(160);
        leaf2Part3Border.setStartY(95);
        leaf2Part3Border.setControlX1(170);
        leaf2Part3Border.setControlY1(152);
        leaf2Part3Border.setControlX2(220);
        leaf2Part3Border.setControlY2(111);
        leaf2Part3Border.setEndX(241);
        leaf2Part3Border.setEndY(73);
        leaf2Part3Border.setStroke(Color.BLACK);
        leaf2Part3Border.setStrokeWidth(1);
        leaf2Part3Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part3Border.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        CubicCurve leaf2Part4Border = new CubicCurve();
        leaf2Part4Border.setStartX(215);
        leaf2Part4Border.setStartY(106);
        leaf2Part4Border.setControlX1(220);
        leaf2Part4Border.setControlY1(100);
        leaf2Part4Border.setControlX2(220);
        leaf2Part4Border.setControlY2(100);
        leaf2Part4Border.setEndX(215);
        leaf2Part4Border.setEndY(84);
        leaf2Part4Border.setStroke(Color.BLACK);
        leaf2Part4Border.setStrokeWidth(1);
        leaf2Part4Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part4Border.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));


        CubicCurve leaf2Part5Border = new CubicCurve();
        leaf2Part5Border.setStartX(225);
        leaf2Part5Border.setStartY(96);
        leaf2Part5Border.setControlX1(228);
        leaf2Part5Border.setControlY1(94);
        leaf2Part5Border.setControlX2(228);
        leaf2Part5Border.setControlY2(94);
        leaf2Part5Border.setEndX(225);
        leaf2Part5Border.setEndY(84);
        leaf2Part5Border.setStroke(Color.BLACK);
        leaf2Part5Border.setStrokeWidth(1);
        leaf2Part5Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part5Border.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        CubicCurve leaf2Part6Border = new CubicCurve();
        leaf2Part6Border.setStartX(193);
        leaf2Part6Border.setStartY(115);
        leaf2Part6Border.setControlX1(213);
        leaf2Part6Border.setControlY1(112);
        leaf2Part6Border.setControlX2(213);
        leaf2Part6Border.setControlY2(112);
        leaf2Part6Border.setEndX(205);
        leaf2Part6Border.setEndY(87);
        leaf2Part6Border.setStroke(Color.BLACK);
        leaf2Part6Border.setStrokeWidth(1);
        leaf2Part6Border.setStrokeLineCap(StrokeLineCap.ROUND);
        leaf2Part6Border.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));
        //----------------------------------------------------------------------------------

        // EYES ----------------------------------------------------------------------------
        Ellipse eyePart1 = new Ellipse(152,170,6,10);
        eyePart1.setFill(Color.WHITE);

        Ellipse eye2Part1 = new Ellipse(178,170,6,10);
        eye2Part1.setFill(Color.WHITE);

        Ellipse eyePart1Border = new Ellipse(152,170,7,11);
        eyePart1Border.setFill(Color.BLACK);

        Ellipse eye2Part1Border = new Ellipse(178,170,7,11);
        eye2Part1Border.setFill(Color.BLACK);

        Ellipse eyePart2 = new Ellipse(153,173,3,5);
        eyePart2.setFill(Color.BLACK);

        Ellipse eye2Part2 = new Ellipse(179,173,3,5);
        eye2Part2.setFill(Color.BLACK);

        Ellipse eyePart3 = new Ellipse(153,173,0.5,1);
        eyePart3.setFill(Color.WHITE);

        Ellipse eye2Part3 = new Ellipse(179,173,0.5,1);
        eye2Part3.setFill(Color.WHITE);
        //----------------------------------------------------------------------------------

        // BROWS ---------------------------------------------------------------------------
        CubicCurve brow1 = new CubicCurve();
        brow1.setStartX(148);
        brow1.setStartY(150);
        brow1.setControlX1(150);
        brow1.setControlY1(145);
        brow1.setControlX2(150);
        brow1.setControlY2(145);
        brow1.setEndX(155);
        brow1.setEndY(150);
        brow1.setStroke(Color.BLACK);
        brow1.setStrokeWidth(1);
        brow1.setStrokeLineCap(StrokeLineCap.ROUND);
        brow1.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        CubicCurve brow2 = new CubicCurve();
        brow2.setStartX(173);
        brow2.setStartY(150);
        brow2.setControlX1(175);
        brow2.setControlY1(145);
        brow2.setControlX2(175);
        brow2.setControlY2(145);
        brow2.setEndX(180);
        brow2.setEndY(150);
        brow2.setStroke(Color.BLACK);
        brow2.setStrokeWidth(1);
        brow2.setStrokeLineCap(StrokeLineCap.ROUND);
        brow2.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));
        //----------------------------------------------------------------------------------

        // MOUTH ---------------------------------------------------------------------------
        CubicCurve mouthPart1 = new CubicCurve();
        mouthPart1.setStartX(152);
        mouthPart1.setStartY(190);
        mouthPart1.setControlX1(160);
        mouthPart1.setControlY1(200);
        mouthPart1.setControlX2(160);
        mouthPart1.setControlY2(200);
        mouthPart1.setEndX(180);
        mouthPart1.setEndY(195);
        mouthPart1.setStroke(Color.BLACK);
        mouthPart1.setStrokeWidth(1);
        mouthPart1.setStrokeLineCap(StrokeLineCap.ROUND);
        mouthPart1.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        Line mouthPart2 = new Line(150.0f, 192.0f, 154.0f, 188.0f);
        mouthPart2.setFill(Color.BLACK);
        //----------------------------------------------------------------------------------

        // NOSE ----------------------------------------------------------------------------
        CubicCurve nose = new CubicCurve();
        nose.setStartX(165);
        nose.setStartY(180);
        nose.setControlX1(173);
        nose.setControlY1(182);
        nose.setControlX2(173);
        nose.setControlY2(186);
        nose.setEndX(165);
        nose.setEndY(190);
        nose.setStroke(Color.BLACK);
        nose.setStrokeWidth(1);
        nose.setStrokeLineCap(StrokeLineCap.ROUND);
        nose.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));
        //----------------------------------------------------------------------------------

        // ARMS ----------------------------------------------------------------------------
        CubicCurve arm1Part1 = new CubicCurve();
        arm1Part1.setStartX(98);
        arm1Part1.setStartY(149);
        arm1Part1.setControlX1(120);
        arm1Part1.setControlY1(160);
        arm1Part1.setControlX2(70);
        arm1Part1.setControlY2(180);
        arm1Part1.setEndX(110);
        arm1Part1.setEndY(200);
        arm1Part1.setStroke(Color.BLACK);
        arm1Part1.setStrokeWidth(1);
        arm1Part1.setStrokeLineCap(StrokeLineCap.ROUND);
        arm1Part1.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        Ellipse arm1Part2Border = new Ellipse(118,200,11,7);
        arm1Part2Border.setFill(Color.BLACK);

        Ellipse arm1Part2 = new Ellipse(118,200,10,6);
        arm1Part2.setFill(Color.web("6AC414"));

        CubicCurve arm1Part3 = new CubicCurve();
        arm1Part3.setStartX(110);
        arm1Part3.setStartY(205);
        arm1Part3.setControlX1(130);
        arm1Part3.setControlY1(217);
        arm1Part3.setControlX2(130);
        arm1Part3.setControlY2(210);
        arm1Part3.setEndX(120);
        arm1Part3.setEndY(205);
        arm1Part3.setStroke(Color.BLACK);
        arm1Part3.setStrokeWidth(1);
        arm1Part3.setStrokeLineCap(StrokeLineCap.ROUND);
        arm1Part3.setFill(Color.web("6AC414").deriveColor(0, 1.2, 1, 1));

        CubicCurve arm2Part1 = new CubicCurve();
        arm2Part1.setStartX(231);
        arm2Part1.setStartY(149);
        arm2Part1.setControlX1(250);
        arm2Part1.setControlY1(160);
        arm2Part1.setControlX2(200);
        arm2Part1.setControlY2(180);
        arm2Part1.setEndX(240);
        arm2Part1.setEndY(200);
        arm2Part1.setStroke(Color.BLACK);
        arm2Part1.setStrokeWidth(1);
        arm2Part1.setStrokeLineCap(StrokeLineCap.ROUND);
        arm2Part1.setFill(Color.BLACK.deriveColor(0, 0, 0, 0));

        Ellipse arm2Part2Border = new Ellipse(248,200,11,7);
        arm2Part2Border.setFill(Color.BLACK);

        Ellipse arm2Part2 = new Ellipse(248,200,10,6);
        arm2Part2.setFill(Color.web("6AC414"));

        CubicCurve arm2Part3 = new CubicCurve();
        arm2Part3.setStartX(240);
        arm2Part3.setStartY(205);
        arm2Part3.setControlX1(260);
        arm2Part3.setControlY1(217);
        arm2Part3.setControlX2(260);
        arm2Part3.setControlY2(210);
        arm2Part3.setEndX(250);
        arm2Part3.setEndY(205);
        arm2Part3.setStroke(Color.BLACK);
        arm2Part3.setStrokeWidth(1);
        arm2Part3.setStrokeLineCap(StrokeLineCap.ROUND);
        arm2Part3.setFill(Color.web("6AC414").deriveColor(0, 1.2, 1, 1));
        //----------------------------------------------------------------------------------


        root.getChildren().addAll(
                backgroundPart1,
                backgroundPart2,
                polygon,
                elToPol,
                leaf2Part1Border,
                leaf2Part2Border,
                leaf2Part1,
                leaf2Part2,
                leaf2Part4Border,
                leaf2Part5Border,
                leaf2Part6Border,
                leaf2Part3Border,
                applePart1Border,
                applePart2Border,
                applePart1,
                applePart2,
                leafPart1Border,
                leafPart2Border,
                leafPart3Border,
                leafPart1,
                leafPart2,
                leafPart3,
                leafPart4Border,
                eyePart1Border,
                eye2Part1Border,
                eyePart1,
                eye2Part1,
                eyePart2,
                eye2Part2,
                eyePart3,
                eye2Part3,
                brow1,
                brow2,
                mouthPart1,
                mouthPart2,
                nose,
                arm1Part1,
                arm1Part2Border,
                arm1Part2,
                arm1Part3,
                arm2Part1,
                arm2Part2Border,
                arm2Part2,
                arm2Part3);

        // Створення ефекту переміщення
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(3000), root);
        translateTransition.setFromX(50);
        translateTransition.setToX(500);
        translateTransition.setToY(200);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        // Створення повороту об'єкту
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(1);
        rotateTransition.setAutoReverse(true);
        // Масштабування об'єкту
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1700), root);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                rotateTransition,
                translateTransition,
                scaleTransition
        );
        parallelTransition.play();

        scene.setFill(Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

