package io.testhubinua.ghost;

import io.testhubinua.ghost.model.Post;
import io.testhubinua.ghost.util.ExcelUtils1;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublishPostTest extends io.testhubinua.ghost.pages.TestBase {

	
	  @BeforeMethod
	  public void mayBeLogout() {
		app.getNavigationHelper().openLoginPage();
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	
	  
	  @Test(dataProvider = "getPostData")
	  	public void publishPost(String title, String content, String tags, String publishDate, 
	    		String uploadImagePath, String uploadImageUrl, String postUrl, String author,
	    		String staticPageCheckbox,	String featureThisPostCheckbox, 
	    		String metaTitle, String metaDescription)  throws Exception {
		// Prepare the post	
	    		Post post = new Post().setTitle(System.currentTimeMillis() + title)
					.setContent(content)
					.setTags(Arrays.asList(tags))
					.setUploadImagePath(uploadImagePath)
					.setUploadImageURL(uploadImageUrl)
					.setPostUrl(postUrl)
					.setPublishDate(publishDate)
					.setAuthor(author)
					.setMetaTitle(metaTitle)
					.setMetaDescription(metaDescription);
			post.setStaticPageCheckbox();
			post.setFeatureThisPostCheckbox();
				   
			app.getUserHelper().loginAs(OWNER);
			app.getPostHelper().createNewPost(post);
			app.getPostHelper().publishPost();
		  }

	    
	   @Test(dataProvider = "getPostData")
	    public void draftPost(String title, String content, String tags, String publishDate, 
	    		String uploadImagePath, String uploadImageUrl, String postUrl, String author,
	    		String staticPageCheckbox,	String featureThisPostCheckbox, 
	    		String metaTitle, String metaDescription)  throws Exception {
		   
			// Prepare the post	
	   		Post post = new Post().setTitle(System.currentTimeMillis() + title)
					.setContent(content)
					.setTags(Arrays.asList(tags))
					.setUploadImagePath(uploadImagePath)
					.setUploadImageURL(uploadImageUrl)
					.setPostUrl(postUrl)
					.setPublishDate(publishDate)
					.setAuthor(author)
					.setMetaTitle(metaTitle)
					.setMetaDescription(metaDescription);
			post.setStaticPageCheckbox();
			post.setFeatureThisPostCheckbox();
			   
		app.getUserHelper().loginAs(OWNER);
		app.getPostHelper().createNewPost(post);
		app.getPostHelper().draftPost();
	  }

	   
	   @DataProvider
	    public Object[][]  getPostData() throws Exception{
	         Object[][] testObjArray = ExcelUtils1.getTableArray(System.getProperty("user.dir")+"//src//test//resources//testData//PublishPostTest.xlsx", "publish", 1, 1, 12);
	         return (testObjArray);
			}	
}	    

	  