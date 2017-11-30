
package gameoflife;

import processing.core.PApplet;//importamos la libreria PApplet

/**
 * @author Harold Pedraza
 * @version 25/10/2017
 */

public class GameOfLife extends PApplet{

    public static void main(String[] args) {
            String[] a = {"MAIN"};
        PApplet.runSketch(a, new GameOfLife());//metodo papplet para llamar la funcion main
    }
    
    int width = 100;//largo
    int height = 100;//ancho
    int square_size = 8;//cantidad de pixeles
    
    Proceso ca = new Proceso(width, height);//constructor para llamar la otra clase y pasar los parametros
    
    /*
    Metodos settings, draw los cuales siempre van cuando quiero hacer un programa en processing
    */
    
    @Override
    public void settings(){
        size(width * square_size,height * square_size);//Tamaño con que se imprimira la ventana del juego multiplicando los pixeles
    }
    
    @Override
    public void draw(){
        background(100);//Color del fondo del juego
        stroke(50);
        for(int i = 0;i< height;i++){
            for (int j = 0; j< width;j++){
                if (ca.cellular_automata[i][j]==1){//si la celula en esa posicion esta viva
                    fill(255,150,0);//Se le dara un color para diferenciarla
                    rect(j * square_size, i * square_size, square_size, square_size,7);//para imprimir en cuadrado borro el 7 de los dos
                }else{
                    fill(0,0,100);//si esta muerta la celula le daremos otro color
                    rect(j * square_size, i * square_size, square_size, square_size,7);
                    /*
                    metodo para que se dibuje un cuadrado se necesitan 4 parametros
                    para un rectangulo se necesitan 5 parametros
                    y para combinacion de los dos 8 parametros
                    y este se vere en las celulas del juego
                    */
                }
            }
        }
        
        try{//excepcion
        Thread.sleep(150);//tiempo en que se vera el movimiento de las celulas
        ca.nextIteration();//llamo al ciclo iteracion para dar dar el ciclo de las celulas
        }catch (InterruptedException e){// contendrá el codigo necesario para gestionar el error
            e.printStackTrace();//diagnostica una excepción dice qué sucedió y en qué parte del código sucedió esto
        }
    }
}
