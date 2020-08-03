
package acme.features.administrator.inquiries;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.Inquiries;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/inquiries/")
public class AdministratorInquiriesController extends AbstractController<Administrator, Inquiries> {

	@Autowired
	private AdministratorInquiriesListService	listService;

	@Autowired
	private AdministratorInquiriesShowService	showService;

	@Autowired
	private AdministratorInquiriesCreateService	createService;

	@Autowired
	private AdministratorInquiriesUpdateService	updateService;

	@Autowired
	private AdministratorInquiriesDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
