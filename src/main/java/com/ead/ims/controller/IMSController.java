package com.ead.ims.controller;

import java.io.BufferedReader;
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
	public List<String[]> singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		String TEMP_FOLDER = "C://testproj//";
		List<String[]> content = null;
		String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = null;
        byte[] bytes = file.getBytes();
		Path path = Paths.get(TEMP_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);
		content = ReadCSV.readfile(path.toString());
		if (file.isEmpty()) {

			return null;
		}

		try {
			br = new BufferedReader(new FileReader(path.toString()));
			while ((line = br.readLine()) != null) {
				Product temp_prod = new Product();
				String[] params = line.split(cvsSplitBy);
				temp_prod.setProduct_id(params[0]);
				temp_prod.setProduct_name(params[1]);
				temp_prod.setModel(params[2]);
				temp_prod.setManufacture(params[3]);
				temp_prod.setType_code(params[4]);
				temp_prod.setLocation_code(Integer.parseInt(params[5]));
				temp_prod.setMsrp(Float.parseFloat(params[6]));
				temp_prod.setUnit_cost(Float.parseFloat(params[7]));
				temp_prod.setDiscount_rate(Float.parseFloat(params[8]));
				temp_prod.setStock_qty(Integer.parseInt(params[9]));
				insert(temp_prod);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

	
	@RequestMapping(value = "/getAll")
	public void getAll() {
		
		List<String[]> productList = new ArrayList<String[]>();
		ProductINF serviceImpl = new ProductIMPL();
		productList = serviceImpl.getAllProducts();
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public boolean insert(Product product) {
		ProductINF serviceImpl = new ProductIMPL();
			product.setProduct_id(product.getProduct_id());
			product.setProduct_name(product.getProduct_name());
			product.setModel(product.getModel());
			product.setManufacture(product.getManufacture());
			product.setType_code(product.getType_code());
			product.setLocation_code(product.getLocation_code());
			product.setMsrp(product.getMsrp());
			product.setUnit_cost(product.getUnit_cost());
			product.setDiscount_rate(product.getDiscount_rate());
			product.setStock_qty(product.getStock_qty());
		
		boolean success = serviceImpl.insertProduct(product);
		return success;
	}
	
	
	@RequestMapping(value = "/selectbyid")
	@ResponseBody
	public List<String> selectbyid(@RequestParam("prodid") String product_id) {
		ProductINF serviceImpl = new ProductIMPL();
		
		List<String> list = serviceImpl.getProductbyID(product_id);
		return list;
	}
	
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public List<String> delete(@RequestParam("prodid") String product_id) {
		ProductINF serviceImpl = new ProductIMPL();
		
		List<String> list = serviceImpl.getProductbyID(product_id);
		return list;
	}
	
	@RequestMapping(value = "/selectbyname")
	@ResponseBody
	public List<String> selectbyname(@RequestParam("prodname") String product_name) {
		ProductINF serviceImpl = new ProductIMPL();
		
		List<String> list = serviceImpl.getProductbyName(product_name);
		return list;
	}
	
}
