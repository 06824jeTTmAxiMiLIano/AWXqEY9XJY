// 代码生成时间: 2025-09-23 13:24:23
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CachingStrategy class demonstrates a basic caching implementation using MyBatis
public class CachingStrategy {

    private SqlSessionFactory sqlSessionFactory;

    // Constructor to initialize SqlSessionFactory
    public CachingStrategy() throws IOException {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    // Method to get data from the database with caching enabled
    public List<User> getUsersWithCaching() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<User> users = session.selectList("UserMapper.selectAllUsers", null, new RowBounds(0, 10));
            return users;
        }
    }

    // Method to update data in the database, which should trigger cache eviction
    public void updateUser(User user) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("UserMapper.updateUser", user);
            session.commit();
        }
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        CachingStrategy cachingStrategy = new CachingStrategy();
        try {
            List<User> users = cachingStrategy.getUsersWithCaching();
            users.forEach(System.out::println);

            User user = new User(1, "John Doe", 30);
            cachingStrategy.updateUser(user);

            // Fetch users after update to demonstrate cache behavior
            users = cachingStrategy.getUsersWithCaching();
            users.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// User class for demonstration purposes
class User {
    private int id;
    private String name;
    private int age;

    public User() {
        // Default constructor
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + '\'' + ", age=" + age + '}";
    }
}
