import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ModelBST {
    private HelperBST<HelperBSTWordEntry> words;
    private long trainingTime; 
    private long searchingTime; 
    private int totalWords;
    // private int uniqueWords;  the initialization is not necessary here

    public ModelBST(){
        this.words = new HelperBST<HelperBSTWordEntry>();
        trainingTime = 0;
        searchingTime = 0;
        totalWords = 0;
        // uniqueWords = 0;
    }

    public HelperBST<HelperBSTWordEntry> loadWords(){
        // start the timer for training time calculation
        long start = System.nanoTime();
        // ...
        words.clear();
        // int countFrequency = 0; // will be use to caluclate the amount of words
        // int occurence = 0; 
        try (BufferedReader br = new BufferedReader( new FileReader("Data.txt"))) {
            System.out.println("BST - File is being read...");
            String line;
            while ((line = br.readLine()) != null){
                String[] linewords = line.trim().split("\\s+");
                for (int i = 0; i < linewords.length - 1; i++) {
                    // creat two clean words, one for the first entry and another for the second entry
                    String FCleanwords = linewords[i].trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    String SCleanwords;
                    SCleanwords = linewords[i+1].trim().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    
                    // define the entry 
                    HelperBSTWordEntry FEntry = null;
                    HelperBSTNextWordEntry SEntry = null;
                    // turn the string into HelperBSTWordEntry or HelperBSTnextWordEntryobject 
                    if (!FCleanwords.isEmpty()){
                        FEntry = new HelperBSTWordEntry(FCleanwords);
                    }
                    if(!SCleanwords.isEmpty()){
                        SEntry = new HelperBSTNextWordEntry(SCleanwords);
                    }
                    if (FEntry != null && SEntry != null){
                        InsertNode(FEntry, SEntry);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        } catch(IOException e) {
            System.out.println("An error occurred while raeding the file");
        }
        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        trainingTime = trainingTime + (end - start)/1000000; // convert to milliseconds
        // ...
        return words;
    }

    // update and get totalWords
    public void updateTotalWord() { 
        // start the timer for tarining time calculation
        long start = System.nanoTime();
        // ...

        // get number of total of frequence 
        int total = 0;
        for (HelperBSTWordEntry node : words) {
            total += node.getFrequency();
        }
        totalWords = total;

        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        trainingTime = trainingTime + (end - start)/1000000; // convert to milliseconds
        // ...
    }
    public int getTotalWords() {
        updateTotalWord();
        return totalWords;
    }

    // update and get unique 
    public int getUniqueWords() {
        // // start the timer for tarining time calculation
        // long start = System.nanoTime();
        // // ...
        
        return words.size(); // the BST is too fast to calculate the elapse time in nano second

        // // end the timer & calculate the elapsed time
        // long end = System.nanoTime();
        // trainingTime = trainingTime + (end - start)/1000000; // convert to milliseconds
        // // ...
    }

    public HelperBST<HelperBSTNextWordEntry> getSuggestions(String input) { // it's not real a nextword but next word class has the right structure name and frquences to stode my suggestion data name and frequences.
        // start the timer for searching time calculation
        long start = System.nanoTime();
        // ...
        
        HelperBST<HelperBSTNextWordEntry> suggestion = new HelperBST<HelperBSTNextWordEntry>();
        HelperBSTWordEntry Fnode;
        HelperBST<HelperBSTNextWordEntry> Snode;
        // turn String input into a HelperBSTWordEntry object 
        HelperBSTWordEntry parseInput = new HelperBSTWordEntry(input.trim().toLowerCase());
        Fnode = words.get(parseInput);
        if (Fnode != null) {
            Snode = Fnode.getNextwords();
            for (HelperBSTNextWordEntry object : Snode) {
                suggestion.insert(object);
            }
        }

        // end the timer & calculate the elapsed time
        long end = System.nanoTime();
        searchingTime += (end - start)/1000000; // convert to milliseconds
        // ...
        return suggestion;
    }

    public long getTrainingTime() {
        return trainingTime;
    }
    public long getSearchingTime(){
        return searchingTime;
    }




    // =========================== Helper ===================================
    private void InsertNode(HelperBSTWordEntry crnt, HelperBSTNextWordEntry nxt){
        String crntStatus;
        String nxtStatus;
        String status; 
        // try to get Fnode is not it will return null.
        HelperBSTWordEntry Fnode = words.get(crnt); 
        HelperBSTNextWordEntry Snode;
        if (Fnode == null) {
            // insert the object (node) crnt in the main BST
            words.insert(crnt);
            crntStatus = crnt + " has been inserted"; 
            Fnode = words.get(crnt);            
        } else {
            crntStatus = crnt + " already exist";
            // since the object exist just increment its frequence only
            Fnode.incrementFrequency();            
            // since that we know for sure crnt node exist that mean he have at least as you wrote the is statement above. so set isnxt true
            //----
        }
        // -- Check either the nxt-object already exist in the crnt-BST-tree  
        Snode = Fnode.getNextwords().get(nxt);
        if (Snode == null) {
            // insert the nxt-object insinde the BST of the crnt-object or (crnt-node)
            Fnode.getNextwords().insert(nxt);
            nxtStatus = nxt + " has been inserted";
        } else {
            Snode.incrementFrequency();
            nxtStatus = nxt + " already exist";
        }
        status = "Status: " + nxtStatus + " & " + crntStatus;
        System.out.println(status); 
    }

}

