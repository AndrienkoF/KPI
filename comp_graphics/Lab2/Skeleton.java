import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Skeleton extends JPanel implements ActionListener {
    double points[][] = {
            { -100, -15 }, { -25, -25 }, { 0, -90 }, { 25, -25 },
            { 100, -15 }, { 50, 25 }, { 60, 100 }, { 0, 50 },
            { -60, 100 }, { -50, 25 }, { -100, -15 }
    };
    Timer timer;
    // Для анімації повороту
    private double angle = 0;
    private double angle2 = 0;

    private static int maxWidth;
    private static int maxHeight;

    public Skeleton() {
        // Таймер генеруватиме подію що 10 мс
        timer = new Timer(10, this);
        timer.start();
    }


    public void firstTask(Graphics2D g2d){
        g2d.setColor(Color.MAGENTA);
        g2d.fillRect(0, 0, 400, 250);

        g2d.setColor(Color.RED);
        g2d.fillRect(100, 170, 200, 50);

        g2d.setColor(Color.BLUE);
        g2d.fillOval(100,30,60,190);

        g2d.setColor(Color.GREEN);
        g2d.fillRect(100, 30, 200, 50);

        g2d.setColor(Color.YELLOW);
        g2d.fillOval(240,30,60,190);

        g2d.setColor(Color.RED);
        g2d.fillRect(200, 170, 100, 50);

        g2d.setColor(Color.BLACK);
        g2d.drawString("Task #1", 10, 30);

    }

    public void frame(Graphics2D g2d){
        g2d.setColor(Color.CYAN);
        BasicStroke bs1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawRect(maxWidth/2 - 100, maxHeight/2 - 100, 410, 410);
    }

    public void secondTask(Graphics2D g2d){
        g2d.setColor(Color.WHITE);
        g2d.drawString("Task #2", maxWidth/2 - 80, maxHeight/2 - 70);

        GradientPaint gp = new GradientPaint(30, 30,
                Color.MAGENTA, 100, 100, Color.CYAN, true);
        g2d.setPaint(gp);

        g2d.translate(maxWidth/2 + 50, maxHeight/2 + 50);
        GeneralPath star = new GeneralPath();
        star.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            star.lineTo(points[k][0], points[k][1]);
        star.closePath();

        g2d.rotate(angle, 60, 60);
        g2d.rotate(angle2);
        g2d.fill(star);
    }


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);


        g2d.setBackground(Color.black);
        g2d.clearRect(0, 0, maxWidth, maxHeight);
        firstTask(g2d);
        frame(g2d);
        secondTask(g2d);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Skeleton());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;

    }

    public void actionPerformed(ActionEvent e) {
        angle -= 0.01;
        angle2 += 0.05;

        repaint();
    }
}

