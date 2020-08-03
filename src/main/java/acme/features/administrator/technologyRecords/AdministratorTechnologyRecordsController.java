
package acme.features.administrator.technologyRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.TechnologyRecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/technology-records/")
public class AdministratorTechnologyRecordsController extends AbstractController<Administrator, TechnologyRecords> {

	@Autowired
	private AdministratorTechnologyRecordsListService	listService;

	@Autowired
	private AdministratorTechnologyRecordsShowService	showService;

	@Autowired
	private AdministratorTechnologyRecordsCreateService	createService;

	@Autowired
	private AdministratorTechnologyRecordsUpdateService	updateService;

	@Autowired
	private AdministratorTechnologyRecordsDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}
}