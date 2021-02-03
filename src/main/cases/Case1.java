package main.cases;

import org.telegram.telegrambots.meta.api.objects.Update;

import application.boilerplate.MessageDeleter;
import application.boilerplate.MessageEditor;
import application.boilerplate.MessageSender;
import application.context.annotation.Callback;
import application.context.annotation.Component;
import application.context.annotation.Inject;
import application.context.annotation.State;
import application.routing.RouterManager;
import application.session.SessionManager;

@Component
@State(1)
public class Case1 {

	@Inject
	MessageSender sender;

	@Inject
	MessageDeleter deleter;
	
	@Inject
	MessageEditor editor;

	@Inject
	SessionManager sessionManager;

	@Inject
	private RouterManager router;

	@Callback(command = "test_inline")
	public void c(Update update) {
		int userid = update.getCallbackQuery().getFrom().getId();
		deleter.setChatId(userid);
		deleter.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
		deleter.deleteMessage();
//		editor.setChatId(userid);
//		editor.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
//		editor.setText("New inline");
//		editor.setInlineButtons(Arrays.asList(new InlineButton("New inline", "new_inline")));
//		editor.sendMessage();
		
		router.routeCallbackToClass(userid, Case0.class);
	}

}
