
package timer;


public class Timer {

    
    static reloj _reloj = new reloj();
    
    public static void main(String[] args) {
        
        _reloj.setVisible(true);
        
        
        segundos hilo = new segundos();
        Minutos hilo2 = new Minutos(0);
        Horas hilo3 = new Horas(0);
        
        hilo.start();     
        hilo2.start();
        hilo3.start();
        
    }
    
    public static void setsec(int _num) {

        _reloj.setSec(_num);
    }

    public static void setmin(int _min) {

        _reloj.setMin(_min);
    }
    public static void sethor(int _hor) {

        _reloj.setHoras(_hor);
    }
    
}
