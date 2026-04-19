// comparator vs comparable in java - source: https://www.youtube.com/watch?v=ZA2oNhtNk3w
public class HelperBSTNextWordEntry implements Comparable<HelperBSTNextWordEntry> {
    private String nextWord;
    private int frequency;

    public HelperBSTNextWordEntry(String nextWord) {
        this.nextWord = nextWord;
        frequency = 1;
    }

    public String getNextWord(){
        return nextWord;
    }

    public int getFrequency(){
        return frequency;
    }

    public void incrementFrequency(){
         frequency++;
    }
    
    // compare entries by word only 
    @Override
    public int compareTo(HelperBSTNextWordEntry other){
        if (other == null) {
            throw new NullPointerException("cannot compare to null");
        }
        return this.nextWord.compareTo(other.nextWord);
    }

    @Override
    public String toString(){
        return nextWord + ":" + frequency;
    }
}
// ...implements Comparable<HelperBSTNextWordEntry>: An object of this class knows how to compare itself with another object of the same class
