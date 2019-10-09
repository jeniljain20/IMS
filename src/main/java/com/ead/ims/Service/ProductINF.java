package com.ead.ims.Service;

import java.util.List;

import com.ead.ims.model.Product;

public interface ProductINF {
	
	public List<String[]> getAllProducts();
	
	public List<String[]> getAllProductsAsc();
	
	public List<String[]> getAllProductsDesc();
	
	public List<String> getProductbyID(String product_id);
	
	public List<String> getProductbyName(String product_name);
	
	public List<String> getProductbyManufacture(String manuf_name);
	
	public List<String> getProductbyTypeCode(String type_code);
	
	public List<String> getProductbyLocationCode(String location_code);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(int product_id);
	
	public boolean insertProduct(Product product);
	

}