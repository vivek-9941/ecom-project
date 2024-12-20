package com.myproject.ecom_project.controller;

import com.myproject.ecom_project.model.product;
import com.myproject.ecom_project.service.productservice;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class Productcontroller {
    @Autowired
    private productservice service;


    @GetMapping("/products")
    public ResponseEntity< List<product>> getallproducts(){

        return new ResponseEntity<>(service.getallproducts(), HttpStatus.OK);
    }

//    @PostMapping("/products")
//    public void setdata(@RequestBody product prod){
//        service.setproducts( prod);
//
//    }


    @PostMapping("/product")
    public ResponseEntity<product> setdata(@RequestPart("prod") product prod , @RequestPart("imageFile") MultipartFile imagefile){ // using request part
       try{
           System.out.println(prod);
            product prod1 = service.setproducts( prod , imagefile);
            return new ResponseEntity(prod1, HttpStatus.OK);

       }
       catch(Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }

    @PostMapping("/listproduct")

        public void setlistproducts(@RequestBody List<product> lst){
        service.setallproducts(lst);
        }

    @GetMapping("/product/{prodid}")
    public ResponseEntity<product >getprodbyid(@PathVariable int prodid){
        product prod = service.getprodbyid(prodid);
        if(prod != null)
            return new ResponseEntity<>(prod, HttpStatus.OK);
        else{
            return new ResponseEntity<>(prod, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("products/search")
    public ResponseEntity<List<product>> searchproduct(String keyword){
        System.out.println("seearching with :"+keyword);
        List<product> products = service.searchproducts(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

}
