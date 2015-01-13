package demotica;

import java.io.Serializable;

public class Window implements Serializable{

    private boolean status;
    private boolean lock;

    public Window(){
        this.status = false;
        this.lock = false;        
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "Window{" + " status=" + status + '}';
    }

}
