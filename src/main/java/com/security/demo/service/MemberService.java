package com.security.demo.service;

import com.security.demo.dto.ItemDTO;
import com.security.demo.dto.MemberDTO;
import com.security.demo.entity.Member;
import org.springframework.data.domain.Page;

public interface MemberService {

    Page<MemberDTO> getMembersBySearchParam(
            String searchParam,
            int pageNo,
            int pageSize
    );
}
