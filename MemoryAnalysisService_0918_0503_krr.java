// 代码生成时间: 2025-09-18 05:03:45
// MemoryAnalysisService.java
package com.example.memoryanalysis;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class to analyze memory usage.
 *
 * Provides methods to retrieve and analyze memory usage statistics.
 */
public class MemoryAnalysisService {

    private final MemoryMXBean memoryMXBean;

    /**
     * Constructor initializing the MemoryMXBean.
     */
    public MemoryAnalysisService() {
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
    }

    /**
     * Retrieves the current memory usage statistics.
     *
     * @return A map containing memory usage statistics in a human-readable format.
     */
    public Map<String, String> getMemoryUsage() {
        Map<String, String> memoryStats = new HashMap<>();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        memoryStats.put("Heap Used", String.format("%.2f MB", heapMemoryUsage.getUsed() / (1024 * 1024.0)));
        memoryStats.put("Heap Committed", String.format("%.2f MB", heapMemoryUsage.getCommitted() / (1024 * 1024.0)));
        memoryStats.put("Heap Max", String.format("%.2f MB", heapMemoryUsage.getMax() / (1024 * 1024.0)));
        memoryStats.put("Heap Init", String.format("%.2f MB", heapMemoryUsage.getInit() / (1024 * 1024.0)));

        memoryStats.put("Non-Heap Used", String.format("%.2f MB", nonHeapMemoryUsage.getUsed() / (1024 * 1024.0)));
        memoryStats.put("Non-Heap Committed", String.format("%.2f MB", nonHeapMemoryUsage.getCommitted() / (1024 * 1024.0)));
        memoryStats.put("Non-Heap Max", String.format("%.2f MB", nonHeapMemoryUsage.getMax() / (1024 * 1024.0)));
        memoryStats.put("Non-Heap Init", String.format("%.2f MB", nonHeapMemoryUsage.getInit() / (1024 * 1024.0)));

        return memoryStats;
    }

    /**
     * Prints the memory usage statistics to the console.
     *
     * @param memoryStats The memory usage statistics to print.
     */
    public void printMemoryUsage(Map<String, String> memoryStats) {
        for (Map.Entry<String, String> entry : memoryStats.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * Main method to test the MemoryAnalysisService.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        MemoryAnalysisService service = new MemoryAnalysisService();
        Map<String, String> memoryStats = service.getMemoryUsage();
        service.printMemoryUsage(memoryStats);
    }
}
