import java.util.HashMap;

public class HashMapHelper {
    private int wordFrequence;
    private HashMap<String, Integer> nextWords;

    public HashMapHelper(){
        wordFrequence = 1;
        nextWords = new HashMap<String, Integer>();
    }

    public void updateFrequence() {
        wordFrequence += 1;
    }

    public int getFrequence() {
        return wordFrequence; 
    }

    public HashMap<String, Integer> getNextWords() {
        return nextWords;
    }

    public void updateNextWord(String nxtWrd){
        if (nextWords.containsKey(nxtWrd)){
            nextWords.put(nxtWrd, nextWords.get(nxtWrd) + 1);
        } else {
            nextWords.put(nxtWrd, 1);
        }
    }

    public String getNxtWrdToString(){
        StringBuilder result = new StringBuilder();
        for (String word : nextWords.keySet()) {
            result.append(word).append(":").append(nextWords.get(word)).append("\n");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "word frequence (" + wordFrequence + ") \n" +
                    getNxtWrdToString();
    }
}
