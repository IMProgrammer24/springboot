package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Manufacturer;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ImageFileController {
	
	@Autowired
	ServletContext servletContext;
	
	@GetMapping("/getimages")
	public ResponseEntity<List<String>> getImages(@RequestParam(name="ManufacturerName") String brandName){
		System.out.println("BrandName = "+brandName);
		ArrayList<String> images=new ArrayList<>();
//		String realPath = servletContext.getRealPath("/images/ducati");
		String realPath = servletContext.getRealPath("/images/"+brandName.toLowerCase());
		File folderfile= new File(realPath);
		if(folderfile != null) {
			for(final File file:folderfile.listFiles()) {
				if(!file.isDirectory()) {
					String encodedbase64=null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fin = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fin.read(bytes);
						encodedbase64=Base64.getEncoder().encodeToString(bytes);
						images.add("data:image/"+extension+";base64,"+encodedbase64);
						fin.close();
						
					}catch(Exception e) {
						System.out.println("Exception Occured--->"+e);
					}
				}
			}
		}
		
		return new ResponseEntity<List<String>>(images,HttpStatus.OK);
	}

	
	
	@GetMapping("/getimagesdetails")
	public ResponseEntity<List<Manufacturer>> getImagesDetails(@RequestParam(name="ManufacturerName") String brandName){
		System.out.println("BrandName = "+brandName);
		
		ArrayList<Manufacturer> manufacturerlist = new ArrayList<>();
		int counter=0;
//		String realPath = servletContext.getRealPath("/images/ducati");
		ArrayList<String> images=new ArrayList<>();
		String realPath = servletContext.getRealPath("/images/"+brandName.toLowerCase());		
		File folderfile= new File(realPath);
		if(folderfile != null) {
			for(final File file:folderfile.listFiles()) {
				if(!file.isDirectory()) {
					String encodedbase64=null;
					try {
						String extension = FilenameUtils.getExtension(file.getName());
						FileInputStream fin = new FileInputStream(file);
						byte[] bytes = new byte[(int)file.length()];
						fin.read(bytes);
						encodedbase64=Base64.getEncoder().encodeToString(bytes);
						String imgencodedvalue="data:image/"+extension+";base64,"+encodedbase64;
						images.add("data:image/"+extension+";base64,"+encodedbase64);
						
						int baseyear=2018+counter;
						
						String model = String.valueOf(baseyear);
						String description = "This model is manufactured by "+brandName+" in year "+model;
						manufacturerlist.add(new Manufacturer(++counter, brandName.toUpperCase(), model, description, imgencodedvalue));
						
						fin.close();
						
					}catch(Exception e) {
						System.out.println("Exception Occured--->"+e);
					}
				}
			}
		}
		System.out.println(manufacturerlist.toString());
		return new ResponseEntity<List<Manufacturer>>(manufacturerlist,HttpStatus.OK);
	}
}
