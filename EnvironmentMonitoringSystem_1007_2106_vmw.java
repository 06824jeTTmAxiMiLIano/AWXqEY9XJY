// 代码生成时间: 2025-10-07 21:06:33
package com.example.environment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;
import java.util.Map;

// 数据库映射接口
@Mapper
public interface EnvironmentMapper {
    @Select("SELECT * FROM environment_data")
    List<Map<String, Object>> getAllData();

    @Insert("INSERT INTO environment_data (temperature, humidity, air_quality_index) VALUES (#{temperature}, #{humidity}, #{airQualityIndex})")
    void insertData(Map<String, Object> data);

    @Update("UPDATE environment_data SET temperature = #{temperature}, humidity = #{humidity} WHERE id = #{id}")
    void updateData(Map<String, Object> data);

    @Delete("DELETE FROM environment_data WHERE id = #{id}")
    void deleteData(int id);
}

// 环境监测服务类
public class EnvironmentService {
    private EnvironmentMapper environmentMapper;

    public EnvironmentService(EnvironmentMapper environmentMapper) {
        this.environmentMapper = environmentMapper;
    }

    // 获取所有环境监测数据
    public List<Map<String, Object>> getAllEnvironmentData() {
        try {
            return environmentMapper.getAllData();
        } catch (Exception e) {
            // 错误处理
            System.err.println("Error retrieving environment data: " + e.getMessage());
            return null;
        }
    }

    // 插入新的环境监测数据
    public void insertEnvironmentData(Map<String, Object> data) {
        try {
            environmentMapper.insertData(data);
        } catch (Exception e) {
            // 错误处理
            System.err.println("Error inserting environment data: " + e.getMessage());
        }
    }

    // 更新环境监测数据
    public void updateEnvironmentData(Map<String, Object> data) {
        try {
            environmentMapper.updateData(data);
        } catch (Exception e) {
            // 错误处理
            System.err.println("Error updating environment data: " + e.getMessage());
        }
    }

    // 删除环境监测数据
    public void deleteEnvironmentData(int id) {
        try {
            environmentMapper.deleteData(id);
        } catch (Exception e) {
            // 错误处理
            System.err.println("Error deleting environment data: " + e.getMessage());
        }
    }
}

// 环境监测系统主类
public class EnvironmentMonitoringSystem {
    public static void main(String[] args) {
        EnvironmentService environmentService = new EnvironmentService(new EnvironmentMapper());

        // 示例：插入一条环境监测数据
        Map<String, Object> data = Map.of(
            "temperature", 25.5,
            "humidity", 60.0,
            "airQualityIndex", 50
        );
        environmentService.insertEnvironmentData(data);

        // 示例：获取所有环境监测数据
        List<Map<String, Object>> dataList = environmentService.getAllEnvironmentData();
        dataList.forEach(dataMap -> System.out.println(dataMap));
    }
}
