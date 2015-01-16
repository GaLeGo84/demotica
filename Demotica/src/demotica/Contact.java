package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Contact implements Serializable{

    private static final long serialVersionUID = 5455238796031916510L;
    private int id;
    private int type;
    private String email;

    public Contact(int id, int type, String email) {
        this.id = id;
        this.type = type;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setName(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    

    
    @Override
    public String toString() {
        return "Contact{" + "id=" + id + ", email=" + email + '}';
    }
    
    
}
