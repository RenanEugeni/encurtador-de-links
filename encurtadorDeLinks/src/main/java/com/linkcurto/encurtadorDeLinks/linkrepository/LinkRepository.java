package com.linkcurto.encurtadorDeLinks.linkrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkcurto.encurtadorDeLinks.linkmodel.LinkModel;


@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Integer>{
    Optional<LinkModel> findByShortLink(String code);
}
