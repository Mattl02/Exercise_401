
package bl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Matthias
 */
public class Clock extends JPanel implements Runnable{

    private ArrayList<SevenSegmentLabel> labels = new ArrayList<>();
    private JPanel clockPanel;

    public Clock(String clockName) {
        this.clockPanel = new JPanel();
        clockPanel.setLayout(new GridLayout(1,6));
        labels.add(new SevenSegmentLabel(0));
        labels.add(new SevenSegmentLabel(0));
        labels.add(new SevenSegmentLabel(-1));
        labels.add(new SevenSegmentLabel(0));
        labels.add(new SevenSegmentLabel(0));
        labels.add(new SevenSegmentLabel(-1));
        labels.add(new SevenSegmentLabel(0));
        labels.add(new SevenSegmentLabel(0));
        
        for (SevenSegmentLabel label : labels) {
            clockPanel.add(label);
        }
        
        this.setLayout(new BorderLayout());
        this.add(new JLabel(String.format("%-25s", clockName)), BorderLayout.WEST);
        this.add(clockPanel, BorderLayout.CENTER);
    }
    
    public Clock(String clockName, LocalTime time){
        this.clockPanel = new JPanel();
        clockPanel.setLayout(new GridLayout(1,6));
        labels.add(new SevenSegmentLabel(time.getHour()/10));
        labels.add(new SevenSegmentLabel(time.getHour()%10));
        labels.add(new SevenSegmentLabel(-1));
        labels.add(new SevenSegmentLabel(time.getMinute()/10));
        labels.add(new SevenSegmentLabel(time.getMinute()%10));
        labels.add(new SevenSegmentLabel(-1));
        labels.add(new SevenSegmentLabel(time.getSecond()/10));
        labels.add(new SevenSegmentLabel(time.getSecond()%10));
        
        for (SevenSegmentLabel label : labels) {
            clockPanel.add(label);
        }
        
        this.setLayout(new BorderLayout());
        this.add(new JLabel(String.format("%-25s", clockName)), BorderLayout.WEST);
        this.add(clockPanel, BorderLayout.CENTER);
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

            if (labels.get(7).getNumber() == 9) {
                labels.get(7).setNumber(0);
                if (labels.get(6).getNumber() == 5) {
                    labels.get(6).setNumber(0);
                    if (labels.get(4).getNumber() == 9) {
                        labels.get(4).setNumber(0);
                        if (labels.get(3).getNumber() == 5) {
                            labels.get(3).setNumber(0);
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
                            labels.get(3).setNumber(labels.get(3).getNumber() + 1);
                        }
                    } else {
                        labels.get(4).setNumber(labels.get(4).getNumber() + 1);
                    }
                } else {
                    labels.get(6).setNumber(labels.get(6).getNumber() + 1);
                }
            } else {
                labels.get(7).setNumber(labels.get(7).getNumber() + 1);
            }
        }
    }

}
