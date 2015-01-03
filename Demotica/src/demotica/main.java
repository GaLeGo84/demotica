/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

import java.util.Scanner;

/**
 *
 * @author Home
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Criar a casa
        Home home = new Home(2,5,5);

        
        //Criar a Divisão com o andar
        Division div0 = new Division("Divisao de Entrada",0,new Climate());
        Division div1 = new Division("Corredor",0,new Climate());
        Division div2 = new Division("Quarto de Jantar",0,new Climate());
        Division div3 = new Division("Sala",0,new Climate());
        Division div4 = new Division("Quarto de banho1",0,new Climate());
        Division div5 = new Division("Cozinha",0,new Climate());
        Division div6 = new Division("Quarto solteiro1",1,new Climate());
        Division div7 = new Division("Quarto solteiro2",1,new Climate());
        Division div8 = new Division("Quarto de casal",1,new Climate());
        Division div9 = new Division("Quarto de banho2",1,new Climate());
        Division div10 = new Division("Quarto largo",1,new Climate());
        
        //Adicionar as divisões à casa
        home.addDivision(div0);
        home.addDivision(div1);
        home.addDivision(div2);
        home.addDivision(div3);
        home.addDivision(div4);
        home.addDivision(div5);
        home.addDivision(div6);
        home.addDivision(div7);
        home.addDivision(div8);
        home.addDivision(div9);
        home.addDivision(div10);
        
        //Adicionar sensores á Divisão de Entrada
        div0.addSensor(new Moviment("SM00001",120000));
        div0.addSensor(new Temperature("ST00001"));
        div0.addSensor(new NaturaLight("SN00001"));
        div0.addDoor(new ExteriorEntranceDoor(1, new Security()));
        div0.addDoor(new InteriorDoor(12));
        div0.addWindow(new Window());
        div0.addWindow(new Window());
        div0.addLight(new Light());
        
        //Adicionar sensores do Corredor
        div1.addSensor(new Moviment("SM00002",120));
        div1.addSensor(new Moviment("SM00003",120));
        div1.addSensor(new Temperature("ST00002"));
        div1.addSensor(new NaturaLight("SN00002"));
        div1.addDoor(new InteriorDoor(2));
        div1.addDoor(new InteriorDoor(3));
        div1.addDoor(new InteriorDoor(4));
        div1.addDoor(new InteriorDoor(5));
        div1.addDoor(new InteriorDoor(12));
        div1.addWindow(new Window());
        div1.addWindow(new Window());
        
        //Adicionar sensores do Quarto de Jantar
        div2.addSensor(new Moviment("SM00004",2));
        div2.addSensor(new Moviment("SM00005",2));
        div2.addSensor(new Temperature("ST00003"));
        div2.addSensor(new NaturaLight("SN00003"));
        div2.addDoor(new InteriorDoor(3));
        div2.addDoor(new InteriorDoor(6));
        div2.addWindow(new Window());
        
        //Adicionar sensores para Sala
        div3.addSensor(new Moviment("SM00006",2));
        div3.addSensor(new Moviment("SM00007",2));
        div3.addSensor(new Temperature("ST00004"));
        div3.addSensor(new NaturaLight("SN00004"));
        div3.addDoor(new InteriorDoor(2));
        div3.addDoor(new InteriorDoor(6));
        div3.addWindow(new Window());

        //Adicionar sensores do Quarto de banho1
        div4.addSensor(new Moviment("SM00008",2));
        div4.addSensor(new Temperature("ST00005"));
        div4.addSensor(new NaturaLight("SN00005"));
        div4.addDoor(new InteriorDoor(4));
        div4.addWindow(new Window());
        
        //Adicionar sensores da cozinha
        div5.addSensor(new Moviment("SM00009",5));
        div5.addSensor(new Moviment("SM00010",5));
        div5.addSensor(new Temperature("ST00006"));
        div5.addSensor(new NaturaLight("SN00006"));
        div5.addDoor(new InteriorDoor(5));
        div5.addDoor(new ExteriorDoorStandard(7));
        div5.addWindow(new Window());
        div5.addWindow(new Window());

        //Adicionar sensores do Quarto solteiro1
        div6.addSensor(new Moviment("SM00011",2));
        div6.addSensor(new Temperature("ST00007"));
        div6.addSensor(new NaturaLight("SN00007"));
        div6.addDoor(new InteriorDoor(10));
        div6.addWindow(new Window());

        //Adicionar sensores do Quarto solteiro2
        div7.addSensor(new Moviment("SM00012",2));
        div7.addSensor(new Temperature("ST00008"));
        div7.addSensor(new NaturaLight("SN00008"));
        div7.addDoor(new InteriorDoor(11));
        div7.addWindow(new Window());
        
        //Adicionar sensores do Quarto de Casal
        div8.addSensor(new Moviment("SM00013",2));
        div8.addSensor(new Moviment("SM00014",2));
        div8.addSensor(new Temperature("ST00009"));
        div8.addSensor(new NaturaLight("SN00009"));
        div8.addDoor(new InteriorDoor(8));
        div8.addWindow(new Window());
        div8.addWindow(new Window());
        
        //Adicionar sensores do Quarto de banho2
        div9.addSensor(new Moviment("SM00014",2));
        div9.addSensor(new Temperature("ST000010"));
        div9.addSensor(new NaturaLight("SN000010"));
        div9.addDoor(new InteriorDoor(9));
        div9.addWindow(new Window());
        
        //Adicionar sensores á Divisão de Entrada
        div10.addSensor(new Moviment("SM00015",2));
        div10.addSensor(new Moviment("SM00016",2));
        div10.addSensor(new Moviment("SM00017",2));
        div10.addSensor(new Temperature("ST000011"));
        div10.addSensor(new NaturaLight("SN000011"));
        div10.addDoor(new InteriorDoor(8));
        div10.addDoor(new InteriorDoor(9));
        div10.addDoor(new InteriorDoor(10));
        div10.addDoor(new InteriorDoor(11));
        div10.addWindow(new Window());
        
        /*Quando é detetado um movimento no Corredor o valor da luz natural=5 
          o valor do sensor é de 8
        */
        File fi = new File();
        //Home h = fi.loadHome();
        System.out.println(System.currentTimeMillis());
        //Dashboard.getHome().toString();
        //System.out.println(home.toString());
        
       fi.saveHome(home);
        
        /*System.out.println(System.currentTimeMillis());
        File fi = new File();
        Home h = fi.loadHome();
        Dashboard dash= new Dashboard(h);
        dash.MenuDivisions();*/
    }

}
