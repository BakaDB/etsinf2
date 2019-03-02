package theantsproblem3;
import java.util.concurrent.*;

public class Territory {
    private int tam; // Matrix size
    private boolean occupied[][];
    
    //Activity 3
    String description = "Using Barriers";
    private Log log;
    
    private final CyclicBarrier barrier;
    
    public String getDesc() {
        return description;
    }

    public Territory(int tamT, Log l) {
        tam = tamT;
        occupied = new boolean[tam][tam];
        log = l;
        
        // Initializing the matrix
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                occupied[i][j] = false;
            }
        }
        
        //Initialize the barrier
        barrier = new CyclicBarrier(tam*tam);
    }

    public int getTam() {
        return tam;
    }

    public void putAnt(Ant h, int x, int y) {
        while (occupied[x][y]) {
            try {
                // Write in the log: ant waiting
                log.writeLog(LogItem.PUT, h.getid(), x, y, LogItem.WAITINS,
                        "Ant " + h.getid() + " waiting for [" + x + "," + y + "]");
                barrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException b) {}
        }
        occupied[x][y] = true;
        h.setPosition(x, y);
        // Write in the log: ant inside territory
        log.writeLog(LogItem.PUT, h.getid(), x, y, LogItem.OK, "Ant " + h.getid() + " : [" + x + "," + y + "]  inside");
    }

    public void takeAnt(Ant h) {
        int x = h.getX();
        int y = h.getY();
        occupied[x][y] = false;
        // Write in the log: ant outside territory
        log.writeLog(LogItem.TAKE, h.getid(), x, y, LogItem.OUT, "Ant " + h.getid() + " : [" + x + "," + y + "] out");
        notifyAll();
    }

    public void moves(Ant h, int x1, int y1, int step) {
        int x = h.getX();
        int y = h.getY();

        while (occupied[x1][y1]) {
            try {
                // Write in the log: ant waiting
                log.writeLog(LogItem.MOVE, h.getid(), x1, y1, LogItem.WAIT,
                        "Ant " + h.getid() + " waiting for [" + x1 + "," + y1 + "]");
                barrier.await();
            } catch (InterruptedException e) {
            } catch (BrokenBarrierException b) {}
        }
        occupied[x][y] = false;
        occupied[x1][y1] = true;
        h.setX(x1);
        h.setY(y1);
        // Write in the log: ant moving
        log.writeLog(LogItem.MOVE, h.getid(), x1, y1, LogItem.OK,
                "Ant " + h.getid() + " : [" + x + "," + y + "] -> [" + x1 + "," + y1 + "] step:" + step);
        notifyAll();

    }
}
