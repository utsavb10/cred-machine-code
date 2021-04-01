package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "api/")
public class AppController {



//    @GetMapping(path = "top-headlines", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<String>> get(@RequestParam(value = "sources", required = false) String sources,
//                                            @RequestParam(value = "q", required = false) String q,
//                                            @RequestParam(value = "language", required = false) String language,
//                                            @RequestParam(value = "country", required = false) String country,
//                                            @RequestParam(value = "category", required = false) String category,
//                                            @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                                            @RequestParam(value = "page", required = false) Integer page){
////        if(null == pageSize){
////            pageSize = 5;
////        }
////        if(null == page){
////            page = 1;
////        }
//        ResponseEntity responseEntity = null;
//
//
//        return responseEntity;
//    }
//
//    @GetMapping(path = "sources", produces = APPLICATION_JSON_VALUE)
//    public ResponseEntity<NewsResponse> getSources(@RequestParam(value = "language", required = false) String language,
//                                                   @RequestParam(value = "country", required = false) String country,
//                                                   @RequestParam(value = "category", required = false) String category){
//        ResponseEntity responseEntity = null;
//        try{
//            responseEntity =  ResponseEntity.status(200).body(newsServiceProxy.getSources(language, country, category).block());
//        } catch(Exception e){
//            if(e instanceof ResourceNotFoundException){
//                throw e;
//            }
//            throw new RequestException(e.getMessage());
//        }
//        return responseEntity;
//    }
//
//    @GetMapping(path = "everything", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getEverything(@RequestParam(value = "sources", required = false) String sources,
//                                           @RequestParam(value = "q", required = false) String q,
//                                           @RequestParam(value = "qInTitle", required = false) String qInTitle,
//                                           @RequestParam(value = "pageSize", required = false) Integer pageSize,
//                                           @RequestParam(value = "page", required = false) Integer page){
//        if(null == pageSize){
//            pageSize = 5;
//        }
//        if(null == page){
//            page = 1;
//        }
//        ResponseEntity responseEntity = null;
//
//            responseEntity =  ResponseEntity.status(200).body(newsServiceProxy.getEverything(sources, q, qInTitle, pageSize, page).block());
//
//        return responseEntity;
//    }
}
