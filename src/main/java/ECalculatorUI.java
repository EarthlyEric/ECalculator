import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * ECalculator
 * @author EarthlyEric6(楊凱鈞)
 * 2022/5/16
 */
public class ECalculatorUI {
    String[] checkNumber = {"0","1","2","3","4","5","6","7","8","9"};
    String[] checkSpecial = {"+","-","*","/"};
    Queue<String> input = new LinkedList<>();
    Font textfieldFont = new Font("SansSerif", Font.BOLD, 20);
    Font buttonFont = new Font("SansSerif", Font.ITALIC, 15);


    public void build_button(Container panel, String title, GridBagLayout gridBagLayout, GridBagConstraints constraints,JTextField output,Boolean isSpecialButton){
        JButton button = new JButton(title);
        button.setBackground(new Color(211, 211, 211));
        gridBagLayout.setConstraints(button, constraints);
        if(isSpecialButton){
            button.addActionListener(e -> {
                if(Arrays.asList(checkSpecial).contains(output.getText().substring(output.getText().length()-1))){
                    output.setText(output.getText());
                }else if(Arrays.asList(checkNumber).contains(output.getText().substring(output.getText().length()-1))){
                    int plus = output.getText().lastIndexOf("+");
                    int minus = output.getText().lastIndexOf("-");
                    int multiply = output.getText().lastIndexOf("*");
                    int divided = output.getText().lastIndexOf("/");
                    int[] sort_array = {plus,minus,multiply,divided};
                    Arrays.sort(sort_array);
                    System.out.println(Arrays.toString(sort_array));
                    if(!(sort_array[3] == -1)){
                        input.add(output.getText().substring(sort_array[3]+1));
                        input.add(title);
                        output.setText(output.getText()+title);
                        System.out.println(input);
                    }else {
                        input.add(output.getText());
                        input.add(title);
                        output.setText(output.getText()+title);
                    }
                }
            });
        }else {
            button.addActionListener(e ->
                    output.setText(output.getText()+title)
            );
        }
        button.setFont(buttonFont);
        panel.add(button);
    }
    public void addWidgetToPanel(Container panel) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        GridBagConstraints c;

        JTextField output = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 25;
        c.gridwidth = GridBagConstraints.REMAINDER;
        output.setEditable(false);
        output.setFont(textfieldFont);
        panel.add(output, c);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"1",gridBagLayout,c,output,false );
        build_button(panel,"2",gridBagLayout,c,output,false );
        build_button(panel,"3",gridBagLayout,c,output,false );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"+",gridBagLayout,c,output,true );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"4",gridBagLayout,c,output,false);
        build_button(panel,"5",gridBagLayout,c,output,false );
        build_button(panel,"6",gridBagLayout,c,output,false );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"-",gridBagLayout,c,output,true );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"7",gridBagLayout,c,output,false );
        build_button(panel,"8",gridBagLayout,c,output,false );
        build_button(panel,"9",gridBagLayout,c,output,false );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"*",gridBagLayout,c,output,true );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;

        build_button(panel,"0",gridBagLayout,c,output,false );

        JButton button_AC = new JButton("AC");
        gridBagLayout.setConstraints(button_AC,c);
        button_AC.addActionListener(e -> {
            int size = input.size();
            for(int i=0;i<size;i++){
                input.poll();
            }
            System.out.println(input.toString());
            output.setText("");
        });
        button_AC.setBackground(new Color(211, 211, 211));
        button_AC.setFont(buttonFont);
        panel.add(button_AC);

        JButton button_equal = new JButton("=");
        gridBagLayout.setConstraints(button_equal, c);
        button_equal.addActionListener(e -> {
            if(Objects.equals(output.getText(), "")){
                output.setText(output.getText());
            }
            else{
                if(Arrays.asList(checkSpecial).contains(output.getText().substring(output.getText().length()-1))){
                    output.setText(output.getText());
                }else if(Arrays.asList(checkNumber).contains(output.getText().substring(output.getText().length()-1))){
                    output.setText(output.getText()+"=");
                }
            }

            //等待設計處理函式
        });
        button_equal.setBackground(new Color(211, 211, 211));
        button_equal.setFont(buttonFont);
        panel.add(button_equal);

        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"/",gridBagLayout,c,output,true );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 5;
        c.gridy = 5;

        JButton ECalculatorInfo = new JButton();
        ECalculatorInfo.setIcon(new ImageIcon("InfoIcon.png"));
        ECalculatorInfo.setContentAreaFilled(false);
        ECalculatorInfo.setBorderPainted(false);
        ECalculatorInfo.setContentAreaFilled(false);
        panel.add(ECalculatorInfo,c);
    }
    private ECalculatorUI() {
        JFrame ECalculatorWindow = new JFrame("ECalculator");
        ECalculatorWindow.setBounds(300,200,310,360);
        ImageIcon img = new ImageIcon("ECalculator.png");
        ECalculatorWindow.setIconImage(img.getImage());
        ECalculatorWindow.getContentPane().setBackground(new java.awt.Color(7, 18, 37));
        addWidgetToPanel(ECalculatorWindow.getContentPane());
        ECalculatorWindow.setVisible(true);
        ECalculatorWindow.setResizable(false);

    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(ECalculatorUI::new);
    }
}
