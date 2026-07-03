package Lib;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollingBall extends JPanel implements ActionListener {  

    private int ballX = 100;
    private int ballY = 100;
    private int ballSize = 80;
    private int speed = 3;
    private double angle = 0;

    private Timer timer;   

    public RollingBall() {
        this.setBackground(new Color(236, 236, 236));
        timer = new Timer(15, this);
        timer.start();   
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawBall(g2, ballX, ballY, ballSize, angle);  
    }

    private void drawBall(Graphics2D g2, int x, int y, int size, double angle) {

        g2.setColor(Color.WHITE);
        g2.fillOval(x, y, size, size);

        g2.setColor(Color.BLACK);
        g2.fillArc(x, y, size, size, (int) angle, 180);

        g2.setColor(Color.BLACK);
        g2.drawOval(x, y, size, size);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ballX -= speed;

        if (ballX + ballSize < 0) {
            ballX = getWidth();
        }

        double radius = ballSize / 2.0;
        double deltaAngle = Math.toDegrees(speed / radius);
        angle += deltaAngle;
        if (angle < 0) angle += 360;
        if (angle >= 360) angle -= 360;

        repaint();
    }
}