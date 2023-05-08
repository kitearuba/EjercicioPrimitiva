import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Primitiva {

    public static void main(String[] args) {

        Random random = new Random();
        int x;
        int y;
        // Crear ArrayLists
        ArrayList<Integer> jugado = new ArrayList<Integer>(Arrays.asList(3,5,11,32,33,41,49,9));
        ArrayList<Integer> ganador = new ArrayList<>();
        ArrayList<Integer> numerosJugados = new ArrayList<Integer>();
       // ArrayList<Integer> reintegro= ArrayList<Integer>();

        for (int i = 0; i < 7;) {
            x = random.nextInt(49)+1;

            // Revisar si hay repetidos
            if (!ganador.contains(x)) {

                // Agregar valor si no esta repetido
                ganador.add(x);
                i++;
                // Crear reintegro y agregar al final del Arraylist cuando los primeros 7 numeros estan guardados
                Collections.sort(ganador);
                if(i==7){
                    y = random.nextInt(9)+1;
                    ganador.add(7,y);
                }
            }
        }
        ArrayList<Integer> compare = new ArrayList<>(ganador.stream().filter(jugado::contains).collect(Collectors.toList()));

        System.out.println(jugado);
        System.out.println(ganador);
        System.out.println(compare);
        //ganador.retainAll(jugado);

        System.out.println(ganador);



    }
}
