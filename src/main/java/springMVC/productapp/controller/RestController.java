package springMVC.productapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import springMVC.productapp.dao.ProductDao;
import springMVC.productapp.model.Product;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(value="/rest/products", produces = {"application/json" })
	public @ResponseBody  ResponseEntity<List<Product>> home() {
		List<Product> products=productDao.getProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	
	@RequestMapping("/rest/add-Product")
	public String AddProduct(Model m) {
		
      m.addAttribute("title","Add Product")	;	
		return "add_product_form";
	}
	
	//save product..
	@RequestMapping("/rest/handle-product")
	public RedirectView addProduct(@ModelAttribute("product") Product product,HttpServletRequest request) {
		System.out.println(product);
		//TODO- send data to database
		productDao.createProduct(product);
		RedirectView rv	 = new RedirectView();
		rv.setUrl(request.getContextPath()+"/");
		return rv;
		
	}
	
	//delete-handler
	@RequestMapping("/rest/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	
	@RequestMapping("/rest/update/{productId}")
	public String updateProduct(@PathVariable ("productId") int productId,Model model)
	{  
		Product product =this.productDao.getProduct(productId);
		model.addAttribute("product", product);
		return "update_product";
		
	}
	
	

}
