/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granpizzeria;

import java.util.Scanner;
import granpizzeria.Catalogos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author jfpac
 */
public class GranPizzeria {
    
    // Variables de uso general dentro de la aplicación
    public static String _pedidoProcesando="";
    public static ArrayList<String> _pedido = new ArrayList<>();
    public static Queue<String> _cola=new LinkedList();    
  
    /**
     * Metodo principal
     */
    public static void main(String[] args) {
        // Se inicializa el objeto de lectura en consola        
        Scanner sc = new Scanner(System.in);
        String lectura="";
        String pizza="";
        Integer cantidad=0;
        boolean resp =false;
        do{
            granpizzeria.Pizza pz= new Pizza();
            System.out.println("Que Pizza desea ordenar ");
            Integer opcion=1;
            // Se genera el menu en pantalla con los tipos de Pizzas de la clase Pizza
            for(String d : pz.catPizzas){
                 System.out.println(opcion + " - " + d.toUpperCase());
                 opcion++;
            }            
            System.out.println("S - SALIR");
            pizza=sc.nextLine();
            // Dependiento de la opción elegida se extraen los ingredientes
            switch(pizza){
                case "1":
                    pizza = pz.getHawaii();
                    break;
                case "2":
                    pizza = pz.getChicago();
                    break;
                case "3":
                    pizza = pz.getMexicana();
                    break;
                case "4":
                    pizza = pz.getClasica();
                    break;
            }           
            System.out.println("Número de pizzas ");
            lectura= sc.nextLine();
            cantidad= Integer.parseInt(lectura);
            
            // Una vez hecho el pedido se envian los datos para registrarlos en la cola
            Pedidos(pizza, cantidad);    

            // Si la opción elegida es S se sale del sistema
            if(lectura.equals("S")){
                resp=true;
            }
        }while(!resp);
        
    }
    
    // Se guardan en la cola todos los pedidos dependiendo de su cantidad
    public static void Pedidos(String pizza, Integer cantidad){   
        for(int i=0; i<cantidad;i++){
            _cola.add(pizza);
        }
        System.out.println("PEDIDOS PENDIENTES => " + _cola);
        // Se valida que no este ningun pedido en proceso antes de iniciar algun otro 
        if(_pedidoProcesando==""){
            _pedidoProcesando = _cola.peek();
            ProcesarPedidos();
        }
    }
    
    
    public static void ProcesarPedidos(){  
        granpizzeria.GranPizzeria sd = new granpizzeria.GranPizzeria();
        sd.IniciarProcesos();        
    }

    // Inica un Timer para procesar los pedidos que esta en la cola 
    public static void IniciarProcesos (){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
        int tick=0;
        @Override
        public void run()
        {
            if(!_cola.isEmpty()){
                if(_pedidoProcesando==""){
                _pedidoProcesando = _cola.peek();    
                }
                if(tick == 2){
                    System.out.println("EN PEDIDO - "+_pedidoProcesando  );
                }else if (tick == 4){
                    System.out.println("EN ARMADO - "+_pedidoProcesando  );
                }else if (tick == 6){
                    System.out.println("EN HORNO - "+_pedidoProcesando   );
                }else if (tick == 8){
                    System.out.println("EN EMPACADO - "+_pedidoProcesando );
                }else if (tick == 10){
                    System.out.println("ENTREGADO AL CLIENTE - "+_pedidoProcesando  );                 
                }
                tick++;
                if (tick>10){
                 _cola.poll();
                 tick=0;
                 _pedidoProcesando="";
                }           
            }
        }
        };
        // Parametros con los que se va a ejecutar el Timer. iniciara depues de 100ms y cada iteracción sera cada 3000
    timer.schedule(task, 100, 2000);
    }
}
