package edu.project2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static int HEIGHT = 8;
    private final static int WIDTH = 8;
    private final static Coordinate FROM = new Coordinate(0, 0);
    private final static Coordinate TO = new Coordinate(WIDTH - 1, HEIGHT - 1);
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {

        var renderer = new MazePromptRenderer('█', ' ', '.');
        var maze = new RecursiveBacktrackingMazeGenerator().gen(WIDTH, HEIGHT);
        LOGGER.info("Создан лабиринт");
        renderer.render(maze, List.of());
        LOGGER.info("Нахождение маршрута");
        try {
            var path = new RecursiveBacktrackingMazeSolver().solve(maze, FROM, TO);
            renderer.render(maze, path);
        } catch (MazeException mazeException) {
            LOGGER.info(mazeException.getMessage());
        }
    }
}
