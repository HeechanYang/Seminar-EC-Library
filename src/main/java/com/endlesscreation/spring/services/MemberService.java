package com.endlesscreation.spring.services;

import com.endlesscreation.spring.models.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private List<Member> members;

    public MemberService() {
        members = new ArrayList<>();
    }

    public List<Member> getAllMembers() {
        return this.members;
    }

    public Member getMemberById(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                return members.get(i);
            }
        }

        return null;
    }

    public List<Member> getMembersByName(String name) {
        List<Member> result = new ArrayList<>();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().contains(name)) {
                result.add(members.get(i));
            }
        }

        return result;
    }

    public int insertMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(member.getId())) {
                // 이미 존재하는 id면 -1 반환
                return -1;
            }
        }

        members.add(member);

        return members.size();
    }

    public int updateMember(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(member.getId())) {
                members.get(i).setName(member.getName());
                members.get(i).setContacts(member.getContacts());
                // 업데이트 되었으면 index 반환
                return i;
            }
        }

        // 업데이트된 것이 없으면 0 반환
        return 0;
    }

    public int deleteMember(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(id)) {
                members.remove(i);
                // 삭제 되었으면 index 반환
                return i;
            }
        }

        // 삭제된 것이 없으면 0 반환
        return 0;
    }

//    private final MemberMapper memberMapper;
//
//    public MemberService(MemberMapper memberMapper) {
//        this.memberMapper = memberMapper;
//    }
//
//    public List<Member> getAllMembers(){
//        return memberMapper.getAllMembers();
//    }
//
//    public Member getMemberById(String id){
//        return memberMapper.getMemberById(id);
//    }
//
//    public List<Member> getMembersByName(String name){
//        return memberMapper.getMembersByName(name);
//    }
//
//    public int insertMember(Member member){
//        return memberMapper.insertMember(member);
//    }
//
//    public int updateMember(Member member){
//        return memberMapper.updateMember(member);
//    }
//
//    public int deleteMember(String id){
//        return memberMapper.deleteMember(id);
//    }
}
