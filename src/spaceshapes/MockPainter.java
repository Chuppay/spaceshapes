package spaceshapes;

import java.awt.Color;
import java.awt.Image;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 *
 * @author Paramvir Singh (Original Author - Ian Warren)
 *
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();
	private Color _color = new Color(212, 212, 212);

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	/**
	 * Logs the drawHexagon call.
	 */
	public void drawHexagon(int x, int y, int width, int height) {
		_log.append("(hexagon " + x + "," + y + "," + width + "," + height + ")");
		_log.append("(line " + x + "," + (y + height / 2) + "," + (x + 20) + "," + y + ")");
		_log.append("(line " + (x + 20) + "," + y + "," + (x + width - 20) + "," + y + ")");
		_log.append("(line " + (x + width - 20) + "," + y + "," + (x + width) + "," + (y + height / 2) + ")");
		_log.append("(line " + (x + width) + "," + (y + height / 2) + "," + (x + width - 20) + "," + (y + height) + ")");
		_log.append("(line " + (x + width - 20) + "," + (y + height) + "," + (x + 20) + "," + (y + height) + ")");
		_log.append("(line " + (x + 20) + "," + (y + height) + "," + x + "," + (y + height / 2) + ")");
	}

	/**
	 * Logs the drawDiamond call.
	 */
	public void drawDiamond(int x, int y, int width, int height) {
		_log.append("(diamond " + x + "," + y + "," + width + "," + height + ")");
		_log.append("(line " + x + "," + (y + height / 2) + "," + (x + width / 2) + "," + y + ")");
		_log.append("(line " + (x + width / 2) + "," + y + "," + (x + width) + "," + (y + height / 2) + ")");
		_log.append("(line " + (x + width) + "," + (y + height / 2) + "," + (x + width / 2) + "," + (y + height) + ")");
		_log.append("(line " + (x + width / 2) + "," + (y + height) + "," + x + "," + (y + height / 2) + ")");
	}


	public void fillRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + " filled)");

	}

	public Color getColor() {
		_log.append("(current color: " + _color + ")");
		return _color;
	}

	public void setColor(Color c) {
		if (c == null) {
			c = new Color(255, 255, 255);
		}
		_log.append("(" +c + " set as color)");
	}

	public void drawImage(Image image, int x, int y, int width, int height) {
		_log.append("(image of size " + width + ", " + height +" is drawn");
	}

	@Override
	public void translate(int x, int y){

	}

	@Override
	public void drawCentredText(String text, int x, int y, int width, int height) {
	}
}
