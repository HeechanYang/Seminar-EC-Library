package com.endlesscreation.spring.services;

import com.endlesscreation.spring.dtos.SimpleResponse;
import com.endlesscreation.spring.mappers.MemberMapper;
import com.endlesscreation.spring.models.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> getAllMembers() {
        return memberMapper.getAllMembers();
    }

    public Member getMemberById(String id) {
        return memberMapper.getMemberById(id);
    }

    public List<Member> getMembersByName(String name) {
        return memberMapper.getMembersByName(name);
    }

    public SimpleResponse insertMember(Member member) {
        int result = memberMapper.insertMember(member);
        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }

    public SimpleResponse updateMember(Member member) {
        int result = memberMapper.updateMember(member);
        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }

    public SimpleResponse deleteMember(String id) {
        int result = memberMapper.deleteMember(id);
        return result > 0 ? SimpleResponse.SUCCESS : SimpleResponse.FAIL;
    }
}
