package com.security.demo.service.impl;

import com.security.demo.dto.ItemDTO;
import com.security.demo.dto.MemberDTO;
import com.security.demo.entity.Item;
import com.security.demo.entity.Member;
import com.security.demo.mapper.MemberMapper;
import com.security.demo.repo.MemberRepo;
import com.security.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public Page<MemberDTO> getMembersBySearchParam(String searchParam,
                                                   int pageNo,
                                                   int pageSize
    ) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Member> members = memberRepo.findBySearchParam(searchParam, pageable);
        return members.map(memberMapper::toDTO);
    }
}
