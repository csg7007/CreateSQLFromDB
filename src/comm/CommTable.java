/**
 * Title: CommTable.java
 * 
 * $Id$
 */
package comm;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * Description:
 * 
 * @author Administrator
 */
public class CommTable extends JTable implements MouseListener {
    /**
     * 
     */
    private JPopupMenu jPopupMenu=new JPopupMenu();
    private static final long serialVersionUID = 1L;
    private ArrayList<Integer> arrProblem = new ArrayList<Integer>();

    public CommTable(TableModel tm) {
        super(tm);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (arrProblem != null) {
            int row = this.rowAtPoint(e.getPoint());
            if (arrProblem.contains(row)) {
                this.setSelectionBackground(Color.pink);
            } else {
                this.setSelectionBackground(Color.lightGray);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void setArrProblem(ArrayList<Integer> arrProblem) {
        this.arrProblem = arrProblem;
    }

    public ArrayList<Integer> getArrProblem() {
        return arrProblem;
    }

}
