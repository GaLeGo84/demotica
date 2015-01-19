package demotica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class TimeIntervalLight{
    
    private Date begin;
    private Date end;

    public TimeIntervalLight(Date begin, Date end) {
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd");
        //this.times = ft.get2DigitYearStart();
        this.begin = begin;
        this.end = end;
    }

    
    
    

}
