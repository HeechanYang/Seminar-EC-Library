package com.endlesscreation.spring.services;

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

    public List<Member> getAllMembers(){
        return memberMapper.getAllMembers();
    }

    public Member getMemberById(String id){
        return memberMapper.getMemberById(id);
    }

    public List<Member> getMembersByName(String name){
        return memberMapper.getMembersByName(name);
    }

    public int insertMember(Member member){
        return memberMapper.insertMember(member);
    }

    public int updateMember(Member member){
        return memberMapper.updateMember(member);
    }

    public int deleteMember(String id){
        return memberMapper.deleteMember(id);
    }
}
