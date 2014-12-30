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
public abstract class Alert implements Serializable{

    private boolean status;
    private Contact email;
    private boolean detection;
    

    public Alert(Contact email) {
        this.email = email;
        this.status = true;
        this.detection = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Contact getEmail() {
        return email;
    }

    public void setEmail(Contact email) {
        this.email = email;
    }

    public boolean isDetection() {
        return detection;
    }

    public void setDetection(boolean detection) {
        this.detection = detection;
    }

}
