package spaceshapes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOval {

    private MockPainter _painter;

    /**
     * This method is called automatically by the JUnit test-runner immediately
     * before each @Test method is executed. setUp() recreates the fixture so
     * that there no side effects from running individual tests.
     */
    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    /**
     * Test to perform a simple (non-bouncing) movement, and to ensure that a
     * Shape's position after the movement is correct.
     */
    @Test
    public void testSimpleMove() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(_painter);
        shape.move(500, 500);
        shape.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)",
                _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffRight() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
                + "(oval 98,50,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the top boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTop(){
        OvalShape shape = new OvalShape(10,10,12,-15);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        assertEquals("(oval 10,10,25,35)(oval 22,0,25,35)" +
                "(oval 34,15,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottom(){
        OvalShape shape = new OvalShape(10,960,12,15);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(oval 10,960,25,35)(oval 22,965,25,35)" +
                "(oval 34,950,25,35)", _painter.toString());
    }


    /**
     * Test to perform a bounce movement off the left-most boundary and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffLeft() {
        OvalShape shape = new OvalShape(10, 20, -12, 15);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
                + "(oval 12,50,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom left corner and to
     * ensure that the Shape's position after the movement is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndLeft() {
        OvalShape shape = new OvalShape(10, 90, -12, 15);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
                + "(oval 12,85,25,35)", _painter.toString());
    }
}
