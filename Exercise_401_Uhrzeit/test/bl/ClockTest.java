/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthias
 */
public class ClockTest {
    
    public ClockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of run method, of class Clock.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        LocalTime now = LocalTime.of(11, 35, 45);
        Clock instance = new Clock("Lokale Zeit", now);
        Thread t1 = new Thread(instance);
        t1.start();
        try{
            t1.join(88l);
        }
        catch(Exception ex) {}
        int[] expectedNumbers = new int[]{
            1,1,-1,3,5,-1,4,5
        };
        int[] result = new int[instance.getLabels().size()];
        for(int i = 0; i < result.length; i++){
            result[i] = instance.getLabels().get(i).getNumber();
        }
        assertArrayEquals(expectedNumbers, result);
    }
    
}
