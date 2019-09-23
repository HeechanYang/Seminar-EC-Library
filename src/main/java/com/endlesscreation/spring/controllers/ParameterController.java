package com.endlesscreation.spring.controllers;

import com.endlesscreation.spring.models.Member;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/params")
public class ParameterController {

    // query
    // localhost:8080/params?query=abcdabcd&page=2
    @GetMapping("/query")
    public String query(@RequestParam String query, @RequestParam int page){
        return "[Query]" + "\n" +
                "query : " + query + "\n" +
                "page : " + page;
    }

    // path
    // /path/검색어를 입력해주세요/2
    @GetMapping("/path/{query}/{page}")
    public String path(@PathVariable String query, @PathVariable int page){
        return "[Path Variable]" + "\n" +
                "query : " + query + "\n" +
                "page : " + page;
    }

    // body
    @PostMapping("/body")
    public String body(@RequestBody Member member){
        return "[Body]" + "\n" +
                "id : " + member.getId() + "\n" +
                "name : " + member.getName() + "\n" +
                "contacts : " + member.getContacts();
    }

}
