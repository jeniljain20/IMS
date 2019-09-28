package com.ead.ims.controller;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.ead.ims.Service.ProductOperations;
//import com.ead.ims.dao.Operations;
import com.ead.ims.model.Product;
//import com.ead.ims.util.Database;
import com.ead.ims.util.*;

@Controller
public class IMSController {

	private static String TEMP_FOLDER = "C://temp//";

	@Value("${test_file}")
	private String test_file;

	@RequestMapping(value = "/homepage")
	public String homepage() {
		return "homepage.html";
	}

	@RequestMapping(value = "/testcsv")
	@ResponseBody
	public List<String[]> readcsv(String filepath) {

		return ReadCSV.readfile(test_file);

	}

	@RequestMapping(value="/uploadcsv")
	@ResponseBody
	public List<String[]> singleFileUpload(@RequestParam("file") MultipartFile file) {
		List<String[]> content = null;

		if (file.isEmpty()) {

			return null;
		}

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(TEMP_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			content = readcsv(path.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

}
