package com.linkcurto.encurtadorDeLinks.linkservice;


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


    public LinkModel createShortLink(LinkModel link){
        int code = link.getOriginalLink().hashCode();

        link.setShortLink(Integer.toString(code));

        return link;
    }

    public LinkModel shortLinkProcces(String originalUrl){
        LinkModel link = new LinkModel();
        link.setOriginalLink(originalUrl);

        createShortLink(link);
        saveLink(link);

        return link;
    }

    public List<LinkModel> getAllLinks(){
        return repository.findAll();
    }

}
