package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	//<entity olarak verdiğim şey, primary key >
	
	//select * from products where product_name=abc için jpa'nın hazır kodları var şunlar gibi:
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	//jpql:
	
	@Query("From Product where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int CategoryId);
	
	
	
	

}
