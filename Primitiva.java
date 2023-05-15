//Agregar valores del ticket a comprobar en Arguments o no funcionara el codigo


package versionesAnteriores;

import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;

public class PrimitivaUnaPaginaFinal {

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
        ArrayList<Integer> compareNumeros = new ArrayList<>();
        ArrayList<Integer> numerosJugados = new ArrayList<>();


        // Llama a el metodo que extrae valores en argumments y los agregar a ArrayList.
        extraeArguments(args, jugado);

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

        System.out.println("Introduce el valor de la cantidad de sorteos a comparar con tu ticket: ");
        // Scanner para obtener el valor de la cantidad de sorteos que hay que comparar el numero
        // ingresado por arguments.
        comprobarSorteo=scanner.nextInt();
        scanner.close();
        // Metodo principal donde se verifica si el numero introducido en el scanner es valido.
        // Si lo es entra en el buckle y general la cantidad de boltos indicados, los compara, y imprime su resultado.
        metodoPrincipal(random, comprobarSorteo, reintegroJugado, ganador, numerosGanador, numerosJugados);


    }
    // Metodo para extraer los valores en Arguments y agregarlos a un ArrayList
    private static void extraeArguments(String[] args, ArrayList<Integer> jugado) {
        for (String arg : args) {
            jugado.add(Integer.valueOf(arg));
        }
    }
    // Metodo principal donde se crean los numeros aleatorios para ser comparados y se documenta si hay ganadores.
    private static void metodoPrincipal(Random random, int comprobarSorteo, int reintegroJugado,
                                  ArrayList<Integer> ganador, ArrayList<Integer> numerosGanador,
                                  ArrayList<Integer> numerosJugados){

        boolean compareReintegro;
        String resultadoReintegro;
        ArrayList<Integer> compareNumeros;
        String resultadoNumeros;
        int reintegroGanador;
        int todoCorrecto=0;
        int tresCorrectos=0;
        int cuatroCorrectos=0;
        int cincoCorrectos=0;
        int seisCorrectos=0;
        int sieteCorrectos=0;
        int reitegrosGanadores=0;
        String tGanador = "";
        String sieteAs = "";
        String seisAs = "";
        String cincoAs= "";
        String cuatroAs= "";
        String tresAs= "";
        String reintegroAs= "";

        ArrayList<Integer> ticketGanador = new ArrayList<>();
        ArrayList<Integer> sieteAciertos = new ArrayList<>();
        ArrayList<Integer> seisAciertos = new ArrayList<>();
        ArrayList<Integer> cincoAciertos = new ArrayList<>();
        ArrayList<Integer> cuatroAciertos = new ArrayList<>();
        ArrayList<Integer> tresaciertos = new ArrayList<>();

        if (comprobarSorteo>0){

            for(int i = 0 ; i < comprobarSorteo; i++){
                int comprobacionesLoop = i+1;
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

                // Funcion para calcular la cantidad de numeros acertados.
                if(compareNumeros.size()>6 && compareReintegro==true){
                    todoCorrecto++;
                    ticketGanador.add(comprobacionesLoop);
                } else if (compareNumeros.size()>6) {
                    sieteCorrectos++;
                    sieteAciertos.add(comprobacionesLoop);
                }else if (compareNumeros.size()>5 && compareNumeros.size()<7 ) {
                    seisCorrectos++;
                    seisAciertos.add(comprobacionesLoop);
                } else if (compareNumeros.size()>4 && compareNumeros.size()<6 ) {
                    cincoCorrectos++;
                    cincoAciertos.add(comprobacionesLoop);
                } else if (compareNumeros.size()>3 && compareNumeros.size()<5) {
                    cuatroCorrectos++;
                    cuatroAciertos.add(comprobacionesLoop);
                } else if (compareNumeros.size()>2 && compareNumeros.size()<4) {
                    tresCorrectos++;
                }
                if (compareReintegro==true) {
                    reitegrosGanadores++;
                }
                // Imprime cada resultado comparado
                System.out.println("\n*****************************\n*****************************\n" +
                        "\nSORTEO NUMERO: "+ comprobacionesLoop +"\n"+resultadoNumeros+"\n"+resultadoReintegro+
                        "\n\nNumeros jugado:    "+ numerosJugados +"\n Reintegro jugado:  "+ reintegroJugado +
                        "\nNumeros ganadores: "+ numerosGanador +"\n Reintegro ganador: "+reintegroGanador);
            }
        }
        else{
            System.out.println("Introduce un valor valido!!!");
        }
        // Guarda el numero del los tickets con mas de 3 aciertos.
        if(ticketGanador.size() > 0){
            tGanador="Has acertado todos los numeros y reintegro: " +todoCorrecto+ " vez/veces" +
                    "\nBoleto(s) con todos los numeros acertados es/son: "+ ticketGanador;
        }
        if(sieteAciertos.size() > 0){
            sieteAs="\nHas acertado los siete numeros: "+sieteCorrectos+" vez/veces"+
                    "\nBoleto(s) con 7 aciertos es/son: "+ sieteAciertos;
        }
        if(seisAciertos.size() > 0){
            seisAs="\nHas acertado seis numeros: "+seisCorrectos+" vez/veces"+
                    "\nBoleto(s) con 6 aciertos es/son: "+ seisAciertos;
        }
        if(cincoAciertos.size() > 0){
            cincoAs="\nHas acertado cinco numeros: "+cincoCorrectos+" vez/veces"+
                    "\nBoleto(s) con 5 aciertos es/son: "+ cincoAciertos;
        }
        if(cuatroAciertos.size() > 0){
            cuatroAs="\nHas acertado cuatro numeros: "+cuatroCorrectos+
                    " vez/veces\nBoleto(s) con 4 aciertos es/son: "+ cuatroAciertos;
        }
        if(cuatroAciertos.size() > 0){
            cuatroAs="\nHas acertado cuatro numeros: "+cuatroCorrectos+
                    " vez/veces\nBoleto(s) con 4 aciertos es/son: "+ cuatroAciertos;
        }
        if(tresaciertos.size() > 0){
            tresAs="\nHas acertado cuatro numeros: "+tresCorrectos;
        }
        if(reitegrosGanadores > 0) {
            reintegroAs = "\nAs acertado el reintegro: " + reitegrosGanadores+
                    " vez/veces";
        }


        // Imprime el resumen al final de los numeros acertados.
        System.out.println("\n***********************\nRESUMEN\n***********************\n" +
                tGanador + sieteAs+ seisAs + cincoAs + cuatroAs+ tresAs + reintegroAs);

    }


    // Metodo para generar numeros aleatorio.
    private static void extracted(Random random, ArrayList<Integer> ganador, ArrayList<Integer> numerosGanador){
            int y;
            int x;
            for (int i = 0; i < 7; ) {
                x = random.nextInt(49) + 1;

                // Revisar si hay repetidos
                if (!numerosGanador.contains(x)) {
                    i++;
                    // Agregar valor si no esta repetido
                    ganador.add(x);
                    numerosGanador.add(x);

                    // Ordenar numeros de < a >
                    Collections.sort(ganador);
                    Collections.sort(numerosGanador);
                    // Crear reintegro y agregar al final del Arraylist cuando los primeros 7 numeros estan guardados
                }
                if (i > 6) {
                    y = random.nextInt(9) + 1;
                    ganador.add(7, y);

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
        return resultadoNumeros ;

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
