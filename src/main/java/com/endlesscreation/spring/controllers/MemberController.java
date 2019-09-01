package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.models.Borrowing;
import com.endlesscreation.spring.models.Member;
import com.endlesscreation.spring.services.BorrowingService;
import com.endlesscreation.spring.services.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final BorrowingService borrowingService;

    public MemberController(MemberService memberService, BorrowingService borrowingService) {
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
    public int insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    @PutMapping
    public int updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @DeleteMapping("/{id}")
    public int deleteMember(@PathVariable("id") String id) {
        return memberService.deleteMember(id);
    }

    @GetMapping("{memberId}/borrowings")
    public List<Borrowing> getBorrowingList(@PathVariable("memberId") String memberId) {
        return borrowingService.getBorrowingsByMemberId(memberId);
    }

    @PostMapping("{memberId}/book/{bookId}")
    public int borrowBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
        return borrowingService.borrowBook(memberId, bookId);
    }

    @PutMapping("{memberId}/book/{bookId}")
    public int returnBook(@PathVariable("memberId") String memberId, @PathVariable("bookId") int bookId) {
        return borrowingService.returnBook(memberId, bookId);
    }

}