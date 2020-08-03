
package acme.features.administrator.overtures;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.Overtures;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/overtures/")
public class AdministratorOverturesController extends AbstractController<Administrator, Overtures> {

	@Autowired
	private AdministratorOverturesListService	listService;

	@Autowired
	private AdministratorOverturesShowService	showService;

	@Autowired
	private AdministratorOverturesCreateService	createService;

	@Autowired
	private AdministratorOverturesUpdateService	updateService;

	@Autowired
	private AdministratorOverturesDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}
