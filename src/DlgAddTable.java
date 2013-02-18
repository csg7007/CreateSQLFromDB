import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
public class DlgAddTable extends ComDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JLabel jlbDBName=new JLabel("数据库名称：");
    private JTextField jtfDBName=new JTextField();
    
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
        jlbDBName.setBounds(2,2,100,20);
    }

}
