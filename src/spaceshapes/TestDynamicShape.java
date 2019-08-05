package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class TestDynamicShape {
    // Fixture object that is used by the tests.
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
     * Test to perform a bounce movement off the top boundary and to
     * ensure that the Shape's position and appearance after the movement
     * is correct.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffTop(){
        DynamicRectangleShape shape = new DynamicRectangleShape(10,10,12,-15);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 10,10,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 22,0,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 34,15,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom boundary and to
     * ensure that the Shape's position and appearance after the movement is
     * correct.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffBottom(){
        DynamicRectangleShape shape = new DynamicRectangleShape(10,960,12,15);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 10,960,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 22,965,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 34,950,25,35)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the right-most boundary
     * and to ensure that the Shape's position and appearance after the
     * movement is correct.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 20, 12, 15);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 100,20,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 110,35,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 98,50,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the left-most boundary
     * and to ensure that the Shape's position and appearance after the
     * movement is correct.
     */
    @Test
    public void testDynamicShapeMoveWithBounceOffLeft(){
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 90, -12, 15, Color.red);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 10,90,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=0,b=0] set as color)(rectangle 0,100,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=0,b=0] set as color)(rectangle 12,85,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());

    }

    /**
     * Test to perform a bounce movement off the bottom left corner and to
     * ensure that the Shape's position and appearance after the movement
     * is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 90, -12, 15,Color.blue);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 10,90,25,35)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=0,g=0,b=255] set as color)(rectangle 0,100,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=0,g=0,b=255] set as color)(rectangle 12,85,25,35 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Shape's position and appearance after the movement
     * is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(90, 90, 12, 15,50,50,Color.green);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 90,90,50,50)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=0,g=255,b=0] set as color)(rectangle 100,100,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=0,g=255,b=0] set as color)(rectangle 88,85,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Shape's position and appearance after the movement
     * is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTopAndRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(90, 10, 12, -15,50,50);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 90,10,50,50)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 100,0,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 88,15,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());
    }

    /**
     * Test to perform a bounce movement off the bottom right corner and to
     * ensure that the Shape's position and appearance after the movement
     * is correct.
     */
    @Test
    public void testShapeMoveWithBounceOffTopAndLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(10, 10, -20, -20,50,50);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        assertEquals("(current color: java.awt.Color[r=212,g=212,b=212])(rectangle 10,10,50,50)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 0,0,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)" +
                "(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(java.awt.Color[r=255,g=255,b=255] set as color)(rectangle 20,20,50,50 filled)" +
                "(java.awt.Color[r=212,g=212,b=212] set as color)", _painter.toString());
    }
}
