package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcImplementation implements PostDao {


    public static final String ADD_POST =
            "insert into post (post_date, poster_name, post) values (?, ?, ?)";
    public static final String GET_POST_BY_ID =
            "select * from post where post_id = ?";
    public static final String GET_ALL_POSTS =
            "select * from post";
    public static final String GET_POST_BY_POSTER =
            "select * from post where poster_name = ?";
    public static final String UPDATE_POST =
            "update post set post_date = ?, poster_name = ?, post = ? where post_id = ?";
    public static final String DELETE_POST =
            "delete from post where post_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJdbcImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Post addPost(Post post) {
        jdbcTemplate.update(ADD_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        post.setPostId(id);

        return post;
    }

    @Override
    public Post getPost(Integer postId) {
        try {
            return jdbcTemplate.queryForObject(GET_POST_BY_ID, this::MapRowToPost, postId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> getAllPosts(){
        return jdbcTemplate.query(GET_ALL_POSTS, this::MapRowToPost);
    }

    @Override
    public List<Post> getPostByPoster(String posterName){
        return jdbcTemplate.query(GET_POST_BY_POSTER, this::MapRowToPost, posterName);
    }

    @Override
    public void updatePost(Post post){
        jdbcTemplate.update(UPDATE_POST,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostId());
    }
    @Override
    public void deletePost(Integer postId){
        jdbcTemplate.update(DELETE_POST,postId);
    }


        private Post MapRowToPost(ResultSet rs, int rowNum) throws SQLException {

        Post post = new Post();
        post.setPostId(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
}
