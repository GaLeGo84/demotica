package demotica;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class TimeIntervalLight implements Serializable{
    
    private Date begin;
    private Date end;

    public TimeIntervalLight(Date begin, Date end) {
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd");
        //this.times = ft.get2DigitYearStart();
        this.begin = begin;
        this.end = end;
    }

    
    
    

}
