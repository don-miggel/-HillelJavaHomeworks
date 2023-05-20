import java.util.Objects;

public class Occurance {
    private int numOccur;
    private String word;

    public Occurance(int numOccur, String word){
        this.numOccur = numOccur;
        this.word = word;
    }

    public int getNumOccur() {
        return numOccur;
    }

    public void setNumOccur(int numOccur) {
        this.numOccur = numOccur;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Occurance)) return false;
        Occurance occurance = (Occurance) o;
        return numOccur == occurance.numOccur && Objects.equals(word, occurance.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOccur, word);
    }

    @Override
    public String toString() {
        return "Occurance{" +
                "numOccur=" + numOccur +
                ", word='" + word + '\'' +
                '}';
    }
}
