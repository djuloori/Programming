package Views;

import Models.daoModel;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import Controllers.LoanController;


public class LoanView extends JFrame{
	private static final long serialVersionUID = 6348018170112990032L;
	daoModel dao = new daoModel();
	
	public LoanView()
	{
    	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<String> column = new Vector<String>();
		try {
    	    
    	    ResultSet rs = dao.getResultSet();
    	    ResultSetMetaData metaData = rs.getMetaData();
    	    int columns = metaData.getColumnCount();
    	    String cols = ""; 
    	 
    	    for (int i = 1; i <= columns ; i++) {
    	       cols = metaData.getColumnName(i);
    	       column.add(cols);
    	    }
    	    while (rs.next()) {
    	       Vector<Object> row = new Vector<Object>(columns);
    	          
    	       for (int i = 1; i <= columns; i++) {
    	        row.addElement(rs.getObject(i));
    	       } 
    	       data.addElement(row);
 	        }
    	    rs.close();
    	    System.out.println("JTable is Created");
    
 DefaultTableModel model = new DefaultTableModel(data,column);
 JTable table = new JTable(model);
 
 JFrame frame = new JFrame ("Loan Details");
 frame.setSize(700,200);
 frame.add(new JScrollPane(table));
 frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
 frame.pack();
 frame.setVisible(true);
    	    
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
