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
     public void printWordsCount() throws IOException {
         Map<String,Integer> words = getCountWords();
        // Set<Map.Entry<String,Integer>> entryset = words.entrySet();
         for (Map.Entry<String,Integer> item:words.entrySet()) {
             System.out.println(item.getKey() + " - " + item.getValue());

         }
     }

    public static void main(String[] args) throws IOException{
        TaskThird taskThird = new TaskThird("words.txt");
        taskThird.printWordsCount();
    }

}
