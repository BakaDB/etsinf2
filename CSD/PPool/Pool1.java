// CSD feb 2015 Juansa Sendra

/**
 *  No kids alone
 */
public class Pool1 extends Pool {
    private int i, k;
    
    public void init(int ki, int cap) {}
    
    public synchronized void kidSwims() throws InterruptedException {
        while (i <= 0) {  //Complete the condition
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
    
    public synchronized void instructorRests() throws InterruptedException {
        while (i <= 1 && k > 0) {  //Complete the condition
            log.waitingToRest(); // to show swimmer state
            wait();
        }
        i--; // Update State      
        log.resting();
    }
}
