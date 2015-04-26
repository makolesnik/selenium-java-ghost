package io.testhubinua.ghost.applogic;

public interface ApplicationManager {

	UserHelper getUserHelper();
	PostHelper getPostHelper();
    NavigationHelper getNavigationHelper();
    ClipboardHelper getClipboardHelper();


  void stop();


}
