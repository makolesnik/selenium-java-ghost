package io.testhubinua.ghost.applogic;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.testhubinua.ghost.model.User;

public interface UserHelper {

	void loginAs(User user);
	void logout();
	boolean isNotLoggedIn();
	void copyTextToCipboardById(String IdLocator);
	void copyTextToCipboardByCss(String cssLocator);
	void ensureLoginAs(User user, ApplicationManager app);
	void ensurePageContainsText(String text);
	void loginAsPastePasswd(User user, String pattern, Integer length,
			ApplicationManager app);
	void pasteTextFromCipboardByCss(String cssLocator);
	void pasteTextFromCipboardByName(String nameLocator);
	void loginAsPasteEmail(User user, String string, Integer i,
			ApplicationManager app);
	void ensureNotificationMessageIsPresent();
	void addNewUser(User user);
	void ensureUserIsAddedAs(User user);
	int countInvitedUsers();
	int countConfirmedUsers();
	void revokeUser();
	void resendUser();
	void goToUserManagementPage();
	void ensurePageContainsText(String text, String text1);
	void deleteUser(String user);
	List<WebElement> invitedUsersList();

	

}
