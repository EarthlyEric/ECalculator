package windows;

import javax.swing.*;
import java.awt.*;

public class ECalculatorInfo {
    public void addWidgetToPanel(Container panel){
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);

        GridBagConstraints line1 = new GridBagConstraints();
        line1.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints line2 = new GridBagConstraints();
        line2.fill = GridBagConstraints.HORIZONTAL;
        line2.gridy = 1; 

        JLabel author = new JLabel("Made by EarthlyEric6");
        JLabel github_url = new JLabel("https://github.com/EarthlyEric/ECalculator");

        panel.add(author, line1);
        panel.add(github_url, line2);
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
