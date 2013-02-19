import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import comm.ComDialog;

/**
 * Title: DlgAddTable.java
 * 
 * $Id$
 */

/**
 * Description:
 * 
 * @author Administrator
 */
public class DlgAddTable extends ComDialog implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JLabel jlbDBName = new JLabel("数据库名称：");
    private JTextField jtfDBName = new JTextField();
    private JLabel jlbDBTableName = new JLabel("表名：");
    private JTextField jtfDBTableName = new JTextField();
    private JScrollPane jScrollPane = new JScrollPane();
    private JTable table;
    private JButton btnAdd = new JButton("添加");
    private DefaultTableModel tableModel;

    public DlgAddTable() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((scrSize.width - 280) / 2, (scrSize.height - 350) / 2,
                280, 350);
        this.setTitle("数据库表查询");
        this.setLayout(null);
        initModule();
        this.setVisible(true);
    }

    private void initModule() {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("主键");
        comboBox.addItem("外键");
        comboBox.addItem("普通");
        jlbDBName.setBounds(20, 2, 80, 20);
        jtfDBName.setBounds(100, 2, 100, 20);
        jlbDBTableName.setBounds(20, 22, 80, 20);
        jtfDBTableName.setBounds(100, 22, 100, 20);
        btnAdd.setBounds(200, 22, 60, 20);
        btnAdd.addActionListener(this);
        Object[] columnNames = { "字段名", "字段属性" };
        Object[][] data = { { "id", "主键" }, { "name", "普通" } };
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        TableColumn tableColumn = table.getColumn("字段属性");
        DefaultCellEditor dce = new DefaultCellEditor(comboBox);
        tableColumn.setCellEditor(dce);
        jScrollPane.getViewport().add(table);
        jScrollPane.setBounds(20, 44, 240, 200);
        add(jlbDBName);
        add(jtfDBName);
        add(jlbDBTableName);
        add(jtfDBTableName);
        add(btnAdd);
        add(jScrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addActionListener();
        }
    }

    private void addActionListener() {
        Object[] obj = null;
        tableModel.addRow(obj);
    }

}
