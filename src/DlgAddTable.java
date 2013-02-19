import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import comm.ComDialog;
import comm.CommTable;

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
    private CommTable table;
    private JButton btnAdd = new JButton("添加");
    private DefaultTableModel tableModel;
    private JButton jbtSure = new JButton("确定");
    private JButton jbtCancel = new JButton("取消");

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
        jbtSure.setBounds(80, 246, 60, 20);
        jbtCancel.setBounds(140, 246, 60, 20);
        btnAdd.addActionListener(this);
        jbtSure.addActionListener(this);
        jbtCancel.addActionListener(this);
        Object[] columnNames = { "字段名", "字段属性" };
        Object[][] data = { { "id", "主键" }, { "name", "普通" } };
        tableModel = new DefaultTableModel(data, columnNames);
        table = new CommTable(tableModel);
        table.addMouseListener(table);
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
        add(jbtSure);
        add(jbtCancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addActionListener();
        } else if (e.getSource() == jbtSure) {
            sureActionListener();
        } else if (e.getSource() == jbtCancel) {
            cancelActionListener();
        }
    }

    private void sureActionListener() {
        // 检测新增的字段是否有误
        // 检测的内容包括：字段名格式为：若为主键或者普通则直接输入字段名，
        // 字段名不能为空，若为外键则字段名的格式为：“数据库名.字段名”
        ArrayList<Integer> arrProblem = new ArrayList<Integer>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                if (tableModel.getValueAt(i, j) == null
                        || tableModel.getValueAt(i, j).equals("")) {
                    arrProblem.add(i);
                    break;
                }
            }
        }
        table.setArrProblem(arrProblem);
        if (arrProblem.size() > 0) {
            JOptionPane.showMessageDialog(this, "字段名有误！", "错误",
                    JOptionPane.ERROR_MESSAGE, null);
            table.clearSelection();
            getBackground();
            table.setSelectionBackground(Color.PINK);
            for (int i = 0; i < arrProblem.size(); i++) {
                table.addRowSelectionInterval(arrProblem.get(i), arrProblem
                        .get(i));
            }
        }else{
            table.setSelectionBackground(Color.lightGray);
        }
    }

    private void cancelActionListener() {

    }

    private void addActionListener() {
        Object[] obj = null;
        tableModel.addRow(obj);
    }

}
