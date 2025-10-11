// 代码生成时间: 2025-10-11 23:38:47
// TestDataGenerator.java
// 测试数据生成器，用于创建测试数据

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试数据生成器，用于创建和插入测试数据到数据库
 */
public class TestDataGenerator {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database"; // 更换为你的数据库地址
    private static final String USER = "your_user"; // 更换为你的数据库用户名
    private static final String PASSWORD = "your_password"; // 更换为你的数据库密码

    /**
     * 生成并插入测试数据到数据库
     * 
     * @param dataSize 要生成的数据量
     */
    public void generateTestData(int dataSize) {
        List<String> testData = generateData(dataSize);
        for (String data : testData) {
            insertData(data);
        }
    }

    /**
     * 生成测试数据
     * 
     * @param dataSize 要生成的数据量
     * @return 生成的数据列表
     */
    private List<String> generateData(int dataSize) {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            String data = "INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2')"; // 更换为你的表和列
            dataList.add(data);
        }
        return dataList;
    }

    /**
     * 插入数据到数据库
     * 
     * @param sql SQL 插入语句
     */
    private void insertData(String sql) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestDataGenerator generator = new TestDataGenerator();
        generator.generateTestData(100); // 生成100条测试数据
    }
}
