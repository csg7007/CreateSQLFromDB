import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Title: MainOperateWindow.java
 * 
 * $Id$
 */

/**
 * Description:
 * 
 * @author Administrator
 */
public class MainOperateWindow extends JFrame implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JButton jbtAdd = new JButton("新增");
    private JButton jbtModify = new JButton("修改");
    private JButton jbtDelete = new JButton("删除");
    private JButton jbtQuery = new JButton("查询");
    private JButton jbtOperate = new JButton("操作");

    public MainOperateWindow() {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((scrSize.width - 300) / 2, (scrSize.height - 200) / 2,
                300, 200);
        this.setTitle("数据库表查询");
        this.setLayout(null);
        initModule();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initModule() {
        jbtAdd.setBounds(0, 0, 60, 20);
        jbtModify.setBounds(60, 0, 60, 20);
        jbtDelete.setBounds(120, 0, 60, 20);
        jbtQuery.setBounds(180, 0, 60, 20);
        jbtOperate.setBounds(240, 0, 60, 20);

        jbtAdd.addActionListener(this);
        jbtModify.addActionListener(this);
        jbtDelete.addActionListener(this);
        jbtQuery.addActionListener(this);
        jbtOperate.addActionListener(this);

        add(jbtAdd);
        add(jbtModify);
        add(jbtDelete);
        add(jbtQuery);
        add(jbtOperate);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtAdd) {
            addAction();
        } else if (e.getSource() == jbtModify) {
            modifyAction();
        } else if (e.getSource() == jbtDelete) {
            deleteAction();
        } else if (e.getSource() == jbtQuery) {
            queryAction();
        } else if (e.getSource() == jbtOperate) {
            operateAction();
        }
    }

    private void addAction() {
        DlgAddTable dlgAddTable = new DlgAddTable();
    }

    private void modifyAction() {

    }

    private void deleteAction() {

    }

    private void queryAction() {

    }

    private void operateAction() {

    }

}
