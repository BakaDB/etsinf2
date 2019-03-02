// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    int max, capacity;
    int k, i;
    
    public void init(int ki, int cap) {
        max = ki;
        capacity = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException {
        while (k > max*(i-1) || capacity < (k+1+i)) {  //Complete the condition
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
    
    public synchronized void instructorRests()  throws InterruptedException {
        while(k > max*(i-1)) {
            log.waitingToRest();
            wait();
        }
        i--;
        log.resting();
    }
}
