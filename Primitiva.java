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
        int reintGanador;

        String resultadoNumeros;
        String resultadoReintegro;

        // Crear ArrayLists
        ArrayList<Integer> jugado = new ArrayList<Integer>(Arrays.asList(3,5,11,32,33,41,49,9));
        ArrayList<Integer> numerosJugados = new ArrayList<Integer>(jugado);
        ArrayList<Integer> reintegroJugado = new ArrayList<Integer>();
        ArrayList<Integer> ganador = new ArrayList<>();
        ArrayList<Integer> numerosGanador = new ArrayList<>();
        ArrayList<Integer> reintegroGanador = new ArrayList<>();
        ArrayList<Integer> compareNumeros = new ArrayList<Integer>();
        boolean compareReintegro;

        // Agregar reintegro jugado a ArrayList Reintegro
        int reintJugado = numerosJugados.get(7);
        reintegroJugado.add(reintJugado);

        // Eliminar numero de reintegro de ArrayList numerosJugados
        numerosJugados.remove(7);

        // For loop para generar numeros aleatorios
        for (int i = 0; i < 7;) {
            x = random.nextInt(49)+1;

            // Revisar si hay repetidos
            if (!ganador.contains(x)) {

                // Agregar valor si no esta repetido
                ganador.add(x);
                numerosGanador.add(x);
                i++;
                // Ordenar numeros de < a >
                Collections.sort(ganador);
                Collections.sort(numerosGanador);
                // Crear reintegro y agregar al final del Arraylist cuando los primeros 7 numeros estan guardados
                if(i==7){
                    y = random.nextInt(9)+1;
                    ganador.add(7,y);
                }
            }
        }

        // Agregar reintegro ganador a ArrayList reintegroGanador
        reintGanador = ganador.get(7);
        reintegroGanador.add(reintGanador);

        // Eliminar numero de reintegro de ArrayList numerosGanador
        //numerosGanador.remove(7);

        compareNumeros = new ArrayList<>(numerosGanador.stream().filter(numerosJugados::contains).collect(Collectors.toList()));
        compareReintegro = reintegroGanador.equals(reintegroJugado);
        // Comprovar si el reintegro es ganador o no.
        if(compareReintegro == true){
            resultadoReintegro = "Felicitaciones a acertado el Reintegro. Numero ganador: "+reintegroJugado;
        }else{
            resultadoReintegro = "Reintegro no acertado.";
        }
        // Comprovar si hay numeros ganadores.
        if(compareNumeros.size() == 7){
            resultadoNumeros= "Felicitaciones a acertado todos los numeros! Numero ganador: "+numerosJugados;
        }else if(compareNumeros.size()>0 && compareNumeros.size()<7){
            resultadoNumeros = "As acertados " + compareNumeros.size()+ " numeros"+"\nNumeros acertados: "+compareNumeros;
        }else{
            resultadoNumeros = "No acerto ningun numero";
        }       
        
        // Imprimir resultados
        System.out.println("\n"+resultadoNumeros+"\n"+resultadoReintegro+
                "\n\nNumeros jugado:    "+numerosJugados+"Reintegro jugado: "+reintegroJugado+
                "\nNumeros ganadores: "+numerosGanador+"Reintegro ganador: "+reintegroGanador);
    }
}
