// 代码生成时间: 2025-10-13 02:09:29
package com.example.iot;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IoTGatewayManager {
    // Database connection properties
    private static final String URL = "jdbc:mysql://localhost:3306/iot_database";
    private static final String USER = "root";
    private static final String PASS = "password";

    // MyBatis configuration file path
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    private SqlSession sqlSession;

    // Constructor to initialize the SqlSessionFactory and SqlSession
    public IoTGatewayManager() {
        try {
            // Load MyBatis configuration file
            String resource = MYBATIS_CONFIG;
            Reader reader = Resources.getResourceAsReader(resource);
            // Build SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            // Open a session
            this.sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new IoT gateway
    public void addGateway(Gateway gateway) {
        try {
            sqlSession.insert("GatewayMapper.addGateway", gateway);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    // Method to remove an IoT gateway
    public void removeGateway(int gatewayId) {
        try {
            sqlSession.delete("GatewayMapper.removeGateway", gatewayId);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    // Method to update an IoT gateway
    public void updateGateway(Gateway gateway) {
        try {
            sqlSession.update("GatewayMapper.updateGateway", gateway);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        }
    }

    // Method to get an IoT gateway by ID
    public Gateway getGatewayById(int gatewayId) {
        try {
            return sqlSession.selectOne("GatewayMapper.getGatewayById", gatewayId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to close the SqlSession
    public void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    // Main method for testing the IoTGatewayManager
    public static void main(String[] args) {
        IoTGatewayManager manager = new IoTGatewayManager();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            Gateway gateway = new Gateway(1, "Gateway1", "192.168.1.100");
            manager.addGateway(gateway);
            manager.updateGateway(gateway);
            Gateway fetchedGateway = manager.getGatewayById(1);
            System.out.println("Fetched Gateway: " + fetchedGateway);
            manager.removeGateway(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            manager.close();
        }
    }
}

/*
 * Gateway.java
 *
 * Represents an IoT gateway entity.
 */
package com.example.iot;

public class Gateway {
    private int id;
    private String name;
    private String ipAddress;

    public Gateway() {
    }

    public Gateway(int id, String name, String ipAddress) {
        this.id = id;
        this.name = name;
        this.ipAddress = ipAddress;
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
    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
