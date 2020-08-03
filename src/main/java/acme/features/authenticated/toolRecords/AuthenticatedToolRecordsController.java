
package acme.features.authenticated.toolRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.ToolRecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/tool-records/")
public class AuthenticatedToolRecordsController extends AbstractController<Authenticated, ToolRecords> {

	@Autowired
	private AuthenticatedToolRecordsListService	listService;

	@Autowired
	private AuthenticatedToolRecordsShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
