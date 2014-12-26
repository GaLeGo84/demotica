package demotica;

import java.io.Serializable;

public class Window implements Serializable{

    private int num;
    private boolean status;

    public Window(int num) {
        this.num = num;
        this.status = false;
    }

    public int getNum() {
        return num;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Window{" + "num=" + num + ", status=" + status + '}';
    }

}
