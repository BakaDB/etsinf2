// CSD Mar 2013 Juansa Sendra

/**
 * 1. Philosophers always take first the chopstick on their right and then 
 * the chopstick on their left, except for philosopher 4, who takes the 
 * chopstick on his left first.
 * 
 * 2. Even-numbered philosophers take the chopstick on their right first, while  
 * odd-numbered philosophers start by taking the chopstick on their left. 
 */
public class LefthandedPhilo extends Philo {
    
    public LefthandedPhilo(int id, int cycles, int delay, Table table) {
        super(id,cycles,delay,table);
    }
    
    public void run() {
        try {
            table.begin(id);
            for (int i=0; i<cycles; i++) {
                table.takeL(id); delay(); table.takeR(id);
                table.eat(id); randomDelay();
                table.dropR(id); table.dropL(id);
                table.ponder(id); randomDelay();
            }
            table.end(id);
        } 
        catch (InterruptedException ex) {}
    }
}