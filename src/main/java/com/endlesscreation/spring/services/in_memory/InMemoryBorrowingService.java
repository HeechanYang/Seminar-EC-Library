package com.endlesscreation.spring.services.in_memory;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.models.Book;
import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.models.Member;
import com.endlesscreation.spring.services.BookService;
import com.endlesscreation.spring.services.MemberService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InMemoryBorrowingService {

    private static final int DUE_DATE = 7;

    private final MemberService memberService;
    private final BookService bookService;

    private List<Borrowing> borrowings;
    private int autoIncrementId;

    public InMemoryBorrowingService(MemberService memberService, BookService bookService) {
        this.memberService = memberService;
        this.bookService = bookService;
        this.borrowings = new ArrayList<>();
        this.autoIncrementId = 1;
    }


    public List<Borrowing> getAllBorrowings() {
        return this.borrowings;
    }

    public Borrowing getBorrowingById(int borrowingId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId() == borrowingId) {
                return borrowing;
            }
        }

        return null;
    }

    public List<Borrowing> getBorrowingsByMemberId(String memberId) {
        return borrowings.stream().filter(o -> o.getMemberId().equals(memberId)).collect(Collectors.toList());
    }

    public List<Borrowing> getBorrowingsByBookId(int bookId) {
        return borrowings.stream().filter(o -> o.getBookId() == bookId).collect(Collectors.toList());
    }

    public SimpleResponse borrowBook(String memberId, int bookId) {
        if (!isStillOut(bookId)) {
            Member member = memberService.getMemberById(memberId);
            Book book = bookService.getBookById(bookId);

            if (member != null && book != null) {
                LocalDateTime now = LocalDateTime.now();
                LocalDateTime expiryDateTime = now.plusDays(DUE_DATE);

                Borrowing borrowing = new Borrowing(autoIncrementId++, memberId, bookId,
                        now, expiryDateTime, null, member, book);

                this.borrowings.add(borrowing);
                return SimpleResponse.SUCCESS;
            }

            return SimpleResponse.FAIL;
        } else {
            return SimpleResponse.FAIL;
        }
    }

    public SimpleResponse returnBook(@Param("memberId") String memberId, @Param("bookId") int bookId) {
        if (isStillOut(bookId)) {
            for (Borrowing borrowing : borrowings) {
                if (borrowing.getMemberId().equals(memberId) && borrowing.getBookId() == bookId) {
                    borrowing.setReturnTime(LocalDateTime.now());
                    return SimpleResponse.SUCCESS;
                }
            }
            return SimpleResponse.FAIL;
        } else {
            return SimpleResponse.FAIL;
        }
    }

    public SimpleResponse deleteBorrowing(int borrowingId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getId() == borrowingId) {
                borrowings.remove(borrowing);
                return SimpleResponse.SUCCESS;
            }
        }
        return SimpleResponse.NOTHING;
    }

    private boolean isStillOut(int bookId) {
        for (Borrowing borrowing : borrowings) {
            if (borrowing.getBookId() == bookId) {
                return borrowing.getReturnTime() != null;
            }
        }

        return false;
    }
}
