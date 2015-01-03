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
public class Climate implements Serializable{

    private static int MINVALUE=12;
    private static int MAXVALUE=25;
    private boolean aircon;
    private boolean heating;

    public Climate() {
        this.aircon = false;
        this.heating = false;
    }   

    public int getMINVALUE() {
        return MINVALUE;
    }

    public void setMINVALUE(int MINVALUE) {
        this.MINVALUE = MINVALUE;
    }

    public int getMAXVALUE() {
        return MAXVALUE;
    }

    public void setMAXVALUE(int MAXVALUE) {
        this.MAXVALUE = MAXVALUE;
    }

    public boolean isAircon() {
        return aircon;
    }

    public void setAircon(boolean aircon) {
        this.aircon = aircon;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    @Override
    public String toString() {
        return "Climate{" + "aircon=" + aircon + ", heating=" + heating + '}';
    }

}
