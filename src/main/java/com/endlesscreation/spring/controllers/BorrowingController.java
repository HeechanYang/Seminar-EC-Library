package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.services.BorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping("")
    public List<Borrowing> getAllBorrowings(){
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{borrowingId}")
    public Borrowing getBorrowingById(@PathVariable("borrowingId") int borrowingId) {
        return borrowingService.getBorrowingById(borrowingId);
    }

    @DeleteMapping("/{borrowingId}")
    public int deleteBorrowing(@PathVariable("borrowingId") int borrowingId) {
        return borrowingService.deleteBorrowing(borrowingId);
    }

}
