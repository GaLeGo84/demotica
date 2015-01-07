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
public class ExteriorEntranceDoor extends ExteriorDoor implements Serializable{

    private Security security;
    
    public ExteriorEntranceDoor(int num, Security security) {
        super(num);
        this.security = security;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }
    
    public void activeSecurity(){
        security.setStatus(true);
    }
    
    public void deactiveSecurity(){
        security.setStatus(false);
    }

    @Override
    public String toString() {
        return super.toString() +"de Entrada";
    }
}
