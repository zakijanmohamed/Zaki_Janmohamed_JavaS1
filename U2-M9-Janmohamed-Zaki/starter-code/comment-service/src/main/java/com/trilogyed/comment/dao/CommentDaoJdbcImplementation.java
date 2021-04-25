package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcImplementation implements CommentDao {

    public static final String ADD_COMMENT =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?, ?, ?, ?)";
    public static final String GET_COMMENT_BY_ID =
            "select * from comment where comment_id = ?";
    public static final String GET_ALL_COMMENTS =
            "select * from comment";
    public static final String GET_COMMENT_BY_POST_ID =
            "select * from comment where post_id = ?";
    public static final String UPDATE_COMMENT =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment = ? where comment_id = ?";
    public static final String DELETE_COMMENT =
            "delete from comment where comment_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoJdbcImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(ADD_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        comment.setCommentId(id);

        return comment;
    }

    @Override
    public Comment getComment(Integer commentId) {
        try {
            return jdbcTemplate.queryForObject(GET_COMMENT_BY_ID, this::MapRowToComment, commentId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Comment>getAllComments(){
        return jdbcTemplate.query(GET_ALL_COMMENTS, this::MapRowToComment);
    }

    @Override
    public List<Comment>getCommentsByPostId(Integer postId){
        return jdbcTemplate.query(GET_COMMENT_BY_POST_ID, this::MapRowToComment, postId);
    }

    @Override
    public void updateComment(Comment comment){
        jdbcTemplate.update(UPDATE_COMMENT,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId());
    }

    @Override
    public void deleteComment(Integer commentId){
        jdbcTemplate.update(DELETE_COMMENT,commentId);
    }

    private Comment MapRowToComment(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
}
