package com.penglecode.gulubala.service.url;
/**
 * 音乐评论服务URL
 * 
 * @author  pengpeng
 * @date 	 2015年8月17日 上午10:30:29
 * @version 1.0
 */
public interface MusicCommentServiceURL {

	/** 创建评论 */
	String URL_MUSIC_COMMENT_CREATE = "comment/create";
	
	/** 获取用户的评论列表 */
	String URL_MUSIC_COMMENT_LIST_USER = "comment/list4user/{userId}/{commentType}";
	
	/** 获取歌曲/歌单的评论列表 */
	String URL_MUSIC_COMMENT_LIST_MUSIC = "comment/list4music/{commentType}/{commentId}";
	
	/** 删除用户评论 */
	String URL_MUSIC_COMMENT_DELETE = "comment/delete/{id}";
	
	/** 点赞用户评论 */
	String URL_MUSIC_COMMENT_PRAISE = "comment/praise/{id}";
	
}
