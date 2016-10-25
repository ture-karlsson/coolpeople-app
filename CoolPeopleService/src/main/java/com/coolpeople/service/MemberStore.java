package com.coolpeople.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;


@Singleton
public class MemberStore {
    
    private List<Member> members = new ArrayList();
    
    public void addMember(Member member){
        members.add(member);
    }
    
    public List<Member> getMembers(){
        return members;
    }

}
