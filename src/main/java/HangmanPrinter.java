import java.util.ArrayList;
import java.util.List;

public class HangmanPrinter {

    private static final String[] HANGMAN_STAGES = {
            """
     +---+
         |
         |
         |
        ===
  """,
            """
     +---+
     |   |
     O   |
         |
         |
    ======
""",
            """
     +---+
     |   |
     O   |
     |   |
         |
    ======
""",
            """
     +---+
     |   |
     O   |
    /|   |
         |
    ======
""",
            """
     +---+
     |   |
     O   |
    /|\\  |
         |
    ======
""",
            """
     +---+
     |   |
     O   |
    /|\\  |
    /    |
    ======
""",
            """
     +---+
     |   |
     O   |
    /|\\  |
    / \\  |
    ======
"""
    };

    public void print(int errorCount) {
        System.out.println(HANGMAN_STAGES[errorCount]);
    }

}
