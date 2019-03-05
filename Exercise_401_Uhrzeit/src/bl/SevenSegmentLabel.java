
package bl;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Matthias
 */
public class SevenSegmentLabel extends JLabel{

    private int number;

    public SevenSegmentLabel(int number) {
        this.number = number;
        this.setIcon(new ImageIcon("./res/"+number+".png"));
    }

    public void setNumber(int number) {
        this.number = number;
        this.setIcon(new ImageIcon("./res/"+number+".png"));
    }

    public int getNumber() {
        return number;
    }


}
