import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void getWordCount(String string){

        Scanner scanner = new Scanner(string);
        int words = 0;

        while (scanner.hasNextLine()) {
            words++;
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }
        System.out.println("Количество слов: " + words);
        scanner.close();
    }

    public static Map<String, Long> getNumberOfIdenticalWords(List<String> stringList) {

        return stringList.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }
    public static <K extends Comparable, V> Map<K, V> sortByKeys(Map<K, V> map) {

        List<K> keys = new ArrayList<K>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());

        Map<K, V> linkedHashMap = new LinkedHashMap<>();

        ListIterator<K> itr = keys.listIterator();
        while (itr.hasNext())
        {
            K key = itr.next();
            linkedHashMap.put(key, map.get(key));
        }

        return linkedHashMap;
    }
    public static void main(String[] args) {

        System.out.println("Задача на функциональное программирование");


        String string = "your app the quick brown fox jumps over the lazy dog";

        List<String> words = new ArrayList<>();

        for (String s : string.split(" ")) {
            words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
            Collections.sort(words);
        }


        getWordCount(string);

        TreeMap<String, Long> frequency = new TreeMap<>(getNumberOfIdenticalWords(words));

        System.out.println(sortByKeys(frequency));




    }
}