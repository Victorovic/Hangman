import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameService {
    private final List<String> masterDictionary;
    private List<String> gameDictionary;
    private final Random random = new Random();
    private Game currentGame;

    public GameService(List<String> masterDictionary) {
        this.masterDictionary = List.copyOf(masterDictionary);
        if (this.masterDictionary.isEmpty()) {
            throw new IllegalArgumentException("Master dictionary is empty");
        }
    }

    public Game startNewGame() {
        refillGameDictionaryIfNeeded();
        String secretWord = pickAndRemoveRandomWord();
        currentGame = new Game(secretWord);
        return currentGame;
    }

    public Game getGame() {
        if (currentGame == null || currentGame.isWon() || currentGame.isLost()) {
            return startNewGame();
        }
        return currentGame;
    }

    private void refillGameDictionaryIfNeeded() {
        if (gameDictionary == null || gameDictionary.isEmpty()) {
            gameDictionary = new ArrayList<>(masterDictionary);
            Collections.shuffle(gameDictionary);
        }
    }

    private String pickAndRemoveRandomWord() {
        return gameDictionary.remove(random.nextInt(gameDictionary.size()));
    }

}
