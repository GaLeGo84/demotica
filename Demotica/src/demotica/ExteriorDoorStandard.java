/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

import java.io.Serializable;

/**
 *
 * @author Home
 */
public class ExteriorDoorStandard extends ExteriorDoor implements Serializable{

    public ExteriorDoorStandard(int num) {
        super(num);

    }
    
    @Override
    public String toString() {
        return super.toString() +"do Exterior";
    }
    
}