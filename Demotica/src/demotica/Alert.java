package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    
    private static final long serialVersionUID = 5455238796031916510L;
    private boolean status;
    private Map<Integer,List<Contact>> emails;
    private boolean detection;

    public Alert() {
        this.emails = new TreeMap<Integer,List<Contact>>();
        this.status = true;
        this.detection = false;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Map<Integer, List<Contact>> getEmails() {
        return emails;
    }

    public void setEmails(Map<Integer, List<Contact>> emails) {
        this.emails = emails;
    }
    
    public void addContact(LinkedList<Contact> listC,Contact ctc){
        int n=1;
        while(n<=emails.size()){
            if(emails.containsKey(n)==false){
                emails.put(n+1, listC);
                break;
            }            
            n++;
        }
        
       /*if(emails.size()<n)
            emails.put(sen.getSNumber(),sen);*/
    }

    public boolean isDetection() {
        return detection;
    }

    public void setDetection(boolean detection) {
        this.detection = detection;
    }

}
