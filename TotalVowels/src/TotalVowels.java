import Costum.MyList;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class TotalVowels {
    public static void main(String[] args) {

        ArrayList<String> vowels = new ArrayList<>();
        vowels.add("Hello");
        vowels.add("there");
        vowels.add("what");
        vowels.add("is");
        vowels.add("your");
        vowels.add("name");

        Map<String, String> uMap = new HashMap<>();
        uMap.put("keanu", "reeves");
        uMap.put("reanu", "keeves");
        uMap.put("jeanu", "teeves");
        uMap.put("seanu", "meeves");
        uMap.put("peanu", "reeves");


        //totalVowels(vowels);

        //countUniques();

        //minLength(vowels);

        //removeOddLength(vowels);

        //contains3();

        isUnique(uMap);

    }
    public static void totalVowels(ArrayList<String> vowels){
        int count = 0;
        for (int i = 0; i < vowels.size(); i++) {
            String lowerCaseWord = vowels.get(i).toLowerCase(); //get lowercase version so we don't have to check each letter twice

            for (int j=0; j<lowerCaseWord.length(); j++) {  //loop through each char in the string
                char c = lowerCaseWord.charAt(j);
                if (c == 'a') count++;
                else if (c == 'e') count++;
                else if (c == 'i') count++;
                else if (c == 'o') count++;
                else if (c == 'u') count++;
            }
        }
            System.out.println("Number of vowels: " + count);

    }

    public static void countUniques(){
        List<String> numbers = Arrays.asList("3", "7", "3", "-1", "2", "3", "7", "2", "15", "15");
                Set<String> uniqueNumbers = new HashSet<String>(numbers);
        System.out.println("Unique number count: " + uniqueNumbers.size());

    }

    public static void minLength(ArrayList<String> vowels){
        String shortest = vowels.get(0);

        for(String str : vowels) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        System.out.println("The shortest string: " + shortest);
    }

    public static List<String> removeOddLength(List<String> vowels){

        vowels.stream()
                .filter(s -> s.length() % 2 == 0)
                .forEach(s -> System.out.print(s + " "));
        return vowels;
    }

    /*public static boolean contains3(){

        Map<Integer, String> containMap = new HashMap<>();
        containMap.put(1, "Hello");
        containMap.put(2, "there");
        containMap.put(3, "whats");
        containMap.put(4, "up");

        if (containMap.containsValue())

    }*/

    /*public static <K, V> boolean isUnique(Map<K, V> input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        Set<V> set = new HashSet<>();
        for (V value : input.values()) {
            set.add(value);
        }
        return set.size() == input.size();
    }*/

    public static boolean isUnique(Map<String, String> input) {
        Set<String> uniqueValues = new HashSet<>();
        for (String value : input.values()) {
            if (uniqueValues.contains(value)) {
                return false;
            }
            uniqueValues.add(value);
        }
        return true;
    }

}
