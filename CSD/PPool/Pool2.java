// CSD feb 2015 Juansa Sendra

/**
 * Max 2 kids per instructor
 */
public class Pool2 extends Pool {
    private int max;
    private int i, k;
    
    public void init(int ki, int cap) {
        max = ki;
    }
    
    public synchronized void kidSwims() throws InterruptedException {
        while (k > max*(i-1)) {  //Complete the condition
            log.waitingToSwim(); // to show swimmer state
            wait();
        }
        k++; // Update State
        log.swimming(); //to show the swimmer state;
    }
    
    public synchronized void kidRests() {
        k--; // Update State
        notifyAll(); // If needed, awake threads waiting for this state using NotifyAll();
        log.resting();
    }
    
    public synchronized void instructorSwims() {
        i++; // Update State
        notifyAll(); // If needed, awake threads waiting for this state using NotifyAll();
        log.swimming();
    }
    
    /**
     * Fallo division por 0
     */
    public synchronized void instructorRests() throws InterruptedException {
        //(kid > 0 && ins == 1 || (kid > (max*inst-1)))
        while (k > max*(i-1)) {
            log.waitingToRest(); // to show swimmer state
            wait();
        }
        i--; // Update State
        log.resting();
    }
}
