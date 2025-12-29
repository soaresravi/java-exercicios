package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//quase uma documentação sobre listas

public class Program {
    
    public static void main(String[] args) {
        
        List<Double> list = new ArrayList<>();
        List<String> listNames = new ArrayList<>();
        
        list.add(1.1);
        list.add(7.3);
        list.add(5.0);
        list.add(9.4);
        list.add(2, 8.0);
        
        System.out.println("Full list: ");
        displayList(list);
        
        System.out.println("---------------------------");
        
        list.remove(Double.valueOf(5)); //remova o valor 5 da lista Double, não a posição
        list.remove(1);
        list.removeIf(x -> x % 2 != 0); //pode ser qualquer nome, nao precisa ser x ou ja existir
        
        System.out.println("Updated list (removed value 5, position 1 and odd numbers): ");
        displayList(list);
        
        System.out.println("---------------------------");
        
        listNames.add("maria");
        listNames.add("Márcio");
        listNames.add("Ravi");
        listNames.add(0, "Ludmilla");
        listNames.add("Lana Del Rey");
        
        System.out.println("Full list: ");
        displayListNames(listNames);
        
        System.out.println("---------------------------");
        
        String nameL = listNames.stream().filter(x -> x.charAt(0) == 'L').findFirst().orElse(null);
        // crio uma nova variável que pegue a lista convertida p/ stream e filtre ela com a operação que eu quero, pegando o primeiro nome que comece com L e se nao existir retornará nulo
        
        System.out.println("First name that starts with L: \n" + nameL);
        System.out.println("---------------------------");
        
        System.out.println("Index of Ravi: " + listNames.indexOf("Ravi"));
        System.out.println("---------------------------");
        
        List<String> namesM = listNames.stream().filter(x -> x.charAt(0) == 'M' || x.charAt(0) == 'm').collect(Collectors.toList());
        // crio uma nova lista que seja a lista original convertida p/ stream (aceita operações com expressões lâmbda), a partir dela chamo o filter pra fazer o que eu quero e ai volto pra lista 
        
        System.out.println("Names that start with M: ");
        
        for (String x : namesM) {
            System.out.println(x);
        }
        
        System.out.println("---------------------------");
        
        listNames.removeIf(x -> x.charAt(0) == 'M' || x.charAt(0) == 'm'); //remova se a posição 0 da palavra comece com M
        listNames.removeIf(x -> x.lastIndexOf('i') == (x.length() - 1)); //remova se no último aparecimento da letra i a posição seja a qtd de letras na palavra - 1 (pq começa com 0)
        
        System.out.println("Updated list (removed names starting with M, names that end with i): ");
        displayListNames(listNames);
    }
    
    public static void displayList(List<Double> list) {
        for (Double x : list) {
            System.out.println(x);
        }
    }
    
    public static void displayListNames(List<String> listNames) {
        for (String x : listNames) {
            System.out.println(x);
        }
    }
}
