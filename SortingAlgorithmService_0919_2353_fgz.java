// 代码生成时间: 2025-09-19 23:53:43
package com.example.service;

import java.util.Arrays;
import java.util.List;
# NOTE: 重要实现细节
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
# 增强安全性
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
# 优化算法效率

public class SortingAlgorithmService {
    
    private SqlSessionFactory sqlSessionFactory;
    
    public SortingAlgorithmService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
# 改进用户体验
    }
    
    /**
     * Returns a sorted list of integers using bubble sort algorithm.
     * 
     * @param list Unsorted list of integers.
     * @return Sorted list of integers.
     */
    public List<Integer> bubbleSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
# 增强安全性
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }
    
    /**
     * Returns a sorted list of integers using selection sort algorithm.
     * 
     * @param list Unsorted list of integers.
     * @return Sorted list of integers.
     */
    public List<Integer> selectionSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
# TODO: 优化性能
        }
        
        for (int i = 0; i < list.size() - 1; i++) {
# NOTE: 重要实现细节
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(minIndex)) {
# 优化算法效率
                    minIndex = j;
                }
            }
            // Swap elements
            int temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
# NOTE: 重要实现细节
        }
        return list;
    }
    
    /**
     * Returns a sorted list of integers using insertion sort algorithm.
# NOTE: 重要实现细节
     * 
     * @param list Unsorted list of integers.
# FIXME: 处理边界情况
     * @return Sorted list of integers.
     */
    public List<Integer> insertionSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
# 扩展功能模块
        
        for (int i = 1; i < list.size(); i++) {
            int key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
# 添加错误处理
        }
        return list;
# 改进用户体验
    }
# 改进用户体验
    
    /**
     * Returns a sorted list of integers using quick sort algorithm.
     * 
# 增强安全性
     * @param list Unsorted list of integers.
     * @return Sorted list of integers.
# NOTE: 重要实现细节
     */
# FIXME: 处理边界情况
    public List<Integer> quickSort(List<Integer> list) {
# NOTE: 重要实现细节
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }
        
        return quickSort(list, 0, list.size() - 1);
    }
    
    private List<Integer> quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
# FIXME: 处理边界情况
            quickSort(list, pivotIndex + 1, high);
        }
        return list;
    }
    
    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                i++;
                // Swap elements
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        // Swap elements
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
# 优化算法效率
        return i + 1;
    }
    
    public static void main(String[] args) {
        // Initialize MyBatis SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        
        // Create an instance of SortingAlgorithmService
        SortingAlgorithmService sortingService = new SortingAlgorithmService(sqlSessionFactory);
        
        // Unsorted list of integers
        List<Integer> unsortedList = Arrays.asList(5, 3, 8, 4, 2);
        
        System.out.println("Unsorted List: " + unsortedList);
        
        // Sort list using bubble sort algorithm
        List<Integer> sortedList = sortingService.bubbleSort(unsortedList);
        System.out.println("Sorted List (Bubble Sort): " + sortedList);
        
        // Sort list using selection sort algorithm
        sortedList = sortingService.selectionSort(unsortedList);
        System.out.println("Sorted List (Selection Sort): " + sortedList);
        
        // Sort list using insertion sort algorithm
# NOTE: 重要实现细节
        sortedList = sortingService.insertionSort(unsortedList);
        System.out.println("Sorted List (Insertion Sort): " + sortedList);
        
        // Sort list using quick sort algorithm
        sortedList = sortingService.quickSort(unsortedList);
        System.out.println("Sorted List (Quick Sort): " + sortedList);
    }
}
