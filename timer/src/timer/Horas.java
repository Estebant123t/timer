package timer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Horas extends Thread {
    static int flag;
    private static volatile int currentHour = 0;

    public Horas(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int hor = 0;
        while (true) {
            System.out.println("Cambio efectuado " + flag);
            if (flag == 1) {
                incrementHour();
                flag = 0;
            }
        }
    }

    private synchronized void incrementHour() {
        currentHour += 1;
        Timer.sethor(currentHour);
        if (currentHour == 24) {
            resetHour();
        }
    }

    private static synchronized void resetHour() {
        currentHour = 0;
        Timer.sethor(0);
    }

    public static void resetHours() {
        resetHour();
    }
}
