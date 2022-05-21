import javax.swing.*;
import java.io.FileNotFoundException;

class Main extends JFrame {

    public static void main(String[] args) throws FileNotFoundException {
        new Main();
    }

    public Main() throws FileNotFoundException {
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.add(new FirstPanel(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT));
        this.setVisible(true);

    }
}