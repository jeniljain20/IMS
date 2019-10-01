package com.ead.ims.controller;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.ead.ims.Service.*;
import com.ead.ims.model.Product;
//import com.ead.ims.util.Database;
import com.ead.ims.util.*;

@Controller
public class IMSController {

	
	
	@Value("${test_file}")
	private String test_file;
	
	@Value("${getAllProducts}")
	private String getAllProducts;
	
	@Value("${insertProduct}")
	private String insertProduct;

	@RequestMapping(value = "/homepage")
	public String homepage() {
		return "homepage.html";
	}

	@RequestMapping(value = "/testcsv")
	@ResponseBody
	public List<String[]> readcsv(String filepath) {

		return ReadCSV.readfile(test_file);

	}

	@RequestMapping(value = "/uploadcsv")
	@ResponseBody
	public List<String[]> singleFileUpload(@RequestParam("file") MultipartFile file) {
		return FileUpload.upload(file);
	}

	
	@RequestMapping(value = "/getAll")
	public void getAll() {
		
		List<String[]> productList = new ArrayList<String[]>();
		ProductINF serviceImpl = new ProductIMPL();
		productList = serviceImpl.getAllProducts();
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public boolean insert() {
		ProductINF serviceImpl = new ProductIMPL();
		Product product=new Product();
		product.setProduct_id("2220220350");
		product.setProduct_name("Ultrabook");
		product.setModel("T60");
		product.setManufacture("Lenovo");
		product.setType_code("011");
		product.setLocation_code(000);
		product.setMsrp(500);
		product.setUnit_cost(300);
		product.setDiscount_rate(10.5f);
		product.setStock_qty(1000);
		
		boolean success = serviceImpl.insertProduct(product);
		return success;
	}
	
}
