
package acme.features.entrepreneur.applications;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/entrepreneur/application/")
public class EntrepreneurApplicationController extends AbstractController<Entrepreneur, Application> {

	@Autowired
	private EntrepreneurApplicationListService	listService;

	@Autowired
	private EntrepreneurApplicationShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_INVESTMENT_ROUNDS_APP, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
