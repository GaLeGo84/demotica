package demotica;

import java.io.Serializable;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */
public class Contact {

    private int type;
    private String email;

    /**
     * 
     * @param type - identifica o tipo 1- Policia, 2-Bombeiros, 3-Outros
     * @param email - Identifica o Email
     */
    public Contact(int type, String email) {
        this.type = type;
        this.email = email;
    }

    /**
     * 
     * @return o Email
     */
    public String getEmail() {
        return email;
    }


    /**
     * 
     * @return o tipo de contacto
     */
    public int getType() {
        return type;
    }
    
}