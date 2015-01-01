package demotica;

import java.io.Serializable;

public class Window implements Serializable{

    private boolean status;

    public Window(){
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Window{" + " status=" + status + '}';
    }

}
