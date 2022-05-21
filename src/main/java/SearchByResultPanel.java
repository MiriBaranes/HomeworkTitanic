import javax.swing.*;
import java.awt.*;

public class SearchByResultPanel extends BasicPanel{

    private JButton backButton;
    private String total;
    private String survived;

    public SearchByResultPanel(int x, int y, int width, int height){
        super(x, y, width, height);
        this.backButton = new JButton("BACK");
        this.backButton.setBounds(50, height - Constants.BUTTON_H - Constants.MARGIN_FROM_TOP/2,
                Constants.BUTTON_W, Constants.BUTTON_H);
        this.add(this.backButton);
    }
}
