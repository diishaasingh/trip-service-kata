package org.craftedsw.tripservicekata.user;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	private User loggedUser;
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User user) {
		this.loggedUser = user;
	}

}
