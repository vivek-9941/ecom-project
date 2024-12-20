package com.myproject.ecom_project.repository;
import com.myproject.ecom_project.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface productrepo extends JpaRepository<product,Integer> {
    @Query("SELECT P FROM product P WHERE "+
    "LOWER(P.name) LIKE LOWER(CONCAT('%',:keyword ,'%')) OR "+
            "LOWER(P.descript) LIKE LOWER(CONCAT('%',:keyword ,'%')) OR "+
            "LOWER(P.brand) LIKE LOWER(CONCAT('%',:keyword ,'%')) "
    )
    //because if : it will search fro the parameter keyword in the function
    List<product> searchproducts(String keyword);
}
