import javax.swing.*;
import java.awt.*;
import java.util.Objects;
/**
 * ECalculator
 * @author EarthlyEric6(楊凱鈞)
 * 2022/5/16
 */
public class ECalculatorUI {
    public void build_button(Container panel, String title, GridBagLayout gridBagLayout, GridBagConstraints constraints,JTextField output){
        JButton button = new JButton(title);
        gridBagLayout.setConstraints(button, constraints);
        button.addActionListener(e ->
                output.setText(output.getText()+title));
        panel.add(button);
    }
    public void addWidgetToPanel(Container panel) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        GridBagConstraints c;

        JTextField output = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;
        c.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(output, c);

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"1",gridBagLayout,c,output );
        build_button(panel,"2",gridBagLayout,c,output );
        build_button(panel,"3",gridBagLayout,c,output );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"+",gridBagLayout,c,output );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"4",gridBagLayout,c,output );
        build_button(panel,"5",gridBagLayout,c,output );
        build_button(panel,"6",gridBagLayout,c,output );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"-",gridBagLayout,c,output );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;
        build_button(panel,"7",gridBagLayout,c,output );
        build_button(panel,"8",gridBagLayout,c,output );
        build_button(panel,"9",gridBagLayout,c,output );
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"*",gridBagLayout,c,output );

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 25;
        c.ipady = 25;

        build_button(panel,"0",gridBagLayout,c,output );

        JButton button_AC = new JButton("AC");
        gridBagLayout.setConstraints(button_AC,c);
        button_AC.addActionListener(e -> {
            output.setText("");
        });

        panel.add(button_AC);

        JButton button_equal = new JButton("=");
        gridBagLayout.setConstraints(button_equal, c);
        button_equal.addActionListener(e -> {
            if(Objects.equals(output.getText(), "")){
                output.setText(output.getText());
            }
            else{
                output.setText(output.getText()+"=");
            }

            //等待設計處理函式
        });
        panel.add(button_equal);
        c.gridwidth = GridBagConstraints.REMAINDER;
        build_button(panel,"/",gridBagLayout,c,output );
    }
    private ECalculatorUI() {
        JFrame ECalculatorWindow = new JFrame("ECalculator");
        ECalculatorWindow.setBounds(300,200,400,300);
        ImageIcon img = new ImageIcon("src/main/resources/ECalculator.png");
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
