package spaceshapes.views;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class Task1 implements TreeModel {

    protected ShapeModel _shapeModelAdaptee;
    protected List<TreeModelListener> _treeModelListeners = new ArrayList<TreeModelListener>();

    public Task1(ShapeModel shape){
        _shapeModelAdaptee = shape;
    }

    @Override
    public Object getRoot() {
        return _shapeModelAdaptee.root();
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof CarrierShape) {
            try {
                return (((CarrierShape) parent).shapeAt(index));
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof CarrierShape) {
            return ((CarrierShape) parent).shapeCount();
        } else {
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        return !(node instanceof CarrierShape);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if(parent instanceof CarrierShape){
            return(((CarrierShape) parent).indexOf((Shape) child));
        } else {
            return -1;
        }
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        _treeModelListeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        _treeModelListeners.remove(l);
    }
}
