package io.testhubinua.ghost.model;

import java.util.List;

public class Post {
	private String title;
	private String content;
	private List<String> tags;
	private String publishDate;
	private String uploadImagePath;
	private String uploadImageUrl;
	private String postUrl;
	private String author;
	private boolean staticPageCheckbox;
	private boolean featureThisPostCheckbox;
	private String metaTitle;
	private String metaDescription;

	
	public String getTitle() {
		return title;
	}
	public Post setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public String getContent() {
		return content;
	}
	public Post setContent(String content) {
		this.content = content;
		return this;
	}		
	public List <String> getTags() {
		return tags;
	}
	public Post setTags(List <String> tags) {
		this.tags = tags;
		return this;
	}		

	public String getPublishDate() {
		return publishDate;
	}
	public Post setPublishDate(String publishDate) {
		this.publishDate = publishDate;
		return this;	
    }

	public String getUploadImagePath() {
		return uploadImagePath;
	}
	public Post setUploadImagePath(String uploadImagePath) {
		this.uploadImagePath = uploadImagePath;
		return this;	
    }	
	
	public String getUploadImageUrl() {
		return uploadImageUrl;
	}
	public Post setUploadImageURL(String uploadImageUrl) {
		this.uploadImageUrl = uploadImageUrl;
		return this;	
    }		

	public String getPostUrl() {
		return postUrl;
	}
	public Post setPostUrl(String postUrl) {
		this.postUrl = postUrl;
		return this;	
    }

	public String getAuthor() {
		return author;
	}
	public Post setAuthor(String author) {
		this.author = author;
		return this;	
    }

	public String getMetaTitle() {
		return metaTitle;
	}
	
	public Post setMetaTitle(String metaTitle) {
		this.metaTitle = metaTitle;
		return this;	
    }
	public String getMetaDescription() {
		return metaTitle;
	}
	
	public Post setMetaDescription(String MetaDescription) {
		this.metaDescription = metaDescription;
		return this;	
    }
		
	
	public boolean getStaticPageCheckbox() {
		return staticPageCheckbox;
	}
	
	public Post setStaticPageCheckbox() {
		this.staticPageCheckbox = true;
		return this;	
    }

	public Post removeStaticPageCheckbox() {
		this.staticPageCheckbox = false;
		return this;	
    }
	
	public boolean getFeatureThisPostCheckbox() {
		return featureThisPostCheckbox;
	}
	
	public Post setFeatureThisPostCheckbox() {
		this.featureThisPostCheckbox = true;
		return this;	
    }	
	public Post removeFeatureThisPostCheckbox() {
		this.featureThisPostCheckbox = false;
		return this;	
    }		
}	