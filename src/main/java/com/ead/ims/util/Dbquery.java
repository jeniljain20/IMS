package com.ead.ims.util;

public class Dbquery {
	private String searchProductbyId = "select * from Products where product_id = ?";
	private String searchProductbyName = "select * from Products where product = ?";
	private String searchProductbyManufacture = "select * from Products where manufacture = ?";
	private String searchProductbyTypeCode = "select * from Products where type_code = ?";
	private String searchProductbyLocationCode = "select * from Products where location_code = ?";
	private String allProducts = "Select * from Products";
	private String allProductsASC = ""; // same as all Products??
	private String allProductsDSC ="Select * from Products order by product";
	private String addProduct="INSERT INTO Products(product_id, product, model, manufacture, type_code, location_code,msrp,unit_cost,discount_rate,stock_qty) VALUES(?,?,?,?,?,?,?,?,?,?);";

	public String getAddProduct() {
		return addProduct;
	}

	public void setAddProduct(String addProduct) {
		this.addProduct = addProduct;
	}

	public String getAllProductsASC() {
		return allProductsASC;
	}

	public void setAllProductsASC(String allProductsASC) {
		this.allProductsASC = allProductsASC;
	}

	public String getAllProductsDSC() {
		return allProductsDSC;
	}

	public void setAllProductsDSC(String allProductsDSC) {
		this.allProductsDSC = allProductsDSC;
	}

	public String getGetProductsASC() {
		return allProductsASC;
	}

	public void setGetProductsASC(String getProductsASC) {
		this.allProductsASC = getProductsASC;
	}

	public String getGetProductsDSC() {
		return allProductsDSC;
	}

	public void setGetProductsDSC(String getProductsDSC) {
		this.allProductsDSC = getProductsDSC;
	}

	private String updateProduct = "";
	private String deleteProduct = "delete from Products where product_id = ?";
	private String insertProduct = ""; //this is the same as add product, can be removed. 

	public String getSearchProductbyId() {
		return searchProductbyId;
	}

	public void setSearchProductbyId(String searchProductbyId) {
		this.searchProductbyId = searchProductbyId;
	}

	public String getSearchProductbyName() {
		return searchProductbyName;
	}

	public void setSearchProductbyName(String searchProductbyName) {
		this.searchProductbyName = searchProductbyName;
	}

	public String getSearchProductbyManufacture() {
		return searchProductbyManufacture;
	}

	public void setSearchProductbyManufacture(String searchProductbyManufacture) {
		this.searchProductbyManufacture = searchProductbyManufacture;
	}

	public String getSearchProductbyTypeCode() {
		return searchProductbyTypeCode;
	}

	public void setSearchProductbyTypeCode(String searchProductbyTypeCode) {
		this.searchProductbyTypeCode = searchProductbyTypeCode;
	}

	public String getSearchProductbyLocationCode() {
		return searchProductbyLocationCode;
	}

	public void setSearchProductbyLocationCode(String searchProductbyLocationCode) {
		this.searchProductbyLocationCode = searchProductbyLocationCode;
	}

	public String getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(String updateProduct) {
		this.updateProduct = updateProduct;
	}

	public String getDeleteProduct() {
		return deleteProduct;
	}

	public void setDeleteProduct(String deleteProduct) {
		this.deleteProduct = deleteProduct;
	}

	public String getInsertProduct() {
		return insertProduct;
	}

	public void setInsertProduct(String insertProduct) {
		this.insertProduct = insertProduct;
	}

	public String getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(String allProducts) {
		this.allProducts = allProducts;
	}

}
