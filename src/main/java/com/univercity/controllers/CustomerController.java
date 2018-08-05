package com.univercity.controllers;

import com.univercity.model.Customer;
import com.univercity.model.OrderDetails;
import com.univercity.service.interfaces.CustomerService;
import com.univercity.service.interfaces.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class CustomerController {

	private final CustomerService customerService;

	private final OrderDetailsService orderDetailsService;
	@Autowired
	public CustomerController(CustomerService customerService, OrderDetailsService orderDetailsService) {
		this.customerService = customerService;
		this.orderDetailsService = orderDetailsService;
	}

	@RequestMapping(value = "/customers_all", method = RequestMethod.GET)
	public String getAssociatesAll(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}

	@RequestMapping(value = "/customer_update", method = RequestMethod.POST)
	public String updatePost(@RequestParam("customerId") long id, @RequestParam("organizationName") String organizationName,
							 @RequestParam("nameManager") String  nameManager, @RequestParam("address") String address,
							 @RequestParam("phone") String  phone) {

		Customer customer = new Customer(organizationName, nameManager, address, phone);
		customer.setId(id);
		customerService.updateCustomer(customer);
		return "redirect:/user/customers_all";
	}

	@RequestMapping(value = "/customer_insert", method = RequestMethod.POST)
	public String insertAssociate(@RequestParam("organizationName") String organizationName,
								  @RequestParam("nameManager") String nameManager,
								  @RequestParam("address") String address,
								  @RequestParam("phone") String phone) {
		Customer customer = new Customer(organizationName, nameManager,address, phone);
		customerService.saveCustomer(customer);
		return "redirect:/user/customers_all";
	}

	@RequestMapping(value = "/customer_delete/{customerId}", method = RequestMethod.GET)
	public String deleteGet(@PathVariable("customerId") long id) {
		Customer customer = customerService.getById(id);
		OrderDetails orderDetails = orderDetailsService.getByCustomer(customer);

		if (orderDetails != null) {
			return "redirect:/user/customers_all";
		}
		customerService.deleteCustomer(id);
		return "redirect:/user/customers_all";
	}
}
