public class HelperBSTWordEntry implements Comparable<HelperBSTWordEntry>{
    private String name;
    private int frequency; 
    private HelperBST<HelperBSTNextWordEntry> nextWords;

    public HelperBSTWordEntry(String name){
        this.name = name;
        this.frequency = 1; 
        this.nextWords = new HelperBST<HelperBSTNextWordEntry>();
    }

    public String getName(){
        return name;
    }
    public int getFrequency(){
        return frequency;
    }
    public void incrementFrequency(){
        frequency++;
    }
    public HelperBST<HelperBSTNextWordEntry> getNextwords(){
        return nextWords;
    }


    // comparable contract 
    @Override 
    public int compareTo(HelperBSTWordEntry other){
        if(other == null) {
            throw new NullPointerException("cannot compare to null");
        }
        return this.name.compareTo(other.name);
    }
    // toString Methode 
    public String toString(){
        return name + "(" + frequency + ")" + " -> " + "[" + nextWords.toString() + "]";
    }

}
