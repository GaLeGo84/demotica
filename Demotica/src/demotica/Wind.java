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
public class Wind extends Sensor implements Serializable{

    private int intensity;

    public Wind(int SNumber) {
        super(SNumber);
        this.intensity=20;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
    
    
    
    @Override
    public String toString() {
        String su = super.toString();
        return su+"de Vento";
    }
}
