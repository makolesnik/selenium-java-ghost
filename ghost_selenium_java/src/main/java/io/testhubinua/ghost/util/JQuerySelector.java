package io.testhubinua.ghost.util;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
 
import java.util.List;
 
public class JQuerySelector extends By {
 
    private final String jQuerySelector;
 
    public JQuerySelector(String selector) {
        this(selector, true);
    }
 
    public JQuerySelector(String selector, boolean visible) {
        this.jQuerySelector = selector + (visible ? ":visible" : "");
    }
 
    @Override
    public List<WebElement> findElements(SearchContext context) {
        return (List<WebElement>) findWithJQuery(context, true);
    }
 
    @Override
    public WebElement findElement(SearchContext context) {
        return (WebElement) findWithJQuery(context, false);
    }
 
    private Object findWithJQuery(SearchContext context, boolean returnList) {
        String getArgument = returnList ? "" : "0";
 
        if (context instanceof RemoteWebElement) {
            WebDriver driver = ((RemoteWebElement) context).getWrappedDriver();
 
            return ((JavascriptExecutor) driver).executeScript("return $(arguments[0]).find('" + escape(jQuerySelector) + "').get(" + getArgument + ");", context);
        }
 
        return ((JavascriptExecutor) context).executeScript("return $('" + escape(jQuerySelector) + "').get(" + getArgument + ");");
    }
 
    @Override
    public String toString() {
        return "By.jQuerySelector: " + jQuerySelector;
    }
    
    private String escape(String s) {
        return s.replace("'", "\\'");
    }
}