package cn.misaka.payrol;

import junit.framework.TestCase;

/**
 * TestFrame
 *
 * @author tangbin
 */
public class TestFrame extends TestCase {

    public TestFrame(String name) {
        super(name);
    }

    public void testScoreNoThrows() {
        Frame f = new Frame();
        assertEquals(0, f.getScore());
    }

    public void testAddOneThrow() {
        Frame f = new Frame();
        f.add(5);
        assertEquals(5, f.getScore());
    }

    public void testOneThrows() {
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.score());
    }

    public void testTwoThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }

}
