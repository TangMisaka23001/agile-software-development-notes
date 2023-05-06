package cn.misaka.payrol;

/**
 * Game
 *
 * @author tangbin
 */
public class Game {

    public int score() {
        return itsScore;
    }

    public void add(int pins) {
        itsScore += pins;
    }

    private int itsScore = 0;
}
