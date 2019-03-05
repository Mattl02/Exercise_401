
package bl;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class Clock extends JPanel implements Runnable{

    private ArrayList<SevenSegmentLabel> labels = new ArrayList<>();

    public Clock() {
        this.setLayout(new GridLayout(1,6));
        
        labels.add(new SevenSegmentLabel(2));
        labels.add(new SevenSegmentLabel(3));
        labels.add(new SevenSegmentLabel(5));
        labels.add(new SevenSegmentLabel(9));
        labels.add(new SevenSegmentLabel(5));
        labels.add(new SevenSegmentLabel(6));
        
        for (SevenSegmentLabel label : labels) {
            this.add(label);
        }
    }

    public ArrayList<SevenSegmentLabel> getLabels() {
        return labels;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (labels.get(5).getNumber() == 9) {
                labels.get(5).setNumber(0);
                if (labels.get(4).getNumber() == 5) {
                    labels.get(4).setNumber(0);
                    if (labels.get(3).getNumber() == 9) {
                        labels.get(3).setNumber(0);
                        if (labels.get(2).getNumber() == 5) {
                            labels.get(2).setNumber(0);
                            if (labels.get(1).getNumber() == 9) {
                                labels.get(1).setNumber(0);
//                                if (labels.get(0).getNumber() == 2 && labels.get(1).getNumber() == 3) {
//                                    labels.get(0).setNumber(0);
//                                    labels.get(1).setNumber(0);
//                                } else {
//                                    labels.get(0).setNumber(labels.get(0).getNumber() + 1);
//                                }
                            } else {
                                labels.get(1).setNumber(labels.get(1).getNumber() + 1);
                            }
                            if(labels.get(0).getNumber() == 2 && labels.get(1).getNumber() == 4){
                                labels.get(0).setNumber(0);
                                labels.get(1).setNumber(0);
                            }
                        } else {
                            labels.get(2).setNumber(labels.get(2).getNumber() + 1);
                        }
                    } else {
                        labels.get(3).setNumber(labels.get(3).getNumber() + 1);
                    }
                } else {
                    labels.get(4).setNumber(labels.get(4).getNumber() + 1);
                }
            } else {
                labels.get(5).setNumber(labels.get(5).getNumber() + 1);
            }
        }
    }

}
