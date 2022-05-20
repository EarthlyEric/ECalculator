package window;

import javax.swing.*;
import java.awt.*;

public class ECalculatorInfo {
    public void addWidgetToPanel(Container panel){
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        GridBagConstraints c;

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        JLabel text1 = new JLabel("Made by EarthlyEric6");
        panel.add(text1,c);
    }
    public ECalculatorInfo(){
        JFrame ECalculatorInfoWindow = new JFrame("Info");
        ECalculatorInfoWindow.setBounds(600,300,310,100);

        ImageIcon img = new ImageIcon("resources/ECalculator.png");
        ECalculatorInfoWindow.setIconImage(img.getImage());

        addWidgetToPanel(ECalculatorInfoWindow.getContentPane());

        ECalculatorInfoWindow.setVisible(true);
        ECalculatorInfoWindow.setResizable(false);
    }
}
