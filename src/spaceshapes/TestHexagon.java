package spaceshapes;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestHexagon {
    private MockPainter _painter;

    @Before
    public void setUp() {
        _painter = new MockPainter();
    }

    @Test
    public void testSimpleDiamondMove(){
        GemShape shape = new GemShape(100,100,5,5);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(diamond 100,100,25,35)" +
                "(line 100,117,112,100)" +
                "(line 112,100,125,117)" +
                "(line 125,117,112,135)" +
                "(line 112,135,100,117)" +
                // lines of diamond after move
                "(diamond 105,105,25,35)" +
                "(line 105,122,117,105)" +
                "(line 117,105,130,122)" +
                "(line 130,122,117,140)" +
                "(line 117,140,105,122)",_painter.toString());
    }

    @Test
    public void testSimpleHexagonMove(){
        GemShape shape = new GemShape(100,100,5,5,50,50);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(hexagon 100,100,50,50)" +
                "(line 100,125,120,100)" +
                "(line 120,100,130,100)" +
                "(line 130,100,150,125)" +
                "(line 150,125,130,150)" +
                "(line 130,150,120,150)" +
                "(line 120,150,100,125)" +
                // lines of hexagon after move
                "(hexagon 105,105,50,50)" +
                "(line 105,130,125,105)" +
                "(line 125,105,135,105)" +
                "(line 135,105,155,130)" +
                "(line 155,130,135,155)" +
                "(line 135,155,125,155)" +
                "(line 125,155,105,130)",_painter.toString());
    }

    @Test
    public void testDiamondShapeMoveWithBounceOffLeft() {
        GemShape shape = new GemShape(10, 20, -12, 15);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(diamond 10,20,25,35)" +
                "(line 10,37,22,20)" +
                "(line 22,20,35,37)" +
                "(line 35,37,22,55)" +
                "(line 22,55,10,37)" +
                "(diamond 0,35,25,35)" +
                "(line 0,52,12,35)" +
                "(line 12,35,25,52)" +
                "(line 25,52,12,70)" +
                "(line 12,70,0,52)" +
                "(diamond 12,50,25,35)" +
                "(line 12,67,24,50)" +
                "(line 24,50,37,67)" +
                "(line 37,67,24,85)" +
                "(line 24,85,12,67)", _painter.toString());
    }

    @Test
    public void testHexagonShapeMoveWithBounceOffLeft() {
        GemShape shape = new GemShape(10, 20, -12, 15,50,50);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(hexagon 10,20,50,50)" +
                "(line 10,45,30,20)" +
                "(line 30,20,40,20)" +
                "(line 40,20,60,45)" +
                "(line 60,45,40,70)" +
                "(line 40,70,30,70)" +
                "(line 30,70,10,45)" +
                "(hexagon 0,35,50,50)" +
                "(line 0,60,20,35)" +
                "(line 20,35,30,35)" +
                "(line 30,35,50,60)" +
                "(line 50,60,30,85)" +
                "(line 30,85,20,85)" +
                "(line 20,85,0,60)" +
                "(hexagon 12,50,50,50)" +
                "(line 12,75,32,50)" +
                "(line 32,50,42,50)" +
                "(line 42,50,62,75)" +
                "(line 62,75,42,100)" +
                "(line 42,100,32,100)" +
                "(line 32,100,12,75)", _painter.toString());
    }

    @Test
    public void testDiamondShapeMoveWithBounceOffTop(){
        GemShape shape = new GemShape(10,10,12,-15);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        assertEquals("(diamond 10,10,25,35)" +
                "(line 10,27,22,10)" +
                "(line 22,10,35,27)" +
                "(line 35,27,22,45)" +
                "(line 22,45,10,27)" +
                "(diamond 22,0,25,35)" +
                "(line 22,17,34,0)" +
                "(line 34,0,47,17)" +
                "(line 47,17,34,35)" +
                "(line 34,35,22,17)" +
                "(diamond 34,15,25,35)" +
                "(line 34,32,46,15)" +
                "(line 46,15,59,32)" +
                "(line 59,32,46,50)" +
                "(line 46,50,34,32)", _painter.toString());
    }

    @Test
    public void testHexagonShapeMoveWithBounceOffTop(){
        GemShape shape = new GemShape(10,10,12,-15,50,50);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        shape.move(10000,10000);
        shape.paint(_painter);
        assertEquals("(hexagon 10,10,50,50)" +
                "(line 10,35,30,10)" +
                "(line 30,10,40,10)" +
                "(line 40,10,60,35)" +
                "(line 60,35,40,60)" +
                "(line 40,60,30,60)" +
                "(line 30,60,10,35)" +
                "(hexagon 22,0,50,50)" +
                "(line 22,25,42,0)" +
                "(line 42,0,52,0)" +
                "(line 52,0,72,25)" +
                "(line 72,25,52,50)" +
                "(line 52,50,42,50)" +
                "(line 42,50,22,25)" +
                "(hexagon 34,15,50,50)" +
                "(line 34,40,54,15)" +
                "(line 54,15,64,15)" +
                "(line 64,15,84,40)" +
                "(line 84,40,64,65)" +
                "(line 64,65,54,65)" +
                "(line 54,65,34,40)", _painter.toString());
    }

    @Test
    public void testDiamondShapeMoveWithBounceOffBottomAndLeft() {
        GemShape shape = new GemShape(10, 90, -12, 15);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(diamond 10,90,25,35)" +
                "(line 10,107,22,90)" +
                "(line 22,90,35,107)" +
                "(line 35,107,22,125)" +
                "(line 22,125,10,107)" +
                // lines of diamond after 1st move
                "(diamond 0,100,25,35)" +
                "(line 0,117,12,100)" +
                "(line 12,100,25,117)" +
                "(line 25,117,12,135)" +
                "(line 12,135,0,117)" +
                // lines of diamond after 2nd move
                "(diamond 12,85,25,35)" +
                "(line 12,102,24,85)" +
                "(line 24,85,37,102)" +
                "(line 37,102,24,120)" +
                "(line 24,120,12,102)", _painter.toString());
    }

    @Test
    public void testHexagonShapeMoveWithBounceOffBottomAndLeft() {
        GemShape shape = new GemShape(90, 90, -12, 15,50,50);
        shape.paint(_painter);
        shape.move(145, 145);
        shape.paint(_painter);
        shape.move(145, 145);
        shape.paint(_painter);
        assertEquals("(hexagon 90,90,50,50)" +
                "(line 90,115,110,90)" +
                "(line 110,90,120,90)" +
                "(line 120,90,140,115)" +
                "(line 140,115,120,140)" +
                "(line 120,140,110,140)" +
                "(line 110,140,90,115)" +
                // lines of hexagon after 1st move
                "(hexagon 78,95,50,50)" +
                "(line 78,120,98,95)" +
                "(line 98,95,108,95)" +
                "(line 108,95,128,120)" +
                "(line 128,120,108,145)" +
                "(line 108,145,98,145)" +
                "(line 98,145,78,120)" +
                // lines of hexagon after 2nd move
                "(hexagon 66,80,50,50)" +
                "(line 66,105,86,80)" +
                "(line 86,80,96,80)" +
                "(line 96,80,116,105)" +
                "(line 116,105,96,130)" +
                "(line 96,130,86,130)" +
                "(line 86,130,66,105)", _painter.toString());
    }
}
