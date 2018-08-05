package com.univercity.controllers;

import com.univercity.model.Associate;
import com.univercity.model.Customer;
import com.univercity.model.OrderDetails;
import com.univercity.model.Product;
import com.univercity.service.interfaces.AssociateService;
import com.univercity.service.interfaces.CustomerService;
import com.univercity.service.interfaces.OrderDetailsService;
import com.univercity.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class OrderDetailsController {

	private final ProductService productService;

	private final CustomerService customerService;

	private final AssociateService associateService;

	private final OrderDetailsService orderDetailsService;

	@Autowired
	public OrderDetailsController(ProductService productService, CustomerService customerService, AssociateService associateService, OrderDetailsService orderDetailsService) {
		this.productService = productService;
		this.customerService = customerService;
		this.associateService = associateService;
		this.orderDetailsService = orderDetailsService;
	}


	@RequestMapping(value = "/order_details_all", method = RequestMethod.GET)
	public String getAssociatesAll(Model model) {
		model.addAttribute("orderDetails", orderDetailsService.getAllOrderDetails());
		model.addAttribute("customers", customerService.getAllCustomers());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("associates", associateService.getAllAssociates());
		return "order_details";
	}

	@RequestMapping(value = "/order_detail_update", method = RequestMethod.POST)
	public String updatePost(@RequestParam("orderDetailId") long id, @RequestParam("customer") long   customerId,
							 @RequestParam("date") String date, @RequestParam("product") String  productFormat,
							 @RequestParam("amount") int  amount,  @RequestParam("associate") String  associateFormat) {

		Customer customer =  customerService.getById(customerId);
		Product product = productService.getByName(productFormat);
		Associate associate = associateService.getByName(associateFormat);

		OrderDetails orderDetails = new OrderDetails(customer,date,product,amount,associate);
		customer.setId(id);
		orderDetailsService.updateOrderDetails(orderDetails);
		return "redirect:/user/order_details_all";
	}

	@RequestMapping(value = "/order_detail_insert", method = RequestMethod.POST)
	public String insertAssociate(@RequestParam("customer") long   customerId,
								  @RequestParam("date") String date, @RequestParam("product") String  productFormat,
								  @RequestParam("amount") int  amount,  @RequestParam("associate") String  associateFormat) {

		Customer customer =  customerService.getById(customerId);
		Product product = productService.getByName(productFormat);
		Associate associate = associateService.getByName(associateFormat);

		OrderDetails orderDetails = new OrderDetails(customer,date,product,amount,associate);
		orderDetailsService.saveOrderDetails(orderDetails);
		return "redirect:/user/order_details_all";
	}

	@RequestMapping(value = "/order_detail_delete/{orderDetailId}", method = RequestMethod.GET)
	public String deleteGet(@PathVariable("orderDetailId") long id) {
		orderDetailsService.deleteOrderDetails(id);
		return "redirect:/user/order_details_all";
	}
}
