package edu.project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.project2.Coordinate.Direction.DOWN;
import static edu.project2.Coordinate.Direction.LEFT;
import static edu.project2.Coordinate.Direction.RIGHT;
import static edu.project2.Coordinate.Direction.UP;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

public class MazePromptRendererTest {
    MazePromptRenderer renderer;

    @BeforeEach
    void initRenderer() {
        this.renderer = new MazePromptRenderer('#', '.', 'X');
    }

    @DisplayName("Репрезентация прохода вверх-вправо")
    @Test
    void representationUpRight() {
        assertThat(renderer.representCell(Cell
            .fromDirection(UP)
            .addDirection(RIGHT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "#..",
                    "###"
                )
            );
    }

    @DisplayName("Репрезентация прохода вверх-вправо-влево")
    @Test
    void representationUpRightLeft() {
        assertThat(renderer.representCell(Cell
            .fromDirection(UP)
            .addDirection(RIGHT)
            .addDirection(LEFT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "...",
                    "###"
                )
            );
    }

    @DisplayName("Репрезентация прохода во все стороны")
    @Test
    void representationAllWay() {
        assertThat(renderer.representCell(Cell
            .fromDirection(UP)
            .addDirection(DOWN)
            .addDirection(RIGHT)
            .addDirection(LEFT)))
            .extracting(
                e -> tuple(
                    e.top(),
                    e.mid(),
                    e.bot()
                )
            ).isEqualTo(
                tuple(
                    "#.#",
                    "...",
                    "#.#"
                )
            );
    }
}
