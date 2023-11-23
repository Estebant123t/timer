package timer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class segundos extends Thread {
    private static volatile boolean running = true;
    private static volatile int currentSecond = 0;

    @Override
    public void run() {
        for (; currentSecond < 60 && running; currentSecond++) {
            Timer.setsec(currentSecond);
            try {
                Thread.sleep(10); // Esperar 1000 milisegundos (1 segundo)
            } catch (InterruptedException ex) {
                Logger.getLogger(segundos.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (currentSecond == 59) {
                resetCurrentSecond(); // Reiniciar el contador de segundos
                Minutos.flag = 1;
            }
        }
    }

    public static void stopThread() {
        running = false;
    }

    public static void resetCurrentSecond() {
        currentSecond = 0;
    }
}
