package spaceshapes.views;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;


public class Task2 extends Task1 implements ShapeModelListener {

    public Task2(ShapeModel shape){
        super(shape);
    }

    @Override
    public void update(ShapeModelEvent event) {
        ShapeModel source = event.source();

        // determines path to root node
        Object[] path;
        if(event.parent() == null) {
            path = null;
        } else {
            path = event.parent().path().toArray();
        }

        int[] childIndices = new int[]{event.index()};
//        if (childIndices[0] == -1){
//            childIndices[0] = 0;
//        }

        Shape[] child = new Shape[]{event.operand()};

        TreeModelEvent tempEvent= new TreeModelEvent(source,path,childIndices,child);

        for (TreeModelListener listener : _treeModelListeners){
            if (event.eventType() == ShapeModelEvent.EventType.ShapeAdded){ //added event
                listener.treeNodesInserted(tempEvent);
            } else if (event.eventType() == ShapeModelEvent.EventType.ShapeRemoved){ //removed event
                listener.treeNodesRemoved(tempEvent);
            }
        }
    }
}
