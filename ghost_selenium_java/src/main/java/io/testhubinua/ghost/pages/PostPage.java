package io.testhubinua.ghost.pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.testhubinua.ghost.model.Post;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class PostPage extends AnyPage {

	public PostPage(PageManager pages) {
		super(pages);
	}
	
	  public static String publishPostTextLink = "Publish Now";
	  public static String publishPostCss = ".post-save-publish";
	  public static String publishPostClassName = "post-save-publish";
	  public static String saveDraftTextLink = "Save Draft";
	  public static String deletePostTextLink = "Delete Page";
	  public static String notificationMessageClassName = "notification-message";
	  public static String postSettingsMenuClassName = "settings-menu-pane-in settings-menu settings-menu-pane";
	  public static String staticPageCheckboxXpath = ".//*[@id='entry-controls']/div[1]/div[2]/form/div[4]/label[1]/p";
	  public static String featureThisPostCheckboxXpath = "//*[@id=\"entry-controls\"]/div[1]/div[2]/form/div[4]/label[2]/p";
	  public static String featureThisPostCheckboxCss = ".checkbox>p";
	  public static String metaMenuClassName = "ember-view nav-list-item";
	  public static String metaMenuCss = ".ember-view.nav-list-item button";
	  
	  
	  @FindBy(className = "no-js desktop landscape")
	  private WebElement allWindow;
	  
	  
	  @FindBy(linkText = "NEW POST")
	  private WebElement NewPostButton;
	  
	  // Post Actions Menu
	  @FindBy(css = ".btn-blue.dropdown-toggle.up")
	  private WebElement postMenu;
	  
	  @FindBy(className = "post-save-publish")
	  private WebElement publishPost;
	  
	  @FindBy(className = "post-save-draft active")
	  private WebElement saveDraft;
	   
	  @FindBy(className = "delete")
	  private WebElement deletePost;
	  
	  // Post Content
	  @FindBy(id = "entry-title")
	  private WebElement titleField;
	  
	  @FindBy(css = "div.CodeMirror-code > pre")
	  private WebElement contentField;
	  
	  @FindBy(css = "div > textarea")
	  private WebElement contentTextArea;
	  
	  
	  @FindBy(id = "tags")
	  private WebElement tagField;
	  
	  @FindBy(className = "publish-bar-tags-input")
	  private WebElement tagInputField;
	  
	  @FindBy(className = "tag")
	  private WebElement createdTag;

	  @FindBy(className = "tag")
	  private List<WebElement> createdTags;
	  
	  @FindBy(css = "markdown-help")
	  private WebElement markdownHelpButton;
	  
	  @FindBy(css = "a.close")
	  private WebElement closeMarkdownHelp;
	  
	  // Post Setting Menu
	  @FindBy(xpath = ".//*[@id='publish-bar']/div/div/button")
	  private WebElement postSettingsButton;
	  
	  @FindBy(className = "settings-menu-pane-in settings-menu settings-menu-pane")
	  private WebElement postSettingsMenu;	
	  
	  @FindBy(css = "div.settings-menu-header button.close.icon-x.settings-menu-header-action")
	  private WebElement closePostSettingsButton;
	  
	  
	  
	  @FindBy(className = "media")
	  private WebElement uploadImage;
	  
	  @FindBy(name = "uploadimage")
	  private WebElement uploadImage1;
	  
	  
	  @FindBy(className = "image-url")
	  private WebElement imageUrlButton;
	  
	  @FindBy(css = ".image-uploader-url div.js-url input.url.js-upload-url")
	  private WebElement imageUrlField;
	  
	  @FindBy(className = "btn btn-blue js-button-accept")
	  private WebElement saveButton;
	  
	  @FindBy(xpath = "(//button[@type='button'])[2]")
	  private WebElement draftActionButton;
	  
	  @FindBy(xpath = ".//*[@id='entry-actions']/button[1]")
	  private WebElement publishActionButton;

	  @FindBy(xpath = ".//*[@id='entry-actions']/button")
	  private WebElement postActionButton;
	  
	  @FindBy(className = "notification-message")
	  private WebElement notificationMessage;
	  
	  
	  
	  
	  @FindBy(css = ".ember-view.js-post-image-upload.pre-image-uploader a.image-cancel.js-cancel")
	  private WebElement deleteImageButton;
	  
	  @FindBy(css = "input#url")
	  private WebElement postUrlField;
	  
	  @FindBy(css = "ghost-url-preview")
	  private WebElement postUrlPreview;
	  
	  @FindBy(id = "post-setting-date")
	  private WebElement publishDate;	
	  
	  @FindBy(id = "author-list")
	  private WebElement authorList;	
	  
	  
	  @FindBy(xpath = ".//*[@id='entry-controls']/div[1]/div[2]/form/div[4]/label[1]/span")
	  private WebElement staticPageCheckbox; 
	  
	  @FindBy(xpath = ".//*[@id='entry-controls']/div[1]/div[2]/form/div[4]/label[2]/span")
	  private WebElement featureThisPostCheckbox;	  
	  
	  // Meta Data
	  @FindBy(className = "ember-view nav-list-item")
	  private WebElement metaData; 
	  
	  @FindBy(css = ".ember-view.active div.settings-menu-header.subview button.back.icon-chevron-left.settings-menu-header-action")
	  private WebElement returnFromMetaButton; 
	  
	  
	  
	  @FindBy(id = "meta-title")
	  private WebElement metaTitleField;	  
	  
	  @FindBy(id = "meta-description")
	  private WebElement metaDescriptionField;	
	  
	  @FindBy(className = "seo-preview-title")
	  private WebElement seoPreviewTitle;	

	  @FindBy(className = "seo-preview-link")
	  private WebElement seoPreviewLink;
	  
	  @FindBy(className = "seo-preview-description")
	  private WebElement seoPreviewDescription;
	  
	  @FindBy(className = "word-count")
	  private List<WebElement> wordCount;
	  
	  @FindBy(className = "entry-word-count js-entry-word-count")
	  private WebElement contentWordCount;
	  
	  
	  
	  public WebElement getPostUrlPreview() {
		  return postUrlPreview;
		  }

	  public WebElement authorList() {
		  return authorList;
		  }
	  
	  
	  public PostPage clickNewPostButton() {
		  
		  NewPostButton.click();  
		  return this;
		  }
	  
	  public PostPage clickMarkdownHelpButton() {
		  markdownHelpButton.click();  
		  return this;
		  }
	  
	  public PostPage closeMarkdownHelp() {
		  closeMarkdownHelp.click();  
		  return this;
		  }
	  
	  public PostPage clickPostSettingsButton() {
		  postSettingsButton.click();  
		  return this;
		  }


	  public PostPage uploadImage(String filePath) {
		  wait.until(ExpectedConditions.elementToBeClickable(uploadImage));
		  wait.until(ExpectedConditions.visibilityOf(uploadImage1));
		  //uploadImage1.sendKeys(filePath);
		   //wait.until(ExpectedConditions.visibilityOf(deleteImageButton));
		  return this;
		  }
	  
	  public PostPage setImageUrl(String url) throws Exception {
		  wait.until(ExpectedConditions.elementToBeClickable(imageUrlButton));
		  imageUrlButton.click();
		  driver.findElement(By.cssSelector("input.url.js-upload-url")).clear();
		  driver.findElement(By.cssSelector("input.url.js-upload-url")).sendKeys(url + Keys.TAB + Keys.ENTER);
		  return this;
		  }

	  public PostPage clickDeleteImageButton() {
		  deleteImageButton.click();  
		  return this;
		  }
	  
	  
	  public PostPage setPostUrl(String url) {
		  postUrlField.click();
		  postUrlField.clear();
		  postUrlField.sendKeys(url);
		  return this;
		  }

	  public PostPage setPublishDate(String date) {
		  //Example: 11 Apr 15 @ 00:10
		  wait.until(ExpectedConditions.elementToBeClickable(publishDate));
		  publishDate.clear();
		  publishDate.clear();
		  publishDate.sendKeys(date);
		  return this;
		  }
	  
	  public PostPage clearTitleField() {
		  titleField.clear();  
		  return this;
		  }

	  
	  public PostPage fillTitleAndContentFields(String title, String content) {
		  ensurePageLoaded()
		  .clearTitleField()
		  .titleField.sendKeys(title + Keys.TAB + content);
		  return this;
		  }
	  
	  public WebElement createdTag() {
		  return createdTag;
		  }
	  
	  public WebElement tagInputField() {
		  return tagInputField;
		  }
	  
	  public PostPage addTag(String text) {
		  ensurePageLoaded();
		  wait.until(ExpectedConditions.visibilityOf(tagField));
		  tagField.click();
		  tagField.sendKeys(text + Keys.ENTER);
		  //wait.until(ExpectedConditions.visibilityOf(tagField));
		  //wait.until(ExpectedConditions.visibilityOf(createdTag));
		  return this;
		  }
	  
	  public PostPage deleteTag(String text) {
		  createdTag.click();
		  return this;
		  }


	  public PostPage selectStaticPageCheckbox() throws Exception {
		  if ( !staticPageCheckbox.isSelected() )
		    {
		
			  driver.findElement(By.xpath(staticPageCheckboxXpath)).click();
	        }
		  return this;
		  
	  	  }	  
	  
	  public PostPage selectFeatureThisPostCheckbox() throws Exception {
		  
		  if ( !featureThisPostCheckbox.isSelected() )
		     {
			  driver.findElement(By.xpath(featureThisPostCheckboxXpath)).click();
		     }
		  return this;
		  
	  	  }	  
	  	  
	  public void publishPost() {
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn-blue.dropdown-toggle.up")));
		  //wait.until(ExpectedConditions.elementToBeClickable(postMenu));
		 postMenu.click();
		 driver.findElement(By.className(publishPostClassName)).click();
		 //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='entry-actions']/button")));
		 wait.until(ExpectedConditions.elementToBeClickable(postActionButton));
		 postActionButton.click();
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.className(notificationMessageClassName)));
	  }

		public void draftPost() {
			 wait.until(ExpectedConditions.visibilityOf(postActionButton));
			 postActionButton.click();
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.className(notificationMessageClassName)));
		}
		
	  public void saveDraft() {
	  Select dropdown = new Select(postMenu);
		dropdown.selectByVisibleText(saveDraftTextLink);
	  }

	  public void deletePost() {
	  Select dropdown = new Select(postMenu);
		dropdown.selectByVisibleText(deletePostTextLink);
	  }
	  
	  public PostPage ensurePageLoaded() {
		    super.ensurePageLoaded();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("entry-title")));
		    return this;
		  }

	public List<WebElement> createdTags() {
		return createdTags;
	}

	public WebElement lastCreatedTag() {
		return createdTags.get(createdTags().size() - 1);
	}

	public void clickContentField() {
		contentField.click();
		
	}

	public void clickClosePostSettingsButton() {
		closePostSettingsButton.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(postSettingsMenuClassName)));
		
	}
	
	public void closePostSettingsMenu() {
		allWindow.click();
		allWindow.sendKeys(Keys.ESCAPE);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(postSettingsMenuClassName)));
	}

	public void selectAuthor(String author) {
		Select dropdown = new Select(authorList);
		dropdown.selectByVisibleText(author);
		
	}

	public void setMetaTitle(String metaTitle) {
		wait.until(ExpectedConditions.elementToBeClickable(metaTitleField));
		metaTitleField.clear();
		metaTitleField.sendKeys(metaTitle);
	}

	public void setMetaDescription(String metaDescription) {
		wait.until(ExpectedConditions.elementToBeClickable(metaDescriptionField));
		metaDescriptionField.clear();
		metaDescriptionField.sendKeys(metaDescription);
	}

	public void returnToPostFromMetaButton() {
		wait.until(ExpectedConditions.visibilityOf(returnFromMetaButton));
		returnFromMetaButton.click();
	}

	public void metaSettingsButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(metaMenuCss)));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(metaMenuCss))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(metaData));
		//metaData.click();
	}

}	