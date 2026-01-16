package com.linkcurto.encurtadorDeLinks.linkservice;


import com.linkcurto.encurtadorDeLinks.linkmodel.LinkModel;
import com.linkcurto.encurtadorDeLinks.linkrepository.LinkRepository;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Base64;

@Service
public class LinkService {
    private final LinkRepository repository;

    public LinkService(LinkRepository linkrepository) {
        this.repository = linkrepository;
    }

    public LinkModel saveNewLink(LinkModel link){
        repository.save(link);
        return link;
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

    @

}
