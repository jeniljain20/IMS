
package com.ead.ims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ead.ims.model.Product;
import com.ead.ims.util.ConnectDatabase;
import com.ead.ims.util.Dbquery;

public class ProductDAO {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private Dbquery query;

	public ProductDAO() {
		query = new Dbquery();
	}

	public ArrayList<String[]> getAllProducts() throws ClassNotFoundException, SQLException {
		ArrayList<String[]> products = new ArrayList<String[]>();
		try {
			System.out.println("inside dao");
			connection = ConnectDatabase.createConnection();
			statement = connection.prepareStatement(query.getAllProducts());
			resultSet = statement.executeQuery();
			System.out.println("result" + resultSet.toString());
			while (resultSet.next()) {
				String[] product = new String[10];
				product[0] = resultSet.getString("product_id");
				product[1] = resultSet.getString("product");
				product[2] = resultSet.getString("model");
				product[3] = resultSet.getString("manufacture");
				product[4] = resultSet.getString("type_code");
				product[5] = resultSet.getString("location_code");
				product[6] = resultSet.getString("msrp");
				product[7] = resultSet.getString("unit_cost");
				product[8] = resultSet.getString("discount_rate");
				product[9] = resultSet.getString("stock_qty");
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println("exception" + e);
		}
		resultSet.close();
		ConnectDatabase.closeConnection();
		return products;
	}

public boolean insertProducts(Product product)throws ClassNotFoundException,SQLException
{
boolean status=false;
	try {
	System.out.println("inside dao");
	connection = ConnectDatabase.createConnection();
	statement = connection.prepareStatement(query.getAddProduct());
	statement.setString(1,product.getProduct_id());
	statement.setString(2,product.getProduct());
	statement.setString(3,product.getModel());
	statement.setString(4,product.getManufacture());
	statement.setString(5,product.getType_code());
	statement.setInt(6,product.getLocation_code());
	statement.setFloat(7,product.getMsrp());
	statement.setFloat(8,product.getUnit_cost());
	statement.setFloat(9,product.getDiscount_rate());
	statement.setInt(10,product.getStock_qty());
	status=statement.execute();
	}catch(Exception e)
	{System.out.println("exception"+e);}
	resultSet.close();
	ConnectDatabase.closeConnection();
	return status;
}
	
	public int deleteProduct()throws ClassNotFoundException,SQLException
{
		int numRows = 0;
	try {
	String Prod_ID = "1";
	statement = connection.prepareStatement(query.getDeleteProduct());
	statement.setString(1,Prod_ID);
	numRows = statement.executeUpdate();
	}catch(Exception e)
	{System.out.println("exception"+e);}
	statement.close();
	ConnectDatabase.closeConnection();
	return numRows;
}
	
	public ArrayList<String> searchProductbyId()throws ClassNotFoundException,SQLException
{
	ArrayList<String> product = new ArrayList<String>();
	try {
	String Prod_ID = "1";
	statement = connection.prepareStatement(query.getSearchProductbyId());
	statement.setString(1,Prod_ID);
	resultSet = statement.executeQuery();
	ResultSetMetaData rsmd = resultSet.getMetaData(); 
	int columnCount = rsmd.getColumnCount();
	while (resultSet.next()) {              
	int i = 1;
	while(i <= columnCount) {
	product.add(resultSet.getString(i++));
	 }}
	}catch(Exception e)
	{System.out.println("exception"+e);}
	statement.close();
	ConnectDatabase.closeConnection();
	return product;
}
}
