/**
 * Title: Main.java
 * 
 * $Id$
 */
package tableExample;

/**
 * Description:这个程序主要是为了实现在JTable中某行某列中添加下拉框
 * 
 * @author csg
 */
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class Main {
    public static void main(String[] argv) throws Exception {
        MyTable table = new MyTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.addColumn("A", new Object[] { "item1", "item3" });
        model.addColumn("B", new Object[] { "item2", "item4" });

        String[] values = new String[] { "1", "2", "3" };
        table.setComboCell(1, 1, new MyComboBoxEditor(values));

        // TableColumn col = table.getColumnModel().getColumn(0);
        // col.setCellEditor(new MyComboBoxEditor(values));
        // col.setCellEditor(new MyComboBoxRenderer(values));
        // table.setModel(model);
        // table.updateUI();
        JScrollPane jp = new JScrollPane(table);
        jp.setViewportView(table);
        jp.setSize(400, 300);
        JFrame jf = new JFrame();
        jf.getContentPane().add(jp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400, 300);
        jf.setVisible(true);

    }
}

class MyTable extends JTable {
    int myRow = -1, myCol = -1;
    TableCellEditor myEditor;

    public void setComboCell(int r, int c, TableCellEditor ce) {
        this.myRow = r;
        this.myCol = c;
        this.myEditor = ce;
    }

    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        System.out.println(row + "," + column + ";" + myRow + "," + myCol + ","
                + myEditor);
        if (row == myRow && column == myCol && myEditor != null)
            return myEditor;
        return super.getCellEditor(row, column);
    }

}

class MyComboBoxEditor extends DefaultCellEditor {
    public MyComboBoxEditor(String[] items) {
        super(new JComboBox(items));
    }
}