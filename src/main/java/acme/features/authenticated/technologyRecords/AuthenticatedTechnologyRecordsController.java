
package acme.features.authenticated.technologyRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.TechnologyRecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/technology-records/")
public class AuthenticatedTechnologyRecordsController extends AbstractController<Authenticated, TechnologyRecords> {

	@Autowired
	private AuthenticatedTechnologyRecordsListService	listService;

	@Autowired
	private AuthenticatedTechnologyRecordsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
