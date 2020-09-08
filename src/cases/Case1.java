package cases;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
		SendMessage msg = new SendMessage();
		int userid = update.getMessage().getFrom().getId();
		msg.setChatId(Integer.toString(userid));
		msg.setText("case 1 works");
		sender.sendMessage(msg);
		userService.setUserState(userid, 0);
	}
	
}
