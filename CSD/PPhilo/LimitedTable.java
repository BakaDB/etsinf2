// CSD Mar 2013 Juansa Sendra

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    private int size;
    
    public LimitedTable(StateManager state) {
        super(state);
        size = 0;
    }
    
    public synchronized void enter(int id) throws InterruptedException {
        while (size >= 4) {
            state.wenter(id);
            wait();
        }
        size++;
    }
    public synchronized void exit(int id)  {
        size--;
        if (size == 4) notifyAll();
        state.exit(id);
    }
}
