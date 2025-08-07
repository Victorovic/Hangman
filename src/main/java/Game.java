import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Game {
    private final String secretWord;
    private final char[] secretChars;
    private final char[] mask;
    private int missCount = 0;
    private static final int MAX_ERRORS = 6;
    private final Set<Character> guessedLetters = new HashSet<>();


    public Game(String secretWord) {
        this.secretWord = secretWord;
        this.secretChars = secretWord.toLowerCase().toCharArray();
        mask = new char[secretChars.length];
        Arrays.fill(mask, '_');
    }

    public boolean guess(char letter) {
        char normalizedGuess = Character.toLowerCase(letter);
        if (!guessedLetters.add(normalizedGuess)) {
            return false;
        }
        boolean found = false;
        for (int i = 0; i < secretChars.length; i++) {
            if (secretChars[i] == normalizedGuess) {
                mask[i] = normalizedGuess;
                found = true;
            }
        }

        if (!found) {
            missCount++;
        }
        return found;
    }

    public String getMaskedWord() {
        return new String(mask);
    }

    public boolean isWon() {
        for (char c : mask) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public boolean isLost() {
        return missCount >= MAX_ERRORS;
    }

    public int getMissCount() {
        return missCount;
    }

    public int getMaxErrors() {
        return MAX_ERRORS;
    }

    public String getSecretWord() {
        return secretWord;
    }
}
