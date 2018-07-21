/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author QQ
 */
public class Scheduled {

    Timer timer;

    public Scheduled(int seconds) {
        timer = new Timer();
        timer.schedule(new reminder(), seconds*1000);
    }

    public class reminder extends TimerTask {

        @Override
        public void run() {
            System.out.println("Time's up!");
            timer.cancel();
        }
    }
    public static void main(String[] args) {
        new Scheduled(5);
        System.out.println("Task scheduled!");
        
    }

}
