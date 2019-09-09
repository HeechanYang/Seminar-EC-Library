package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.services.in_memory.InMemoryBorrowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final InMemoryBorrowingService borrowingService;

    public BorrowingController(InMemoryBorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<Borrowing> getAllBorrowings(){
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{borrowingId}")
    public Borrowing getBorrowingById(@PathVariable("borrowingId") int borrowingId) {
        return borrowingService.getBorrowingById(borrowingId);
    }

    @DeleteMapping("/{borrowingId}")
    public SimpleResponse deleteBorrowing(@PathVariable("borrowingId") int borrowingId) {
        return borrowingService.deleteBorrowing(borrowingId);
    }

}