package edu.project1;

import edu.project1.Players.ConsolePlayer;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) throws IOException {
        var game = new Game(
            new Dictionary(new HashSet<>(Set.of("engine", "system", "advertising",
                "department", "activity", "food", "control",
                "recipe", "emotion", "bathroom", "version"))),
            3,
            new ConsolePlayer()
        );
        game.run();

    }
}
