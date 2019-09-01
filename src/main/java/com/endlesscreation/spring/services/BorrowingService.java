package com.endlesscreation.spring.services;

import com.endlesscreation.spring.mappers.BookMapper;
import com.endlesscreation.spring.mappers.BorrowingMapper;
import com.endlesscreation.spring.mappers.MemberMapper;
import com.endlesscreation.spring.models.Borrowing;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {

    private final BorrowingMapper borrowingMapper;
    private final MemberMapper memberMapper;
    private final BookMapper bookMapper;

    public BorrowingService(BorrowingMapper borrowingMapper, MemberMapper memberMapper, BookMapper bookMapper) {
        this.borrowingMapper = borrowingMapper;
        this.memberMapper = memberMapper;
        this.bookMapper = bookMapper;
    }

    public List<Borrowing> getAllBorrowings() {
        List<Borrowing> borrowingList = borrowingMapper.getAllBorrowings();
        return setMemberAndBook(borrowingList);
    }

    public Borrowing getBorrowingById(int borrowingId) {
        Borrowing borrowing = borrowingMapper.getBorrowingById(borrowingId);
        if (borrowing != null) {
            borrowing.setMember(memberMapper.getMemberById(borrowing.getMemberId()));
            borrowing.setBook(bookMapper.getBookById(borrowing.getBookId()));
        }
        return borrowing;
    }

    public List<Borrowing> getBorrowingsByMemberId(String memberId) {
        List<Borrowing> borrowingList = borrowingMapper.getBorrowingsByMemberId(memberId);
        return setMemberAndBook(borrowingList);
    }

    public List<Borrowing> getBorrowingsByBookId(int bookId) {
        List<Borrowing> borrowingList = borrowingMapper.getBorrowingsByBookId(bookId);
        return setMemberAndBook(borrowingList);
    }

    public int borrowBook(String memberId, int bookId) {
        if (!isStillOut(bookId)) {
            return borrowingMapper.borrowBook(memberId, bookId);
        } else {
            return -1;
        }
    }

    public int returnBook(@Param("memberId") String memberId, @Param("bookId") int bookId) {
        if (isStillOut(bookId)) {
            return borrowingMapper.returnBook(memberId, bookId);
        } else {
            return -1;
        }
    }

    public int deleteBorrowing(int borrowingId) {
        return borrowingMapper.deleteBorrowing(borrowingId);
    }

    public boolean isStillOut(int bookId) {
        return borrowingMapper.isStillOut(bookId) > 0;
    }

    private List<Borrowing> setMemberAndBook(List<Borrowing> borrowingList) {
        for (Borrowing borrowing : borrowingList) {
            borrowing.setMember(memberMapper.getMemberById(borrowing.getMemberId()));
            borrowing.setBook(bookMapper.getBookById(borrowing.getBookId()));
        }
        return borrowingList;
    }
}
