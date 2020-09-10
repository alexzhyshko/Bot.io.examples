package cases;

import org.telegram.telegrambots.meta.api.objects.Update;

import application.boilerplate.MessageSender;
import application.context.annotation.Component;
import application.context.annotation.Inject;
import service.UserService;

@Component
public class Case0 {

	@Inject
	MessageSender sender;
	
	@Inject
	UserService userService;
	
	public void onRouteReceived(Update update) {
		int userid = update.getMessage().getFrom().getId();
		sender.setChatId(userid);
		sender.setText("case 0 works");
		sender.sendMessage();
		userService.setUserState(userid, 1);
	}
	
}
