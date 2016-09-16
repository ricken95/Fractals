
/*
 * Name: Kenneth Richardson
 * Hw3 Fractals
 * Date: 9/16/2016
 */

import java.applet.*;
import java.awt.*;
import java.util.*;

public class triangle extends Applet {
	private Image display;
	private Graphics drawingArea;

	public void init() {
		int height = getSize().height;

		int width = getSize().width;

		display = createImage(width, height);

		drawingArea = display.getGraphics();

		drawPoly(0, 0, height, drawingArea);

		drawTriangle(0, 0, height, drawingArea);
	}

	public void paint(Graphics g) {
		g.drawImage(display, 0, 0, null);
	}

	public static void drawTriangle(int x, int y, int side, Graphics g) {

		int b1 = side / 4; // equation for first side

		int half = side / 2; // equation for second side

		int b3 = (side * 3) / 4; // equation for third side
		
		g.setColor(Color.WHITE); //set color of recursive triangles

		int[] xpoint = { x + b1, half + x, x + b3 }; // x coordinate

		int[] ypoint = { y + half, side + y, y + half }; // y coordinate

		int npoint = 3; // number of vertices

		g.fillPolygon(xpoint, ypoint, npoint);

		if (side >= 4) {

			drawTriangle(x + b1, y, half, g); // first recursive call for a portion of the triangles

			drawTriangle(x, y + half, half, g); // second recursive call for another portion of triangles

			drawTriangle(x + half, y + half, half, g); // final recursive call to complete the fractal
			
		}
	}

	public static void drawPoly(int x, int y, int side, Graphics g) {
		int[] xpoint = { 0, side / 2, side }; // array for x points

		int[] ypoint = { side, 0, side }; // array for y points

		int point = 3; // number of vertices

		g.setColor(Color.BLUE); //sets the color for the outer triangle

		g.fillPolygon(xpoint, ypoint, point);

	}
}