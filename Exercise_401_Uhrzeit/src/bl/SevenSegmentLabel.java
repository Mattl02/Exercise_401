
package bl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Matthias
 */
public class SevenSegmentLabel extends JLabel{

    private int number;

    public SevenSegmentLabel(int number) {
        //this.number = number;
        this.setFont(new Font("Arial", Font.PLAIN, 50));
        this.setForeground(Color.red);
        this.setNumber(number);
        //this.setIcon(new ImageIcon("./res/"+number+".png"));
    }

    public void setNumber(int number) {
        this.number = number;
        if(number >= 0) this.setIcon(new ImageIcon("./res/"+number+".png"));
        else{
            this.setIcon(null);
            this.setText(":");
        }
    }

    public int getNumber() {
        return number;
    }


}
