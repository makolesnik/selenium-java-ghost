package io.testhubinua.ghost.applogic1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import io.testhubinua.ghost.applogic.PostHelper;
import io.testhubinua.ghost.model.Post;

public class PostHelper1 extends DriverBasedHelper implements PostHelper {

  public PostHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

@Override
public void createNewPost(Post post) throws Exception {
	pages.internalPage.ensurePageLoaded();
	pages.postPage.clickNewPostButton()
	.fillTitleAndContentFields(post.getTitle(), post.getContent());
	Thread.sleep(1000);
	for (String tag:post.getTags()){
		pages.postPage.addTag(tag);
		wait.until(ExpectedConditions.visibilityOfAllElements(pages.postPage.createdTags()));
		
		//wait.until(ExpectedConditions.visibilityOf(pages.postPage.tagInputField()));
		//wait.until(ExpectedConditions.textToBePresentInElement(pages.postPage.lastCreatedTag(), tag));
	}
	
	Thread.sleep(200);
	pages.postPage.clickPostSettingsButton();
	Thread.sleep(200);
	//Meta Settings Menu
		if ((!post.getMetaTitle().isEmpty()) || (!post.getMetaDescription().isEmpty())){	
			pages.postPage.metaSettingsButton();
			
			if (!post.getMetaTitle().isEmpty()){	
				pages.postPage.setMetaTitle(post.getMetaTitle());
			}
			if (!post.getMetaDescription().isEmpty()){	
				pages.postPage.setMetaDescription(post.getMetaDescription());
			}
			
			  pages.postPage.returnToPostFromMetaButton();
			 
		}
	//End of Meta Settings Menu

    //Post Settings Menu

    /*
	if (!post.getUploadImagePath().isEmpty()){	
		pages.postPage.uploadImage(post.getUploadImagePath());
	}
	*/
	
	
	if (!post.getUploadImageUrl().isEmpty()){	
		pages.postPage.setImageUrl(post.getUploadImageUrl());
	}
	Thread.sleep(200);
	if (!post.getPublishDate().isEmpty()){	
		pages.postPage.setPublishDate(post.getPublishDate());
		}
	//Thread.sleep(100);
	if (!post.getAuthor().isEmpty()){	
		pages.postPage.selectAuthor(post.getAuthor());
	}
	//Thread.sleep(100);
	if (!post.getStaticPageCheckbox() == false){	
		pages.postPage.selectStaticPageCheckbox();
	}
	
	if (!post.getFeatureThisPostCheckbox() == false){	
		pages.postPage.selectFeatureThisPostCheckbox();
	}
	//Thread.sleep(100);
	if (!post.getPostUrl().isEmpty()){	
		pages.postPage.setPostUrl(post.getPostUrl());
	}
	//Thread.sleep(1000);
   //End of Post Settings Menu

	pages.postPage.clickClosePostSettingsButton();
	//Thread.sleep(100);
}	



@Override
public void publishPost() throws Exception {
	
	pages.postPage.publishPost();
	
}

@Override
public void draftPost() {
	pages.postPage.draftPost();
	
}

/*
  @Override
  public void create(Post post) {
    // TODO Auto-generated method stub

  }
*/
  

}
