/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granpizzeria;

import java.util.ArrayList;

/**
 *
 * @author jfpac
 */
public class Pizza {
    
    // Se crea el listado de tipos de Pizzas
    public ArrayList<String> catPizzas = new ArrayList<String>();
    
    // Se agregan los tipos de Pizzas las catPizzas
    public Pizza(){
        catPizzas.add("Hawaii");
        catPizzas.add("Chicago");
        catPizzas.add("Mexicana");
        catPizzas.add("Clasica");
    }
    
    public String getHawaii(){
        return "Hawaii - Queso extra y Piña";
    }
    public String getChicago(){
        return "Chicago - Mortadela, Pimiento y Tocino";
    }
    public String getMexicana(){
        return "Mexicana - Queso extra y Piña";
    }
    public String getClasica(){
        return "Clasica - Mortadela, Pimiento y Tocino";
    }
    
}
