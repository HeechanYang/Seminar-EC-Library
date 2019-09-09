package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.models.Member;
import com.endlesscreation.spring.services.in_memory.InMemoryBorrowingService;
import com.endlesscreation.spring.services.in_memory.InMemoryMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final InMemoryMemberService memberService;
    private final InMemoryBorrowingService borrowingService;

    public MemberController(InMemoryMemberService memberService, InMemoryBorrowingService borrowingService) {
        this.memberService = memberService;
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<Member> getAllMembers(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return memberService.getMembersByName(name);
        } else {
            return memberService.getAllMembers();
        }
    }

    @GetMapping("/{id}")
    public Member getMembersById(@PathVariable("id") String id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public SimpleResponse insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateMember(@PathVariable("id") String id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteMember(@PathVariable("id") String id) {
        return memberService.deleteMember(id);
    }

    @GetMapping("{memberId}/borrowings")
    public List<Borrowing> getBorrowingList(@PathVariable("memberId") String memberId) {
        return borrowingService.getBorrowingsByMemberId(memberId);
    }

    @PostMapping("{memberId}/book/{bookId}")
    public SimpleResponse borrowBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
        return borrowingService.borrowBook(memberId, bookId);
    }

    @PutMapping("{memberId}/book/{bookId}")
    public SimpleResponse returnBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
        return borrowingService.returnBook(memberId, bookId);
    }

}