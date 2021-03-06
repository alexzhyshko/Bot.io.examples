package main.service;


import java.util.HashMap;

import application.adapters.UserServiceAdapter;
import application.context.annotation.Component;

@Component
public class UserService implements UserServiceAdapter{

	HashMap<Integer, Integer> cases = new HashMap<>();

	@Override
    public int getUserState(int userid) {
		if (cases.get(userid) == null) {
			setUserState(userid, 0);
		}
		return cases.get(userid);
	}

	@Override
    public void setUserState(int userid, int state) {
		cases.put(userid, state);
	}
	
}
