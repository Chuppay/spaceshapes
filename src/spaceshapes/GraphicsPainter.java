package spaceshapes;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import java.awt.FontMetrics;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 *
 * @author Paramvir Singh (Original Author - Ian Warren)
 *
 */
public class GraphicsPainter implements Painter {
    // Delegate object.
    private Graphics _g;

    /**
     * Creates a GraphicsPainter object and sets its Graphics delegate.
     */
    public GraphicsPainter(Graphics g) {
        this._g = g;
        _g.setColor(new Color(212, 212, 212));
        _g.setFont(new Font("Serif" , 0, 18));
    }

    @Override
    /**
     * @see spaceshapes.Painter.drawRect
     */
    public void drawRect(int x, int y, int width, int height) {
        _g.drawRect(x, y, width, height);
    }

    @Override
    /**
     * @see spaceshapes.Painter.drawOval
     */
    public void drawOval(int x, int y, int width, int height) {
        _g.drawOval(x, y, width, height);
    }

    @Override
    /**
     * @see spaceshapes.Painter.drawLine
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        _g.drawLine(x1, y1, x2, y2);
    }

    @Override
    /**
     * @see spaceshapes.Painter.drawHexagon
     */
    public void drawHexagon(int x, int y, int width, int height) {
        _g.drawLine(x,y + height/2, x+20, y);
        _g.drawLine(x+20, y, x+width-20, y);
        _g.drawLine(x+width-20, y, x+width,y + height/2);
        _g.drawLine(x+width,y + height/2, x+width-20, y+height);
        _g.drawLine(x+width-20, y+height, x+20, y+height);
        _g.drawLine(x+20, y+height,x,y + height/2);
    }

    @Override
    /**
     * @see spaceshapes.Painter.drawDiamond
     */
    public void drawDiamond(int x, int y, int width, int height) {
        _g.drawLine(x,y + height/2,x+width/2, y);
        _g.drawLine(x+width/2, y, x+width,y + height/2);
        _g.drawLine(x+width,y + height/2, x+width/2, y+height);
        _g.drawLine(x+width/2, y+height, x,y + height/2);

    }

    @Override
    /**
     * @see spaceshapes.Painter.fillRect
     */
    public void fillRect(int x, int y, int width, int height) {
        _g.fillRect(x, y, width, height);
    }

    @Override
    /**
     * @see spaceshapes.Painter.getColor
     */
    public Color getColor() {
        return _g.getColor();
    }

    @Override
    /**
     * @see spaceshapes.Painter.setColor
     */
    public void setColor(Color c) {
        if (c == null) {
            Color defaultColor = new Color (255,255,255);
            _g.setColor(defaultColor);
        } else {
            _g.setColor(c);
        }
    }

    @Override
    /**
     * @see spaceshapes.Painter.printImage
     */
    public void drawImage(Image image, int x, int y, int width, int height) {
        _g.drawImage(image, x, y, width, height, null);
    }

    @Override
    public void translate(int x, int y) {
        _g.translate(x,y);
    }

    @Override
    public void drawCentredText(String text, int x, int y, int width, int height) {
        FontMetrics fontMetrics = _g.getFontMetrics();
        int ascent=fontMetrics.getAscent();
        int descent=fontMetrics.getDescent();
        int twoTimesAdjustment =ascent-descent;

        int xCoord = x +(width - fontMetrics.stringWidth(text))/2;
        int yCoord = y + (height+twoTimesAdjustment)/2;

        _g.drawString(text,xCoord,yCoord);
    }
}


