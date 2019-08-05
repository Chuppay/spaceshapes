package spaceshapes;

import java.util.ArrayList;
import java.util.List;

public class CarrierShape extends Shape {

    private List<Shape> _children = new ArrayList<Shape>();

    /**
     * Creates a CarrierShape object with default values for state.
     */
    public CarrierShape() {
        super();
    }

    /**
     * Creates a CarrierShape object with with specified location values,
     * default values for other state items.
     */
    public CarrierShape(int x, int y) {
        super(x, y);
    }

    /**
     * Creates a CarrierShape object with with specified values for location,
     * velocity and direction. Non-specified state items take on default
     * values
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    /**
     * Creates a CarrierShape with specified values for location, velocity,
     * direction, width and height.
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height) {
        super(x, y, deltaX, deltaY, width, height);
    }

    public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height,String text) {
        super(x,y,deltaX,deltaY,width,height,text);
    }

    @Override
    /**
     * Moves a CarrierShape object (including it's children) within the bounds
     * specified by arguments width and height
     */
    public void move(int width, int height) {
        super.move(width, height);
        for (Shape child : _children) {
            child.move(_width, _height);
        }
    }

    @Override
    /**
     * can i get a yayeet
     */
    public void doPaint(Painter painter) {
        painter.drawRect(_x, _y, _width, _height);
        painter.translate(_x,_y);
        for (Shape child : _children) {
            child.paint(painter);
        }
        painter.translate(-_x,-_y);
    }

    /**
     * ∗ Attempts to add a Shape to a CarrierShape object. If successful, a
     * ∗ two−way link is established between the CarrierShape and the newly
     * ∗ added Shape. Note that this method has package visibility − for reasons
     * ∗ that will become apparent in Space−Shape III.
     * ∗ @param shape the shape to be added.
     * ∗ @throws IllegalArgumentException if an attempt is made to add a Shape
     * ∗ to a CarrierShape instance where the Shape argument is already a child
     * ∗ within a CarrierShape instance . An IllegalArgumentException is also
     * ∗ thrown when an attempt is made to add a Shape that will not fit within
     * ∗ the bounds of the proposed CarrierShape object .
     */
    void add(Shape shape) throws IllegalArgumentException {
        if (_children.contains(shape)) {
            throw new IllegalArgumentException("Carrier already contains this instance");
        } else if (shape.parent() != null){
            throw new IllegalArgumentException("Carrier already contains this instance");
        }else if (((shape.width()+shape.x())> _width) || ((shape.height()+shape.y()) > _height)) {
            throw new IllegalArgumentException("shape size exceeds carrier shape");
        } else {
            _children.add(shape);
            shape.setParent(this);
        }
    }


    /**
     ∗ Removes a particular Shape from a CarrierShape instance. Once removed,
     ∗ the two−way link between the CarrierShape and its former child is
     ∗ destroyed . This method has no effect if the Shape specified to remove
     ∗ is not a child of the CarrierShape . Note that this method has package
     ∗ visibility − for reasons that will become apparent in Space−Shape III.
     ∗ @param shape the shape to be removed.
     */
    void remove ( Shape shape ){
        _children.remove(shape);
        shape.setParent(null);
    }

    /**
     * Returns the Shape at a specified position within a CarrierShape. If
     * the position specified is less than zero or greater than the number of
     * children stored in the CarrierShape less one this method throws an
     * IndexOutOfBoundsException .
     * @param index the specified index position
     */
    public Shape shapeAt(int index) throws IndexOutOfBoundsException{
        return (_children.get(index));
    }

    /**
     ∗ Returns the number of children contained within a CarrierShape object.
     ∗ Note this method is not recursive − it simply returns the number of
     ∗ children at the top level within the callee CarrierShape object.
     */
    public int shapeCount(){
        return _children.size();
    }

    /**
     ∗ Returns the index of a specified child within a CarrierShape object.
     ∗ If the Shape specified is not actually a child of the CarrierShape
     ∗ this method returns −1; otherwise the value returned is in the range
     ∗ 0 .. shapeCount()− 1 .
     ∗ @param the shape whose index position within the CarrierShape is
     ∗ requested .
     */
    public int indexOf ( Shape shape ){
        return (_children.indexOf(shape));
    }

    /**
     ∗ Returns true if the Shape argument is a child of the CarrierShape
     ∗ object on which this method is called, false otherwise .
     */
    public boolean contains ( Shape shape ){
        if (indexOf(shape) == -1){
            return false;
        } else {
            return true;
        }
    }

}
