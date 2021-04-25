package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;

import java.util.List;

public interface CommentDao {

    Comment addComment(Comment comment);
    Comment getComment (Integer commentId );
    List<Comment> getAllComments();
    List<Comment> getCommentsByPostId(Integer postId);
    void updateComment(Comment comment);
    void deleteComment(Integer commentId);

}
