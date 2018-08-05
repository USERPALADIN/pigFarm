package com.univercity.controllers;

import com.univercity.model.OrderDetails;
import com.univercity.model.Product;
import com.univercity.model.Unit;
import com.univercity.service.interfaces.OrderDetailsService;
import com.univercity.service.interfaces.ProductService;
import com.univercity.service.interfaces.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class ProductController {

	private final ProductService productService;

	private final OrderDetailsService orderDetailsService;

	private final UnitService unitService;

	@Autowired
	public ProductController(ProductService productService, UnitService unitService, OrderDetailsService orderDetailsService) {
		this.productService = productService;
		this.unitService = unitService;
		this.orderDetailsService = orderDetailsService;
	}

	@RequestMapping(value = "/products_all", method = RequestMethod.GET)
	public String getProductsAll(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("units", unitService.getAllUnits());
		return "products";
	}

	@RequestMapping(value = "/product_insert", method = RequestMethod.POST)
	public String insertAssociate(@RequestParam("name") String name,
								  @RequestParam("price") int price,
								  @RequestParam("unit") String unitFormat) {

		Unit unit = unitService.getByName(unitFormat);
		Product product = new Product(name, price, unit);
		productService.saveProduct(product);
		return "redirect:/user/products_all";
	}

	@RequestMapping(value = "/product_delete/{productId}", method = RequestMethod.GET)
	public String deleteGet(@PathVariable("productId") long id) {
		Product product = productService.getById(id);
		OrderDetails orderDetails = orderDetailsService.getByProduct(product);
		if (orderDetails != null) {
			return "redirect:/user/products_all";
		}
		productService.deleteProduct(id);
		return "redirect:/user/products_all";
	}

	@RequestMapping(value = "/product_update", method = RequestMethod.POST)
	public String updatePost(@RequestParam("productId") long id, @RequestParam("name") String name,
							 @RequestParam("price") int price, @RequestParam("unit") String unitFormat) {
		Unit unit = unitService.getByName(unitFormat);
		Product product = new Product(name, price, unit);
		product.setId(id);
		productService.updateProduct(product);
		return "redirect:/user/products_all";
	}

}
