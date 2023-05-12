//Agregar valores del ticket a comprobar en Arguments o no funcionara el codigo

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Primitiva {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int comprobarSorteo;
        int reintegroJugado;
        int reintegroGanador;
        boolean compareReintegro;
        String resultadoNumeros;
        String resultadoReintegro;

        // Crear ArrayLists
        ArrayList<Integer> jugado = new ArrayList<Integer>();
        ArrayList<Integer> ganador = new ArrayList<>();
        ArrayList<Integer> numerosGanador = new ArrayList<>();
        ArrayList<Integer> compareNumeros = new ArrayList<Integer>();
        ArrayList<Integer> numerosJugados = new ArrayList<Integer>();

        // Llama a el metodo que extrae valores en argumments y los agregar a ArrayList.
        extracted(args, jugado);

        // Agregar valor de ArrayList jugado a otro array lista para
        // usar para comparar numeros despues.
        // No es necesario por preferi hacerlo asi.
        numerosJugados = jugado;

        // Agregar reintegro jugado a ArrayList Reintegro. Para comparar separado de los otros numeros.
        reintegroJugado = numerosJugados.get(7);

        // Eliminar numero de reintegro de ArrayList numerosJugados.
        // Esto para comparar solo los numeros sin el reintegro y poder ordenar los numeros.
        numerosJugados.remove(7);

        // Ordenar numeros de < a >
        Collections.sort(numerosJugados);

        System.out.println("Introduce el valor de la cantidad de sorteos a comparar con tu ticket (elejir entre 1 a 6): ");
        // Scanner para obtener el valor de la cantidad de sorteos que hay que comparar el numero
        // ingresado por arguments.
        comprobarSorteo=scanner.nextInt();
        // Metodo principal donde se verifica si el numero introducido en el scanner es valido.
        // Si lo es entra en el buckle y general la cantidad de boltos indicados, los compara, y imprime su resultado.
        extracted(random, comprobarSorteo, reintegroJugado, ganador, numerosGanador, numerosJugados);


    }

    private static void extracted(String[] args, ArrayList<Integer> jugado) {
        for (String arg : args) {
            jugado.add(Integer.valueOf(arg));
        }
    }
    private static void extracted(Random random, int comprobarSorteo, int reintegroJugado, ArrayList<Integer> ganador, ArrayList<Integer> numerosGanador, ArrayList<Integer> numerosJugados) {
        boolean compareReintegro;
        String resultadoReintegro;
        ArrayList<Integer> compareNumeros;
        String resultadoNumeros;
        int reintegroGanador;
        if (comprobarSorteo >0 && comprobarSorteo <7){
            for(int n = 0 ; n < comprobarSorteo; n++){
                int z = 1+n;
                // Vacia la ArrayList de numeros random para cada vuelta del buckle.
                numerosGanador.removeAll(numerosGanador);
                // Llama a el metodo que usa For loop para generar numeros aleatorios.
                extracted(random, ganador, numerosGanador);

                // Agregar reintegro ganador a ArrayList reintegroGanador.
                reintegroGanador = ganador.get(7);

                // Comparar los numeros jugados y copiar los numeros acertados.
                compareNumeros = new ArrayList<>(numerosGanador.stream().filter(numerosJugados::contains).collect(Collectors.toList()));

                // Boolean para ver si los reintegros son iguales.
                compareReintegro = reintegroGanador== reintegroJugado;

                // Llama a el metodo para Comprovar si el reintegro es ganador o no.
                resultadoReintegro = getString(reintegroJugado, compareReintegro);
                // Llama a el metodo para Comprovar si hay numeros ganadores.
                resultadoNumeros = getString(numerosJugados, compareNumeros);



                System.out.println("\n*****************************\n*****************************\n" +
                        "\nSORTEO NUMERO: "+ z +"\n"+resultadoNumeros+"\n"+resultadoReintegro+
                        "\n\nNumeros jugado:    "+ numerosJugados +"\n Reintegro jugado:  "+ reintegroJugado +
                        "\nNumeros ganadores: "+ numerosGanador +"\n Reintegro ganador: "+reintegroGanador);
            }
        }
        else{
            System.out.println("Introduce un valor valido!!!");
        }
    }


    // Metodo para generar numeros aleatorio.
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

    // Metodo para comparar los numeros y dar resultados.
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

    // Metodo para comparar los reintegros y dar resultados.
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
