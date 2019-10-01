package com.ead.ims.Service;

import java.util.List;

import com.ead.ims.model.Product;

public interface ProductINF {
	
	public List<String[]> getAllProducts();
	
	public List<String[]> getAllProductsAsc();
	
	public List<String[]> getAllProductsDesc();
	
	public Product getProductbyID(String product_id);
	
	public Product getProductbyName(String product_name);
	
	public Product getProductbyManufacture(String product_name);
	
	public Product getProductbyTypeCode(String type_code);
	
	public Product getProductbyLocationCode(String location_code);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(int product_id);
	
	public boolean insertProduct(Product product);
	

}