package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController // Bu sınıfın bir REST denetleyicisi olduğunu belirtir.yani hem ios hem android için çalışır
@RequestMapping("/api/products") // Bu denetleyicinin temel URL yolunu belirler. Tüm yollar /api/products ile başlar.
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired // projeyi tarayıp productServicei buluyo
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall") //Bu metodun HTTP GET isteği için olduğunu belirtir ve /api/products/getall yoluna bağlıdır.
	public List<Product> getAll(){
		return this.productService.getAll();
	}

}
