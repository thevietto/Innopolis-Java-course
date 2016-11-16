package inno.repository.impl;

import inno.model.Post;
import inno.repository.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcRepository implements PostRepository {

    private final String URL = "jdbc:postgresql://localhost:5432/blog";
    private final String USER = "vietto";
    private final String PASSWORD = "postgres";

    public JdbcRepository() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Post> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT id, title, text, creationDate FROM post");
            resultSet = statement.executeQuery();

            List<Post> result = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setTitle(resultSet.getString("title"));
                post.setText(resultSet.getString("text"));
                post.setDate(resultSet.getDate("creationDate"));
                result.add(post);
            }

            return result;
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public Post find(Long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT id, title, text, creationDate FROM post WHERE id = ?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getLong("id"));
                post.setTitle(resultSet.getString("title"));
                post.setText(resultSet.getString("text"));
                post.setDate(resultSet.getDate("creationDate"));
                return post;
            }

            return null;
        } catch (Exception e) {
            return null;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public boolean add(Post post) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO post(id, title, text, creationdate) VALUES (nextval('post_seq'), ?, ?, ?)");
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getText());
            statement.setDate(3, new Date(post.getDate().getTime()));

            return statement.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
