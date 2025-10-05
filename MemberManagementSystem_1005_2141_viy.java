// 代码生成时间: 2025-10-05 21:41:40
package com.example.membersystem;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import com.example.membersystem.model.Member;
import com.example.membersystem.mapper.MemberMapper;

/**
 * This class represents the Member Management System using the MYBATIS framework.
 * It provides functionality to perform CRUD operations on members.
 */
public class MemberManagementSystem {

    private SqlSessionFactory sqlSessionFactory;
    private MemberMapper memberMapper;

    /**
     * Constructor to initialize the SQL session factory.
     * @param sqlSessionFactoryPath Path to the mybatis configuration file.
     */
    public MemberManagementSystem(String sqlSessionFactoryPath) {
        try {
            Reader reader = Resources.getResourceAsReader(sqlSessionFactoryPath);
            this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Error initializing SQL Session Factory", e);
        }
    }

    /**
     * Get a list of all members.
     * @return A list of member objects.
     */
    public List<Member> getAllMembers() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            memberMapper = session.getMapper(MemberMapper.class);
            return memberMapper.selectAllMembers();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving members", e);
        }
    }

    /**
     * Add a new member to the system.
     * @param member The member object to be added.
     * @return The ID of the newly added member.
     */
    public int addMember(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            memberMapper = session.getMapper(MemberMapper.class);
            int id = memberMapper.insertMember(member);
            session.commit();
            return id;
        } catch (Exception e) {
            throw new RuntimeException("Error adding member", e);
        }
    }

    /**
     * Update an existing member's information.
     * @param member The member object with updated information.
     */
    public void updateMember(Member member) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            memberMapper = session.getMapper(MemberMapper.class);
            memberMapper.updateMember(member);
            session.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error updating member", e);
        }
    }

    /**
     * Delete a member from the system.
     * @param id The ID of the member to be deleted.
     */
    public void deleteMember(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            memberMapper = session.getMapper(MemberMapper.class);
            memberMapper.deleteMember(id);
            session.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error deleting member", e);
        }
    }

    public static void main(String[] args) {
        MemberManagementSystem system = new MemberManagementSystem("mybatis-config.xml");
        // Example usage of the system.
        Member newMember = new Member(null, "John Doe", "john@example.com");
        int memberId = system.addMember(newMember);
        System.out.println("Added Member: " + memberId);

        // Update member's email.
        newMember.setEmail("john_updated@example.com");
        system.updateMember(newMember);
        System.out.println("Updated Member's Email");

        // Delete the member.
        system.deleteMember(memberId);
        System.out.println("Deleted Member");
    }
}
