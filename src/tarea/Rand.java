
package tarea;


public class Rand {
    public static int randomNumber(int min, int max) {
        return (int) Math.floor(Math.random() * (min - (max + 1)) + (max + 1));
    }
    
}
