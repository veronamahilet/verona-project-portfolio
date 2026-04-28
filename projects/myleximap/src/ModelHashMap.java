import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ModelHashMap {
    private HashMap<String, HashMapHelper> words; 
    private long trainingTime; 
    private long searchingTime; 
    private int totalWords;

    public ModelHashMap(){
        words = new HashMap<String, HashMapHelper>();
        trainingTime = 0;
        searchingTime = 0;
        totalWords = 0;
    }

    //loadWords() function 
    public HashMap<String, HashMapHelper> loadWords(){
        // make sure it is reset before new tarining
        trainingTime = 0;
        // start the timer for training time calculation
        long start = System.nanoTime();
        // ...
        words.clear();
        String line;
        try(BufferedReader br = new BufferedReader( new FileReader("Data.txt"))){
             while((line = br.readLine()) != null){
                String[] linewords = line.trim().split("\\s+");
                for(int i = 0; i < linewords.length - 1; i++){
                    String FCleanwords = linewords[i].trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    String SCleanwords = linewords[i+1].trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!FCleanwords.isEmpty()){
                        if (!words.containsKey(FCleanwords)){
                            words.put(FCleanwords, new HashMapHelper());
                        } else {
                            words.get(FCleanwords).updateFrequence();
                        }
                        if (!SCleanwords.isEmpty()) {
                            words.get(FCleanwords).updateNextWord(SCleanwords);
                        }
                    } 
                }
             }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("An error occured while reading the file");
        }
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        trainingTime = trainingTime + (end - start); // convert to milliseconds
        // ...
        return words;
    }

    //getTotalWords() function 
    public int getTotalWords() {
        totalWords = 0;
        for (String Key : words.keySet()) {
            totalWords += words.get(Key).getFrequence();
        }
        // ...
        return totalWords;
    }

    //getUniqueWords() function
    public int getUniqueWords(){
        return words.size();
    }

    //getTrainingTime()
        public long getTrainingTime() {
        return trainingTime;
    }

    //getSearchingTime() 
    public long getSearchingTime(){
        return searchingTime;
    }

    // get suggestion 
    public HashMap<String, Integer> getSuggestions(String input) {
        searchingTime = 0;
        long start = System.nanoTime();

        HashMap<String, Integer> result;

        input = input.trim().toLowerCase().replaceAll("[^a-zA-Z]", "");

        if (words.containsKey(input)) {
            result = words.get(input).getNextWords();
        } else {
            result = new HashMap<String, Integer>();
        }

        long end = System.nanoTime();
        searchingTime = end - start; // nanoseconds

        return result;
    }
}
