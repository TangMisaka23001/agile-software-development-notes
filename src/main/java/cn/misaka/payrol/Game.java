package cn.misaka.payrol;

/**
 * Game
 *
 * @author tangbin
 */
public class Game {

    private int ball;
    private int firstThrow;
    private int secondThrow;

    private int itsScore = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrow = 0;
    private int itsCurrentFrame = 1;
    private boolean firstThrowInFrame = true;

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrowInFrame) {
            if (pins == 10) { // strike
                itsCurrentFrame++;
            } else {
                firstThrowInFrame = false;
            }
        } else {
            firstThrowInFrame = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame);
    }

    public int scoreForFrame(int frame) {
        ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            if (strike()) {
                score += 10 + nextTowBallsForStrike();
                ball++;
            } else if (spare()) {
                score += 10 + nextBallForSpare();
                ball += 2;
            } else {
                score += towBallsInFrame();
                ball += 2;
            }
        }
        return score;
    }

    private int nextTowBallsForStrike() {
        return itsThrows[ball + 1] + itsThrows[ball + 2];
    }

    private boolean strike() {
        return itsThrows[ball] == 10;
    }

    private int towBallsInFrame() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private int nextBallForSpare() {
        return itsThrows[ball + 2];
    }

    private boolean spare() {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10;
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }
}
