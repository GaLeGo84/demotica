package demotica;

import java.io.Serializable;

public class Security implements Serializable{

    private boolean status;

    public Security() {
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
