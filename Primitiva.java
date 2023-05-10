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
        int reintegroJugado;
        int reintegroGanador;
        boolean compareReintegro;
        String resultadoNumeros;
        String resultadoReintegro;

        // Crear ArrayLists
        ArrayList<Integer> jugado = new ArrayList<Integer>(Arrays.asList(3,5,11,32,33,41,49,9));
        ArrayList<Integer> numerosJugados = new ArrayList<Integer>(jugado);
        ArrayList<Integer> ganador = new ArrayList<>();
        ArrayList<Integer> numerosGanador = new ArrayList<>();
        ArrayList<Integer> compareNumeros = new ArrayList<Integer>();

        // Agregar reintegro jugado a ArrayList Reintegro
        reintegroJugado = numerosJugados.get(7);

        // Eliminar numero de reintegro de ArrayList numerosJugados
        numerosJugados.remove(7);

        // Llama a el metodo que usa For loop para generar numeros aleatorios
        extracted(random, ganador, numerosGanador);

        // Agregar reintegro ganador a ArrayList reintegroGanador
        reintegroGanador = ganador.get(7);

        // Comparar los numeros jugados y copiar los numeros acertados
        compareNumeros = new ArrayList<>(numerosGanador.stream().filter(numerosJugados::contains).collect(Collectors.toList()));
        // Boolean para ver si los reintegros son iguales.
        compareReintegro = reintegroGanador==reintegroJugado;

        // Llama a el metodo para Comprovar si el reintegro es ganador o no.
        resultadoReintegro = getString(reintegroJugado, compareReintegro);
        // Llama a el metodo para Comprovar si hay numeros ganadores.

        resultadoNumeros = getString(numerosJugados, compareNumeros);


        System.out.println("\n"+resultadoNumeros+"\n"+resultadoReintegro+
                "\n\nNumeros jugado:    "+numerosJugados+"Reintegro jugado: "+reintegroJugado+

                "\nNumeros ganadores: "+numerosGanador+"Reintegro ganador: "+reintegroGanador);

    }

    private static void extracted(Random random, ArrayList<Integer> ganador, ArrayList<Integer> numerosGanador) {
        int y;
        int x;
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
    }

    private static String getString(ArrayList<Integer> numerosJugados, ArrayList<Integer> compareNumeros) {
        String resultadoNumeros;
        if(compareNumeros.size() == 7){
            resultadoNumeros= "Felicitaciones a acertado todos los numeros! Numero ganador: "+ numerosJugados;
        }else if(compareNumeros.size()>0 && compareNumeros.size()<7){
            resultadoNumeros = "As acertados " + compareNumeros.size()+ " numeros"+"\nNumeros acertados: "+ compareNumeros;
        }else{
            resultadoNumeros = "No acerto ningun numero";
        }
        return resultadoNumeros;
    }

    private static String getString(int reintegroJugado, boolean compareReintegro) {
        String resultadoReintegro;
        if(compareReintegro == true){
            resultadoReintegro = "Felicitaciones a acertado el Reintegro. Numero ganador: "+ reintegroJugado;
        }else{
            resultadoReintegro = "Reintegro no acertado.";
        }
        return resultadoReintegro;
    }

}
