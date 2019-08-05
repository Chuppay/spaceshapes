package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Interface to represent a type that offers primitive drawing methods.
 *
 * @author Paramvir Singh (Original Author - Ian Warren)
 *
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);

	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);

	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);

	/**
	 * Draws a hexagon. Parameters x and y specify the top left corner of the 
	 * hexagon. Parameters width and height specify its width and height. The 
	 * top-left and bottom-left vertices of a Hexagon are normally 20 pixels to 
	 * the right of the left hand side of the bounding box. Similarly, the top-right
	 * and bottom- right vertices of a Hexagon are normally 20 pixels to the left of 
	 * the right hand side of the bounding box. The far left vertex and the far right 
	 * vertex are each placed at the midpoint of their respective edges.
	 */
	public void drawHexagon(int x, int y, int width, int height);

	/**
	 * Draws an Diamond. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height. The top 
	 * vertex and the bottom vertex are both placed at midway point of their 
	 * respective edges. The far left vertex and the far right vertex are each 
	 * placed at the midpoint of their respective edges.
	 */
	public void drawDiamond(int x, int y, int width, int height);

	/**
	 * Fills a retangle with a color of choice given the same parameters as the 
	 * rectangle that is drawn.
	 */
	public void fillRect(int x, int y, int width, int height);

	/**
	 * Returns a colour of the graphics when invoked
	 */
	public Color getColor();

	/**
	 * sets a colour to the invoking shape
	 */
	public void setColor(Color c);

	/**
	 * Prints an image at with the given top left vertex of the bounded above.
	 */
	public void drawImage(Image image, int x, int y, int width, int height);

	public void translate(int x, int y);

	public void drawCentredText(String text, int x, int y, int width, int height);
}
