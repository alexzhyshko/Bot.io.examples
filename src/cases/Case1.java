package cases;

import org.telegram.telegrambots.meta.api.objects.Update;

import application.boilerplate.MessageSender;
import application.context.annotation.Case;
import application.context.annotation.Component;
import application.context.annotation.Inject;
import service.UserService;

@Component
@Case
public class Case1 {

	@Inject
	MessageSender sender;
	
	@Inject
	UserService userService;
	
	@Case(caseNumber=1)
	public void onRouteReceived(Update update) {
		int userid = update.getMessage().getFrom().getId();
		sender.setChatId(userid);
		sender.setText("case 1 works");
		sender.sendMessage();
		userService.setUserState(userid, 1);
	}
	
}
