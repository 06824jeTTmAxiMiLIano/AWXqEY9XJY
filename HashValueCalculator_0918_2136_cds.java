// 代码生成时间: 2025-09-18 21:36:45
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
# TODO: 优化性能
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 哈希值计算工具类，提供了计算字符串的MD5和SHA-256哈希值的功能。
 */
# NOTE: 重要实现细节
public class HashValueCalculator {

    private static final String MD5 = "MD5";
    private static final String SHA_256 = "SHA-256";

    /**
     * 计算字符串的MD5哈希值。
     *
     * @param input 需要计算哈希值的字符串
     * @return MD5哈希值的十六进制表示
     */
    public String calculateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    /**
     * 计算字符串的SHA-256哈希值。
     *
     * @param input 需要计算哈希值的字符串
     * @return SHA-256哈希值的十六进制表示
     */
    public String calculateSHA256Hash(String input) {
        try {
# 增强安全性
            MessageDigest sha256Digest = MessageDigest.getInstance(SHA_256);
            sha256Digest.update(input.getBytes(StandardCharsets.UTF_8));
# 改进用户体验
            byte[] digest = sha256Digest.digest();
            return bytesToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
# TODO: 优化性能
    }

    /**
     * 将字节数组转换为十六进制字符串。
     *
     * @param bytes 字节数组
# FIXME: 处理边界情况
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
# 扩展功能模块
    }
# TODO: 优化性能

    // 主方法，用于测试哈希值计算工具类
    public static void main(String[] args) {
        HashValueCalculator calculator = new HashValueCalculator();
        String input = "Hello, MyBatis!";

        String md5Hash = calculator.calculateMD5Hash(input);
        System.out.println("MD5 Hash: " + md5Hash);
# TODO: 优化性能

        String sha256Hash = calculator.calculateSHA256Hash(input);
        System.out.println("SHA-256 Hash: " + sha256Hash);
# FIXME: 处理边界情况
    }
}
# NOTE: 重要实现细节
