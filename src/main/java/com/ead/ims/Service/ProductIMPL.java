package com.ead.ims.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ead.ims.dao.ProductDAO;
import com.ead.ims.model.Product;

public class ProductIMPL implements ProductINF {
	private static Logger log = Logger.getLogger(ProductIMPL.class);
	ProductDAO dao = new ProductDAO();
	@Override
	public List<String[]> getAllProducts() {

		ArrayList<String[]> showProducts = new ArrayList<String[]>();
		try {
			showProducts = dao.getAllProducts();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProducts;
	
	}

	@Override
	public List<String[]> getAllProductsAsc() {
		return null;
	}

	@Override
	public List<String[]> getAllProductsDesc() {
		return null;
	}

	@Override
	public Product getProductbyID(String product_id) {
		ArrayList<String> product = new ArrayList<String>();
		try {
			showProductbyID = dao.searchProductbyId();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyID;
	
	}

	@Override
	public Product getProductbyName(String product_name) {
		return null;
	}

	@Override
	public Product getProductbyManufacture(String product_name) {
		return null;
	}

	@Override
	public Product getProductbyTypeCode(String type_code) {
		return null;
	}

	@Override
	public Product getProductbyLocationCode(String location_code) {
		return null;
	}

	@Override
	public int updateProduct(Product product) {
		return 0;
	}

	@Override
	public int deleteProduct(int product_id) {
		int num = 0;
		try {
			 num = dao.deleteProducts();
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return num;
	}

	@Override
	public boolean insertProduct(Product product) {
		boolean status=false;
		try {
			 status= dao.insertProducts(product);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return status;
	}

}
