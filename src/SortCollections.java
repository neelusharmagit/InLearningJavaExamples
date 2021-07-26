import model.Fruits;

import java.util.*;
import java.util.stream.Collectors;

public class SortCollections {

    public static void main(String[] args)
    {
        sortListElements();

        sortListObject();

        sortHashmapByKey();

        sortHashmapByValue();
    }


    public static void sortListElements(){
        // Create a list of strings
        ArrayList<String> al = new ArrayList<String>();
        al.add("Ross");
        al.add("Rachel");
        al.add("Monica");
        al.add("Phoebe");
        al.add("Chandler");

        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al);


        // Let us print the sorted list
        System.out.println("List after the use of" +
                " Collection.sort() :\n" + al);


    List li =  al.stream().sorted().collect(Collectors.toList());

        System.out.println("List after the use of" +
                " Collection.sort() :\n" + li);
    }


    public static void sortListObject(){
        // Create a list of strings
        ArrayList<Fruits> al = new ArrayList<Fruits>();
        al.add(new Fruits("Mango",66.00));
        al.add(new Fruits("Banana",55.00));
        al.add(new Fruits("Peach",77.00));
        al.add(new Fruits("Apple",93.00));


        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(al, Comparator.comparing(Fruits::getPrice));

        // Let us print the sorted list
       al.forEach(e-> System.out.println(e.getName()));

    }


    public static void sortHashmapByKey(){
        Map<String, Integer> namesAges = new HashMap<>();

        // storing the values
        namesAges.put("Apple", 90);
        namesAges.put("Mango", 70);
        namesAges.put("Banana", 20);
        namesAges.put("Grapes", 40);

        Map<String, Integer> sortByValueMap = namesAges.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        System.out.println("HashMap before sorting by KEY - " + namesAges);
        System.out.println("HashMap after sorting by KEY - " + sortByValueMap);
    }



    public static void sortHashmapByValue(){
        Map<String, Integer> namesAges = new HashMap<>();

        // storing the values
        namesAges.put("Apple", 90);
        namesAges.put("Mango", 70);
        namesAges.put("Banana", 20);
        namesAges.put("Grapes", 40);


        Map<String, Integer> sortByValueMap = namesAges.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),
                        (entry1, entry2) -> entry2, LinkedHashMap::new));

        System.out.println("HashMap before sorting by value - " + namesAges);
        System.out.println("HashMap after sorting by value - " + sortByValueMap);
    }
}
