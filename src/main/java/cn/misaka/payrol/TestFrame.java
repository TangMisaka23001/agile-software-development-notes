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

}
