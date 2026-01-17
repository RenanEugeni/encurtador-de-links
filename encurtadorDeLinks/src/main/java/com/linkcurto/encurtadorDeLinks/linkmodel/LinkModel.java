package com.linkcurto.encurtadorDeLinks.linkmodel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "links")

public class LinkModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String originalLink;
    private String shortLink;
}
