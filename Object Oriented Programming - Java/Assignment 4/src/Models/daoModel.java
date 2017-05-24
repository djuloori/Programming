package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Records.BankRecords;
import Models.Connector;
import java.sql.*;


public class daoModel extends BankRecords  {

	Connector connect = new Connector();
	private Statement statement = null;
	
	public void createTable() throws Exception {
		try {
			
			/** Create Table
			*/
			
			statement = connect.getConnection().createStatement();
			
			
			/**Create a new connection/	
			 * 
			 */
			String sql = "CREATE TABLE d_julo_tab" +
			 "(pid INTEGER not NULL AUTO_INCREMENT, " +
			 "id VARCHAR(7), " +
			 "income NUMERIC (8,2), " +
			 "pep VARCHAR(3), " +
			 "PRIMARY KEY(pid)) " ;
			
			statement.executeUpdate(sql);
			System.out.println("Created Table in given database");
			statement.close();
			
		}
			
			catch (SQLException e){
			System.out.println(e.getMessage());
			}
	}
	
	public void inserts(BankRecords [] objs) throws Exception {
		try {
			
		statement = connect.getConnection().createStatement();
		
		String sql = null;
		for (int i =0; i<objs.length; ++i)
			sql = "insert into p_vang_tab (id,income,pep)" +
			 "VALUES (' "+objs[i].getId() +  " ', ' " +objs[i].getIncome()+ " ',' " +objs[i].getPep()+" '";
			 		
			statement.executeUpdate(sql);
			System.out.println("Inserted Records in given table");
			statement.close();
			
		}
			
			catch (SQLException e){
			System.out.println(e.getMessage());
			}
	}
	
	
	
	public ResultSet getResultSet() throws Exception{
		ResultSet rs = null;
		try {
			statement = connect.getConnection().createStatement();
			String sql = "select id,income,pep from p_vang_tab order by pep desc";
		
			rs = statement.executeQuery(sql);
			
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	
		return rs;
	}
	
}

