package com.myproject.ecom_project.service;

import com.myproject.ecom_project.model.product;
import com.myproject.ecom_project.repository.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productservice {
    @Autowired
    private productrepo repo;
    public List<product> getallproducts() {
        return repo.findAll();
    }

    public product setproducts(product prod , MultipartFile imagefile) throws IOException {
        prod.setImagename(imagefile.getOriginalFilename());
        prod.setImagedata(imagefile.getBytes());
        prod.setImagetype(imagefile.getContentType());
        return repo.save(prod);

    }

    public void setallproducts(List<product> lst) {
        repo.saveAll(lst);
    }


    public product getprodbyid(int prodid) {
        return repo.findById(prodid).orElse(null);
    }

    public List<product> searchproducts(String keyword) {
        return repo.searchproducts( keyword);
    }
}
