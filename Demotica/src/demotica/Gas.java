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
public class Gas extends Sensor implements Serializable{

    private boolean detection;

    public Gas(int SNumber) {
        super(SNumber);
        this.detection = false;
    }

    @Override
    public String toString() {
        String su = super.toString();
        return su+" de Gas";
    }
}
