import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class FirstPanel extends BasicPanel {

    ArrayList<Passenger> allPassengers;

    JLabel title;
    private ArrayList<JComboBox<String>> comboBoxes = new ArrayList<>();
    private ArrayList<JTextField> fromUser = new ArrayList<>();
    private ArrayList<JTextField>fromToFromUser = new ArrayList<>();
    private String[][] options = {Constants.PASSENGER_CLASS_OPTIONS, Constants.PASSENGER_SEX_OPTIONS,
            Constants.PASSENGER_EMBARKED_PLACE};
    private String[]categories = {"Passenger's class: ", "Passenger's sex: ",
            "Passenger's embarkation: ", "Passenger's name: ", "Passenger's siblings' number: ",
            "Passenger's parch number: ", "Passenger's ticket number: ", "Passenger's cabin number: ",
            "Passenger's id number: ", "Passenger's ticket price: "};
    private JButton searchButton;
    private JButton statisticsButton;
    ArrayList<String> arrayListOfLines;





    public FirstPanel(int x, int y, int width, int height) {
        super(x, y, width, height);
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        this.arrayListOfLines = readFromFile();
        this.allPassengers = allPassengers();
        System.out.println(allPassengers.get(3).toString());
        this.title = new JLabel("Survived passenger's search: ");
        this.title.setBounds((width - Constants.TITLE_W)/2, y, Constants.TITLE_W, Constants.TITLE_H);
        this.title.setFont(Constants.font);
        this.add(title);
        int fieldY = y;

        for (int i=0; i<Constants.COMBO_BOXES_ROWS; i++){
            comboBoxes.add(new JComboBox<>(this.options[i]));
            comboBoxCreation(comboBoxes.get(i), x, fieldY);
            JLabelCreation(this.categories[i], x, fieldY, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            fieldY+=Constants.LABEL_HEIGHT;
        }
        for (int i = Constants.COMBO_BOXES_ROWS; i < Constants.COMBO_BOXES_ROWS+Constants.FIELDS_ROWS; i++){
            fromUser.add(new JTextField());
            normalTextFieldCreation(fromUser.get(i-3), fieldY);
            JLabelCreation(this.categories[i], x, fieldY, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            fieldY+=Constants.LABEL_HEIGHT;
        }

        int smallFieldX = Constants.FROM_FIELD_X;
        for (int i = Constants.COMBO_BOXES_ROWS+Constants.FIELDS_ROWS;
             i < Constants.COMBO_BOXES_ROWS+Constants.FIELDS_ROWS + Constants.SMALL_FIELDS_ROWS; i++){
            fromToFromUser.add(new JTextField());
            smallTextFieldCreation(fromToFromUser.get(i-8), smallFieldX, fieldY);
            JLabelCreation(this.categories[i], x, fieldY, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
            JLabelCreation("From: ", x + Constants.LABEL_WIDTH, fieldY, Constants.SMALL_LABEL_W, Constants.LABEL_HEIGHT);
            JLabelCreation("To: ", x + Constants.LABEL_WIDTH + Constants.SMALL_LABEL_W + Constants.SMALL_FIELD, fieldY, Constants.SMALL_LABEL_W, Constants.LABEL_HEIGHT);
            fieldY +=Constants.LABEL_HEIGHT;
        }
        fieldY -= 2*Constants.LABEL_HEIGHT;
        for (int i = Constants.COMBO_BOXES_ROWS+Constants.FIELDS_ROWS;
             i < Constants.COMBO_BOXES_ROWS+Constants.FIELDS_ROWS + Constants.SMALL_FIELDS_ROWS; i++){
            fromToFromUser.add(new JTextField());
            smallTextFieldCreation(fromToFromUser.get(i-6), smallFieldX+Constants.FIELD_X_DIF, fieldY);
            fieldY+=Constants.LABEL_HEIGHT;
        }
        this.searchButton = new JButton("SEARCH");
        this.searchButton.setBounds((width - 2*Constants.BUTTON_W) / 2, height - Constants.BUTTON_H - Constants.MARGIN_FROM_TOP / 2,
                Constants.BUTTON_W, Constants.BUTTON_H);
        this.searchButton.addActionListener(e->{

        });
        this.add(searchButton);
        this.statisticsButton = new JButton("CREATE STATISTICS FILE");
        this.statisticsButton.setBounds((width - 2*Constants.BUTTON_W) / 2 + Constants.BUTTON_W,
                height - Constants.BUTTON_H - Constants.MARGIN_FROM_TOP / 2, Constants.BUTTON_W,
                Constants.BUTTON_H);
        this.statisticsButton.addActionListener(e->{

        });
        this.add(statisticsButton);
    }


    public void JLabelCreation(String s,int x, int y, int w, int h){
        JLabel txt = new JLabel(s);
        txt.setBounds(x + Constants.MARGIN_FROM_LEFT, y + Constants.MARGIN_FROM_TOP, w, h);
        this.add(txt);
    }

    public void comboBoxCreation(JComboBox<String> c, int x, int y){
        c.setBounds(x + Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH, y + Constants.MARGIN_FROM_TOP,
               Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(c);
    }

    public void normalTextFieldCreation(JTextField field, int y){
        field.setBounds(Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH, y + Constants.MARGIN_FROM_TOP,
                Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(field);
        field.addActionListener((e) -> {
            JLabel text = new JLabel("Searching for " + field.getText());
            text.setFont(Constants.font);
            text.setBounds(Constants.MARGIN_FROM_LEFT + Constants.LABEL_WIDTH + Constants.COMBO_BOX_WIDTH,
                    y + Constants.MARGIN_FROM_TOP, Constants.SMALL_FIELD, Constants.COMBO_BOX_HEIGHT);
            text.setVisible(true);
            field.setText(null);//check why the program doesn't write text
        });
    }

    public void smallTextFieldCreation(JTextField field, int x, int y){
        field.setBounds(x, y + Constants.MARGIN_FROM_TOP, Constants.SMALL_FIELD,
                Constants.COMBO_BOX_HEIGHT);
        this.add(field);
        field.addActionListener((e) -> {

        });
    }

    public void buttonCreation(String s, int x, int y, int width, int height){
        JButton button = new JButton(s);
        button.setBounds(x, y, width, height);
        this.add(button);//check why secondPanel is invisible
    }

    public ArrayList<String> readFromFile(){
        ArrayList<String> linesOfFile = new ArrayList<>();
        String text;
        try {
            if(new File(Constants.PATH_TO_DATA_FILE).exists()) {
                Scanner scanner = new Scanner(new File(Constants.PATH_TO_DATA_FILE));
                while(scanner.hasNextLine()) {
                    text = scanner.nextLine()+ "\n";
                    linesOfFile.add(text);

                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return linesOfFile;//why I see link and not text
    }

    public ArrayList<Passenger> allPassengers(){
        String [] splitLine;
        ArrayList<Passenger> allPassengers = new ArrayList<>();
        for (int i = 1; i < this.arrayListOfLines.size(); i++){
            splitLine = this.arrayListOfLines.get(i).split(",");
            Stack<String>line = new Stack<>();
            for (int j = 0; j < splitLine.length; j++){
                line.push(splitLine[j]);
            }
            allPassengers.add(new Passenger(line));
        }
        return allPassengers;
    }

}
