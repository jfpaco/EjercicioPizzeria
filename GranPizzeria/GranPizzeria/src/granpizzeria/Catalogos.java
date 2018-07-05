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
public class Catalogos {
    
    // Se crea el listado de tipos de Ingredientes
    public ArrayList<String> catIngredientes = new ArrayList<String>();
    
    // Se agregan los tipos de Ingredientes las catIngredientes
    public Catalogos(){
        catIngredientes.add("Peperoni");
        catIngredientes.add("Jamón");
        catIngredientes.add("Chorizo");
        catIngredientes.add("Champiñones");
        catIngredientes.add("Queso Extra");
        catIngredientes.add("Aguacate");
        catIngredientes.add("Cebolla");
        catIngredientes.add("Jalapeños");
    } 
    
    public void addIngrediente(String ing){
        catIngredientes.add(ing);
    }
    
}
