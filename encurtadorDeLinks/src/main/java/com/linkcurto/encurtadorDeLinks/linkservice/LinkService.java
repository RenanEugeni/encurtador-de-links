package com.linkcurto.encurtadorDeLinks.linkservice;


import java.util.List;
import java.util.Optional;

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
        code = Math.abs(code);
        link.setShortLink(Integer.toString(code));

        return link;
    }

    public LinkModel shortLinkProcces(String originalUrl){
        if(originalUrl.isEmpty()|| originalUrl == null){
            throw new IllegalArgumentException("Input invalido");
        }
        LinkModel link = new LinkModel();
        link.setOriginalLink(originalUrl);

        createShortLink(link);
        saveLink(link);

        return link;
    }

    public List<LinkModel> getAllLinks(){
        return repository.findAll();
    }

    public LinkModel getOriginalLink(String code){
        Optional<LinkModel> linkOptional = repository.findByShortLink(code);
        if(linkOptional.isPresent()){
            return linkOptional.get();
        } else {
            throw new RuntimeException("URL não encontrada");
        }
    }

}
