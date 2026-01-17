package com.linkcurto.encurtadorDeLinks.linkservice;


import java.net.URL;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linkcurto.encurtadorDeLinks.linkmodel.LinkModel;
import com.linkcurto.encurtadorDeLinks.linkrepository.LinkRepository;

@Service
public class LinkService {
    private final LinkRepository repository;

    public LinkService(LinkRepository linkrepository) {
        this.repository = linkrepository;
    }

    public LinkModel saveLink(LinkModel link){
        return repository.save(link);
    }

    public boolean isValid(LinkModel link){
        try{
            URL url = new URL(link.getOriginalLink());

            url.toURI();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public LinkModel createShortLink(LinkModel link){
        String code = Base64.getEncoder().encodeToString(link.getOriginalLink().getBytes());

        link.setShortLink(code);

        return link;
    }

    public LinkModel shortLinkProcces(String originalUrl){
        LinkModel link = new LinkModel();
        link.setOriginalLink(originalUrl);

        /*if(!isValid(link)){
            throw new IllegalArgumentException("Link Invalido!");
        }*/

        createShortLink(link);
        saveLink(link);

        return link;
    }

    public List<LinkModel> getAllLinks(){
        return repository.findAll();
    }

}
