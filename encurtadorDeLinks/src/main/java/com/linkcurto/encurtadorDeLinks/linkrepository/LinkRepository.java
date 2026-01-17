package com.linkcurto.encurtadorDeLinks.linkrepository;

import com.linkcurto.encurtadorDeLinks.linkmodel.LinkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkModel, Integer>{
}
