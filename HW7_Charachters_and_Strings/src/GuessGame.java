import java.util.Random;
import java.util.Scanner;

public class GuessGame {

    private final String[] words;
    private final String guessedByComp;
    private StringBuilder userAns;

    public GuessGame(String...words){
        this.words = words.clone();
        guessedByComp = computerPicksWord();
        userAns = new StringBuilder("#".repeat(guessedByComp.length()));
    }

    private String computerPicksWord(){
        Random rnd = new Random();
        return words[rnd.nextInt(words.length)];
    }

    public String askUserToGuess() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Guess word");

        return sc.nextLine();
    }

    public void startGame(){

        String appendedAnswer;
        int lenToAppend = 15 - userAns.length();
        while(userAns.indexOf("#") > -1) {
            String userChoice = askUserToGuess();
            if (compareUserAnsToComp(userChoice)) {

                userAns = new StringBuilder(userChoice);
                System.out.println("You are right. Guessed word was: " + guessedByComp);
            } else if (analyzeUserAnswer(userChoice)) {
                System.out.println("You are right. Guessed word was: " + guessedByComp);
            } else {
                analyzeUserAnswer(userChoice);
                appendedAnswer = userAns+"#".repeat(lenToAppend);
                System.out.println(appendedAnswer);

            }
        }
    }

    private boolean analyzeUserAnswer(String userInput){

        for(char ch : userInput.toCharArray()){
            if (guessedByComp.indexOf(ch) != -1){
                copyGuessedChars(ch);
            }
        }

        return userAns.compareTo(new StringBuilder(guessedByComp)) == 0;

    }

    private void copyGuessedChars(char ch){

        for(int i = 0; i < guessedByComp.length(); i++){
            if(guessedByComp.charAt(i) == ch)
                userAns.replace(i, i+1, String.valueOf(ch));
        }
    }

    private boolean compareUserAnsToComp(String userChoice){

        return userChoice.equals(guessedByComp);
    }

    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame("apple", "orange", "lemon", "banana", "apricot", "avocado" ,
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", " pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato");
        guessGame.startGame();

    }
}
