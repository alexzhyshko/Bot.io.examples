package main.filter;

import org.telegram.telegrambots.meta.api.objects.Update;

import application.boilerplate.MessageSender;
import application.context.annotation.Component;
import application.context.annotation.Filter;
import application.context.annotation.Inject;
import application.context.filter.FilterAdapter;
import application.exception.FilterException;

@Component
@Filter(order=1, enabled=true)
public class DummyFilter implements FilterAdapter{

	@Inject
	private MessageSender sender;
	
	@Override
	public Update filter(Update update) throws FilterException {
		int userid = -1;
		if(update.getMessage()!=null) {
			userid = update.getMessage().getFrom().getId();
		}else {
			userid = update.getCallbackQuery().getFrom().getId();
		}
		sender.setChatId(userid);
		sender.setText("dummy filter");
		sender.sendMessage();
		return update;
	}
	
}
