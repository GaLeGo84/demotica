package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Door implements Serializable{

    private int id;
    private boolean status;
    private boolean lock;

    public Door(int id) {
        this.id = id;
        this.status = false;
        this.lock = true;
    }

    public int getId(){
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Porta ";
    }


}
