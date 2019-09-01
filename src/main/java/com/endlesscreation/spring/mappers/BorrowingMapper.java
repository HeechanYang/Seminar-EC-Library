package com.endlesscreation.spring.mappers;

import com.endlesscreation.spring.models.Borrowing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BorrowingMapper {

    public List<Borrowing> getAllBorrowings();

    public Borrowing getBorrowingById(int borrowingId);

    public List<Borrowing> getBorrowingsByMemberId(String memberId);

    public List<Borrowing> getBorrowingsByBookId(int bookId);

    public int isStillOut(int bookId);

    public int borrowBook(@Param("memberId") String memberId, @Param("bookId") int bookId);

    public int returnBook(@Param("memberId") String memberId, @Param("bookId") int bookId);

    public int deleteBorrowing(int borrowingId);
}
