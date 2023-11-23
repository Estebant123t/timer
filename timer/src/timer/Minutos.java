package timer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Minutos extends Thread {
    static int flag;
    private static volatile int currentMinute = 0;

    public Minutos(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Cambio efectuado " + flag);
            if (flag == 1) {
                incrementMinute();
                flag = 0;
            }

            if (currentMinute > 59) {
                resetMinute();
                Horas.flag = 1;
            }

            sleepUninterruptedly(1000); // Esperar 1000 milisegundos (1 segundo)
        }
    }

    private synchronized void incrementMinute() {
        currentMinute += 1;
        if (currentMinute != 60) {
            Timer.setmin(currentMinute);
        }
        if (currentMinute == 60) {
            Timer.setmin(0);
        }
    }

    private static synchronized void resetMinute() {
        currentMinute = 0;
        Timer.setmin(0);
    }

    public static void resetMinutes() {
        resetMinute();
    }

    private static void sleepUninterruptedly(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(Minutos.class.getName()).log(Level.SEVERE, null, ex);
            Thread.currentThread().interrupt();
        }
    }
}
