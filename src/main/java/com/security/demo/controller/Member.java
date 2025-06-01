package com.security.demo.controller;

import com.security.demo.dto.ItemDTO;
import com.security.demo.dto.MemberDTO;
import com.security.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Member {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members/search")
    public ResponseEntity<Page<MemberDTO>> searchItems(
            @RequestParam(required = false) String searchParam,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        Page<MemberDTO> response = memberService.getMembersBySearchParam(
                searchParam,
                pageNo,
                pageSize);
        return ResponseEntity.ok(response);
    }

}
