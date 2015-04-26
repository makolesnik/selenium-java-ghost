package io.testhubinua.ghost.applogic1;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import io.testhubinua.ghost.applogic.ClipboardHelper;
import io.testhubinua.ghost.applogic.UserHelper;

public class ClipboardHelper1 extends DriverBasedHelper implements ClipboardHelper {

	  public ClipboardHelper1(ApplicationManager1 manager) {
	    super(manager.getWebDriver());
	  }

	  /**
	  * When you do a cut or copy of text in the operating system, the text is
	  * stored in the clipboard.
	  *
	  * The following method returns the content that is currently in the
	  * clipboard.
	  *
	  */
	  
	@Override
	public String getClipboardData() {
		String clipboardText;
		Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard()
		.getContents(null);
		try {
		if (trans != null
		&& trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		clipboardText = (String) trans
		.getTransferData(DataFlavor.stringFlavor);
		return clipboardText;
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
	
	/**
	* This method will set any parameter string to the system's clipboard.
	*/
	@Override
	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
		stringSelection, null);
	}

}
