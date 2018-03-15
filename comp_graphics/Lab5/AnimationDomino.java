import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.vecmath.*;

public class AnimationDomino implements ActionListener {
    private Button go;
    private TransformGroup domino1;
    private TransformGroup domino2;
    private Transform3D translateTransform1;
    private Transform3D translateTransform2;

    private Transform3D rotateTransformZ1;
    private Transform3D rotateTransformZ2;
    private JFrame mainFrame;
    private Timer timer;

    private int rotationForDomino1;
    private int rotationForDomino2;


    public AnimationDomino(TransformGroup domino1, TransformGroup domino2, Transform3D trans1,Transform3D trans2, JFrame frame){
        go = new Button("Go");

        this.domino1=domino1;
        this.domino2=domino2;
        this.translateTransform1=trans1;
        this.translateTransform2=trans2;
        this.mainFrame=frame;

        rotateTransformZ1= new Transform3D();
        rotateTransformZ2= new Transform3D();

        timer = new Timer(100, this);

        Panel p =new Panel();
        p.add(go);
        mainFrame.add("North",p);
        go.addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        // start timer when button is pressed
        if (e.getSource()==go){
            if (!timer.isRunning()) {
                timer.start();
                go.setLabel("Stop");
            }
            else {
                timer.stop();
                go.setLabel("Go");
            }

            rotationForDomino1 = 0;
            rotationForDomino2 = 0;

            translateTransform1 = new Transform3D();
            translateTransform2 = new Transform3D();

            translateTransform1.rotZ(300);
            translateTransform2.rotZ(300);

            translateTransform1.setTranslation(new Vector3f(.5f, -0.3f, -0.2f));
            translateTransform2.setTranslation(new Vector3f(0.2f, -0.3f, -0.4f));

            domino1.setTransform(translateTransform1);
            domino2.setTransform(translateTransform2);

        }
        else {
            if(rotationForDomino1 <= 14 && rotationForDomino1%2 == 0){
                rotateTransformZ1.rotZ(Math.PI/20);
                translateTransform1.mul(rotateTransformZ1);
                domino1.setTransform(translateTransform1);
            }
            if(rotationForDomino1 >=4 && rotationForDomino2 <=13){
                rotateTransformZ2.rotZ(Math.PI/20);
                translateTransform2.mul(rotateTransformZ2);
                domino2.setTransform(translateTransform2);

            }

            rotationForDomino1++;
            rotationForDomino2++;
        }
    }

}

