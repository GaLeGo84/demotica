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
public class NaturaLight extends Sensor implements Serializable{

    private int value;

    public NaturaLight() {
        this.value = 15;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String su = super.toString();
        return su+"Luz Natural{" + "valor=" + value + '}';
    }

    
    
    
}