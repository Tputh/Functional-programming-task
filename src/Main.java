import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


    public static List<Map.Entry<String, Integer>> getNumberOfIdenticalWords(String string) {
        Map<String, Integer> stringMap = new TreeMap<>();
        String[] words = string.split(" ");
        for (String word : words) {
            if (!stringMap.containsKey(word)) {
                stringMap.put(word, 1);
            } else {
                stringMap.put(word, stringMap.get(word) +1 );
            }
        }
        return stringMap.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        System.out.println("Задача на функциональное программирование");


        String string = "your app the quick brown fox jumps over the lazy dog";

        System.out.println(getNumberOfIdenticalWords(string).size());
        for (Map.Entry<String, Integer> numberOfIdenticalWord : getNumberOfIdenticalWords(string)) {
            System.out.println(numberOfIdenticalWord.getKey() + " " + numberOfIdenticalWord.getValue());
        }
    }
}