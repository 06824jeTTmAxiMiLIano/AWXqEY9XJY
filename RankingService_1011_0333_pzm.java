// 代码生成时间: 2025-10-11 03:33:19
package com.example.service;

import com.example.mapper.RankingMapper;
import com.example.model.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 排行榜服务类
 */
@Service
public class RankingService {

    /**
     * MyBatis映射器接口
     */
    @Autowired
    private RankingMapper rankingMapper;

    /**
     * 获取排行榜数据
     *
     * @return 排行榜列表
     */
    @Transactional(readOnly = true)
    public List<Ranking> getRankingList() {
        try {
            return rankingMapper.selectRankingList();
        } catch (Exception e) {
            // 错误处理
            // 这里可以根据需要记录日志或者抛出自定义异常
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * 排行榜映射器接口
 */
package com.example.mapper;

import com.example.model.Ranking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * MyBatis Mapper接口定义
 */
@Mapper
public interface RankingMapper {

    /**
     * 查询排行榜数据
     *
     * @return 排行榜列表
     */
    @Select("SELECT * FROM ranking ORDER BY score DESC")
    List<Ranking> selectRankingList();
}

/**
 * 排行榜实体类
 */
package com.example.model;

public class Ranking {

    private Long id;
    private String name;
    private Integer score;

    // 省略getter和setter方法
}
