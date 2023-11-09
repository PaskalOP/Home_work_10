import java.io.File;
import java.io.IOException;
import java.util.*;

public class TaskThird {
    private String fileName;

    public TaskThird(String fileName) {
        this.fileName = fileName;
    }
     private String [] getWorlds() throws IOException {
         ArrayList<String> worlds = new ArrayList<>();
        File file = new File(fileName);
         Scanner sc = new Scanner(file);
         while (sc.hasNext()){
             String [] str = sc.nextLine().split("\\s+");
             worlds.addAll(Arrays.asList(str));
         }
         return worlds.toArray(String[]::new);
     }
     private Map<String,Integer> getCountWords () throws IOException{
         Map<String,Integer> wordsCount = new HashMap<>();
         for (String word: getWorlds()) {
             if(wordsCount.containsKey(word)){
                 Integer value = wordsCount.get(word);
                 value++;
                 wordsCount.put (word,value);
             }
             else wordsCount.put (word,1);
         }
         return wordsCount;
     }
     private List <Map.Entry<String,Integer>> sortMap(Map<String,Integer> wordsCount){
         List<Map.Entry<String,Integer>> sortedSetEnrty = new ArrayList<>(wordsCount.entrySet());
         Comparator<Map.Entry<String, Integer>> cp = new Comparator<Map.Entry<String, Integer>>() {
             @Override
             public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                 return o2.getValue().compareTo(o1.getValue());
             }
         };
         Collections.sort(sortedSetEnrty,cp);
         return sortedSetEnrty;
     }
     public void printWordsCount() throws IOException {
         Map<String,Integer> words = getCountWords();
         List <Map.Entry<String,Integer>> sortedList = sortMap(words);
         for (Map.Entry<String,Integer> item:sortedList) {
             System.out.println(item.getKey() + " - " + item.getValue());
         }
     }

    public static void main(String[] args) throws IOException{
        TaskThird taskThird = new TaskThird("words.txt");
        taskThird.printWordsCount();
    }

}
