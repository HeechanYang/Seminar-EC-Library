package com.endlesscreation.spring.mappers;

import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.models.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    public List<Member> getAllMembers();

    public Member getMemberById(String id);

    public List<Member> getMembersByName(String name);

    public int insertMember(Member member);

    public int updateMember(Member member);

    public int deleteMember(String id);

    public List<Borrowing> getBorrowingList(String memberId);

    public int borrowBook(@Param("memberId") String memberId, @Param("bookId") int bookId);

    public int returnBook(int borrowingId);
}
