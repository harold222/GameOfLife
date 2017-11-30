
package gameoflife;

import java.util.Random;

public class Proceso {
    int [][] cellular_automata;//atributo el cual dejare publico para la utilizacion de este en la otra clase y la comprobacion de si esta viva o muerta
    
    public Proceso(int width, int height){//parametros los cuales me llegaran de la otra clase
       this.cellular_automata = new int [width][height];
       this.random(width, height);
    }
    
    public void random (int width, int height){
    Random rd = new Random();
    double alive = 0.15;//cantidad de celulas iniciales que aparecen con vida
            for(int i = 0; i< height;i++)
                for(int j = 0; j< width; j++)
                    this.cellular_automata[i][j]= rd.nextDouble() < alive ? 1 : 0;//asignacion de valores de las celulas
            /*
            Se asigna valores de 1 o 0 depende si es mayor menor a la cantidad de celulas vivas iniciales
            si es menor se colocara uno o aparecera la celula viva
            si no, si es mayor se dejara la celula muerta
            */
    }
       
    public void nextIteration(){
        int cont;
        int n1 = this.cellular_automata.length;//valor del primer arreglo de la celula
        int n2 = this.cellular_automata[0].length;//valor del segundo arreglo de la celula
        for(int i =0; i< this.cellular_automata.length;i++){//n1 primer [] n2 []
            for(int j =0; j<this.cellular_automata[0].length;j++){//recorro el arreglo
                cont = this.cellular_automata[(i-1+n1)%n1][(j-1+n2)%n2] +//proceso de sumar los 8 vecinos de los lados
                       this.cellular_automata[(i-1+n1)%n1][j] + 
                       this.cellular_automata[(i-1+n1)%n1][(j+1)%n2] + 
                       this.cellular_automata[i][(j-1+n2)%n2]+
                       this.cellular_automata[i][(j+1)%n2]+
                       this.cellular_automata[(i+1)%n1][(j-1+n2)%n2]+
                       this.cellular_automata[(i+1)%n1][j]+
                       this.cellular_automata[(i+1)%n1][(j+1)%n2];

            if (this.cellular_automata[i][j] == 1)//si esta viva la celula
                this.cellular_automata[i][j] = (cont < 2 || cont > 3) ? 0: 1;
            /*
            Si el contador es menor a 2 o mayor que tres se dejara la celula muerta
            */
            else
                this.cellular_automata[i][j] = cont == 3 ? 1 : 0;
            //Si el contador es igual a tres se dejara viva la celula
        }
    }
    }
}
