// 代码生成时间: 2025-09-19 11:21:08
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.io.Resources;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {

    // Method to authenticate user with username and password
    public boolean authenticateUser(String username, String password) {
        try {
            // Load MyBatis configuration and SqlSessionFactory
            String resource = "mybatis-config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();

            // Prepare the map to hold the parameters for the query
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("username", username);
            parameters.put("password", password);

            // Select the user record from the database
            User user = session.selectOne("UserMapper.findUserByUsernameAndPassword", parameters);

            // Close the session
            session.close();

            // Check if user exists and password matches
            if (user != null && user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            // Handle any exceptions that occur during the authentication process
            e.printStackTrace();
            return false;
        }
    }

    // Inner class to represent a user
    private static class User {
        private String username;
        private String password;

        // Getters and Setters for username and password
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
