package demotica;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Door implements Serializable{

    private int ID;
    private boolean status;
    private boolean lock;

    public Door(int ID) {
        this.ID = ID;
        this.status = false;
        this.lock = true;
    }

    public int getId(){
        return ID;
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
