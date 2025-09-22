// 代码生成时间: 2025-09-23 00:49:25
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ThemeSwitchService {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * Constructor to initialize the SqlSessionFactory.
     * @param sqlSessionFactory The SqlSessionFactory to be used for database operations.
     */
    public ThemeSwitchService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * Switches the theme for a given user.
     * @param userId The ID of the user whose theme is to be switched.
     * @param newTheme The new theme to be applied.
     * @return true if the theme switch was successful, false otherwise.
     * @throws Exception If any error occurs during the database operation.
     */
    public boolean switchTheme(int userId, String newTheme) throws Exception {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ThemeMapper themeMapper = session.getMapper(ThemeMapper.class);
            return themeMapper.updateTheme(userId, newTheme);
        } catch (Exception e) {
            // Log the exception and re-throw to handle it at a higher level.
            e.printStackTrace();
            throw new Exception("Error switching theme.", e);
        }
    }
}

/**
 * ThemeMapper.java
 * Mapper interface for theme operations.
 */
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ThemeMapper {

    /**
     * Updates the theme for a user in the database.
     * @param userId The ID of the user.
     * @param newTheme The new theme to be applied.
     * @return The number of rows affected by the update.
     */
    @Update("UPDATE users SET theme = #{newTheme} WHERE id = #{userId}")
    int updateTheme(int userId, String newTheme);
}
