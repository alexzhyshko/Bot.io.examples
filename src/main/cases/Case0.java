package main.cases;


import java.util.Arrays;

import org.telegram.telegrambots.meta.api.objects.Update;

import application.boilerplate.MessageEditor;
import application.boilerplate.MessageSender;
import application.boilerplate.dto.InlineButton;
import application.context.annotation.Callback;
import application.context.annotation.Case;
import application.context.annotation.Component;
import application.context.annotation.Inject;
import application.context.annotation.State;
import application.routing.RouterManager;
import application.session.SessionManager;

@Component
@State(0)
public class Case0 {

	@Inject
	private MessageSender sender;
	
	@Inject
	private MessageEditor editor;
	
	@Inject
	private SessionManager sessionManager;
	
	@Inject
	private RouterManager router;
	
	
	@Case
	public void a(Update update) {
		int userid = update.getMessage().getFrom().getId();
		sender.setChatId(userid);
		sender.setText("Test inline");
		sender.setInlineButtons(Arrays.asList(new InlineButton("Test inline", "test_inline")));
		sender.sendMessage();
		router.routeCallbackToClass(userid, Case1.class);
	}
	
	@Callback(command="new_inline")
	public void t(Update update) {
		int userid = update.getCallbackQuery().getFrom().getId();
		editor.setChatId(userid);
		editor.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
		editor.setText("Test inline");
		editor.setInlineButtons(Arrays.asList(new InlineButton("Test inline", "test_inline")));
		editor.editMessage();
		router.routeCallbackToClass(userid, Case1.class);
	}
	
}
