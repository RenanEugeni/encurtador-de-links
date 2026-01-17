package com.linkcurto.encurtadorDeLinks.linkcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkcurto.encurtadorDeLinks.linkmodel.LinkModel;
import com.linkcurto.encurtadorDeLinks.linkservice.LinkService;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @PostMapping
    public ResponseEntity<LinkModel> generateNewLink(@RequestBody String originalUrl){
        LinkModel link = linkService.shortLinkProcces(originalUrl);
        return ResponseEntity.status(HttpStatus.CREATED).body(link);
        
    }

    @GetMapping
    public ResponseEntity<List<LinkModel>> getAllLinks(){
        return new ResponseEntity<>(linkService.getAllLinks(), HttpStatus.OK);
    }
}
