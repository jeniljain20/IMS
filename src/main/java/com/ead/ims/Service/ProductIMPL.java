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
	public List<String> getProductbyID(String product_id) {
		ArrayList<String> showProductbyID = new ArrayList<String>();
		try {
			showProductbyID = dao.searchProductbyId(product_id);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyID;
	
	}

	@Override
	public List<String> getProductbyName(String product_name) {
		ArrayList<String> showProductbyName = new ArrayList<String>();
		try {
			showProductbyName = dao.searchProductbyName(product_name);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyName;
	
	}

	@Override
	public List<String> getProductbyManufacture(String manuf_name) {
		ArrayList<String> showProductbyManuf = new ArrayList<String>();
		try {
			showProductbyManuf = dao.searchProductbyManuf(manuf_name);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyManuf;
	}

	@Override
	public List<String> getProductbyTypeCode(String type_code) {
		ArrayList<String> showProductbyTypecode = new ArrayList<String>();
		try {
			showProductbyTypecode = dao.searchProductbyTypecode(type_code);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyTypecode;
	}

	@Override
	public List<String> getProductbyLocationCode(String location_code) {
		ArrayList<String> showProductbyLocationcode = new ArrayList<String>();
		try {
			showProductbyLocationcode = dao.searchProductbyLocationcode(location_code);
		} catch (ClassNotFoundException exception) {
			log.info("Exception is :" + exception.getMessage());
		} catch (SQLException exception) {
			log.info("Exception is :" + exception.getMessage());
		}
		return showProductbyLocationcode;
	}

	@Override
	public int updateProduct(Product product) {
		return 0;
	}

	@Override
	public int deleteProduct(int product_id) {
		int num = 0;
		try {
			 num = dao.deleteProduct();
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
