// read a file - bufferedReader : https://www.youtube.com/watch?v=eHjbvgw4hsI
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ModelList {
    private ArrayList<String> words;
    private long trainingTime; // in milliseconds
    private long searchingTime; // in milliseconds
    private int totalWords;
    private int uniqueWords;

    public ModelList(){
        words = new ArrayList<>();
        trainingTime = 0;
        searchingTime = 0;
        totalWords = 0;
        uniqueWords = 0;
    }
    
    // method to read the file and load the words into the list
    public ArrayList<String> loadWords() {
        // start the timer for training time calculation
        long start = System.nanoTime();
        // ...
        words.clear();
        try(BufferedReader br = new BufferedReader(new FileReader("Data.txt"))){
            System.out.println("List - File is being read...");
            String line;
            while((line = br.readLine()) != null){
                String[] lineswords = line.trim().split("\\s+");
                for (String word : lineswords){
                    String cleanword = word.trim().toLowerCase().replaceAll("[^a-zA-Z]", ""); // remove punctuation and convert to lowercase
                    if (!cleanword.isEmpty()) {
                        words.add(cleanword);
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");

        }
        catch(IOException e){
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        // update the total words count after loading the words
        totalWords = words.size();
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        trainingTime = trainingTime + (end - start)/1000000; // convert to milliseconds
        // ...
        return words;
    }

    // method to get the unique words from the list
    public ArrayList<String> getUniqueWords(){
        // HashSet<String> uniqueWordsSet = new HashSet<>();
        // for (String word : words){
        //     uniqueWordsSet.add(word);
        // }: HashSet was perfect only my code need to be special ArrayList - unique words = distinc word != non-repetitve word 
        // start the timer for tarining time calculation
        long start = System.nanoTime();
        // ...
        ArrayList<String> uniqueWordsSet = new ArrayList<>();
        for (String word: words){
            if (!uniqueWordsSet.contains(word)){
                uniqueWordsSet.add(word);
            }
        }
        // ...
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        trainingTime += (end - start)/1000000; // convert to milliseconds
        // ...
        return new ArrayList<>(uniqueWordsSet);
    }

    // method to count the unique words in the list
    public int countUniqueWords(){
        ArrayList<String> unqWrd = getUniqueWords();
        uniqueWords = unqWrd.size();
        return uniqueWords;
    }

    // method to get the total number of words in the list
    public int getTotalWords(){
        return totalWords;
    }

    // methode to get Suggestions 
    public ArrayList<String> getSuggestions(String input) {
        // start the timer for searching time calculation
        long start = System.nanoTime();
        // ...
        String cleanInput = input.trim().toLowerCase();
        ArrayList<String> suggestions = new ArrayList<>();
        for (int i = 0; i < ( words.size() - 1); i++){
            if (words.get(i).equals(cleanInput)){
                if (!suggestions.contains(words.get(i+1))){
                    suggestions.add(words.get(i+1)); // add the next word to the suggestions list
                }
            }
        }
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        searchingTime += (end - start)/1000000; // convert to milliseconds
        // ...
        return suggestions;
    }
    
    // method to count the occurrences of a word in the list
    public int countWordOccurrences(String input) {
        // start the timer for searching time calculation
        long start = System.nanoTime();
        // ...
        int count = 0;
        String cleanInput = input.trim().toLowerCase();
        for (String word : words) {
            if (word.equals(cleanInput)) {
                count++;
            }
        }
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        searchingTime += (end - start)/1000000; // convert to milliseconds
        // ...
        return count;

    }

    public long getTrainingTime(){
        return trainingTime;
    }
    public long getSearchingTime(){
        return searchingTime;
    }
}
// training-related methode: loadWords(), getUniqueWords(), countUniqueWords(), getTotalWords()
// searching-related methode: getSuggestions(), countWordOccurrences()
// time complexity:
// _loadWords()
//  single add() = O(1) amortized time complexity
//  total loading process = O(n) where n is the total number of words in the file or O(n*m) where n is the number of lines and m is the average number of words per line {or O(n)}
// _getUniqueWords()
//  conains() inside a loop = O(n) where n is the number of unique words in the list
//  total process = O(n^2) where n is the number of unique words in the list {It performs two linear traversal of the words ArrayList, so its time complexity is O(n^2).}
// _getSuggestions()
//  scan through words = O(n)
//  suggestion.contains(...) add another linear check = O(n) in worst case
//  total process = O(n^2) where n is the number of words in the list {It performs two linear traversal of the words ArrayList, so its time complexity is O(n^2).}
// _countWordOccurrences()
//  scan through words = O(n) 
// overall The ArrayList-based model has mixed complexities, with linear-time operations for basic scans and quadratic-time operations for duplicate detection and suggestion generation.
