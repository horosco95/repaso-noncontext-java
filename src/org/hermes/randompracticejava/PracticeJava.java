package org.hermes.randompracticejava;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeJava {

	public static void main(String args[]) {

        //Estos son ejemplos que se recomiendan ser ejecutados por separado

        //Example 1    
		System.out.print("CAFE".chars()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("+", ">", "=")));
		
        //Example 2
        List<String> armas = Arrays.asList("Hacha", "Lanza", "Espada");
        List<String> materiales = Arrays.asList("Piedra", "Metal", "Diamante", "Adamantium");
        List<List<String>> productoCartesiano = armas.stream()
                .flatMap(arma -> materiales.stream()
                        .map(Arrays::asList))
                .collect(Collectors.toList()); // se arma una lista compuesta por sublistas de 2 elementos
        
        //Example 3
        String cadena = "Keep It Simple Sweetheart";
        String resultS = Arrays.stream(cadena.split(" "))
                .reduce("", (fullWord, word) -> fullWord + word.charAt(0));
        System.out.println("\n"+resultS);
        
        //Example 4
        int param = 8;
        int result = IntStream.rangeClosed(1, param/2)
                .filter( num -> param % num == 0) //Se eliminan todo num que NO cumpla la condicion
                .sum();
           /*     .forEach(System.out::println); */
        System.out.println(result);
        
        //Example 5
        Map<String, String> valores = Collections.singletonMap("OnlyKey", "Value");
        /*
        Stream.of("OnlyKey", "AnotherKey")
                      .map(valores::get)
                      .map(new Optional::ofNullable) //Hay error en esta linea - Segun consigna
                      .map(optional -> optional.orElse("Not Found"))
                      .forEach(System.out::println);
		*/
	}
}