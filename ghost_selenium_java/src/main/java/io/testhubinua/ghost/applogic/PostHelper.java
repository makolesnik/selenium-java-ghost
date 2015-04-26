package io.testhubinua.ghost.applogic;

import io.testhubinua.ghost.model.Post;

public interface PostHelper {

	void createNewPost(Post post) throws Exception;

	void publishPost() throws Exception;

	void draftPost();

	

}
