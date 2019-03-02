// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool { //kids cannot enter if there are instructors waiting to exit
    int i, k, iwait;
    int max, capacity;
    
    public void init(int ki, int cap) {
        max = ki;
        capacity = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException {
        while (k > max*(i-1) || capacity < (k+1+i) || iwait > 0) {   //Complete the condition
            log.waitingToSwim(); // to show swimmer state
            wait();
        }
        k++; // Update State
        log.swimming();
    }
    
    public synchronized void kidRests() {
        k--;
        notifyAll();
        log.resting();
    }
    
    public synchronized void instructorSwims() throws InterruptedException {
        while (capacity < (k+i+1)) {
            log.waitingToSwim();
            wait();
        }
        i++;
        log.swimming();
    }
    
    public synchronized void instructorRests() throws InterruptedException {
        while(k > max*(i-1)) {
            iwait++;
            log.waitingToRest();
            wait();
        }
        i--;
        log.resting();
    }
}
