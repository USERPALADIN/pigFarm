package com.univercity.controllers;

import com.univercity.model.Associate;
import com.univercity.model.OrderDetails;
import com.univercity.service.interfaces.AssociateService;
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
public class AssociateController {

	private final AssociateService associateService;

	private final OrderDetailsService orderDetailsService;

	@Autowired
	public AssociateController(AssociateService associateService, OrderDetailsService orderDetailsService) {
		this.associateService = associateService;
		this.orderDetailsService = orderDetailsService;
	}

	@RequestMapping(value = "/associates_all", method = RequestMethod.GET)
	public String getAssociatesAll(Model model) {
		model.addAttribute("associates", associateService.getAllAssociates());
		return "associates";
	}

	@RequestMapping(value = "/associate_insert", method = RequestMethod.POST)
	public String insertAssociate(@RequestParam("name") String name,
								  @RequestParam("date") String date,
								  @RequestParam("address") String address,
								  @RequestParam("phone") String phone) {
		Associate associate = new Associate(name, date, address, phone);
		associateService.saveAssociate(associate);
		return "redirect:/user/associates_all";
	}

	@RequestMapping(value = "/associate_delete/{associateId}", method = RequestMethod.GET)
	public String deleteGet(@PathVariable("associateId") long id) {

		Associate associate = associateService.getById(id);
		OrderDetails orderDetails = orderDetailsService.getByAssociate(associate);

		if (orderDetails != null) {
			return "redirect:/user/associates_all";
		}
		associateService.deleteAssociate(id);
		return "redirect:/user/associates_all";
	}

	@RequestMapping(value = "/associate_update", method = RequestMethod.POST)
	public String updatePost(@RequestParam("associateId") long id, @RequestParam("name") String name,
							 @RequestParam("date") String date, @RequestParam("address") String address,
							 @RequestParam("phone") String phone) {

		Associate associate = new Associate(name, date, address, phone);
		associate.setId(id);
		associateService.updateAssociate(associate);
		return "redirect:/user/associates_all";
	}
}
