package me.alov.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "short_link")
public class ShortLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "full_link", length = 1000)
    private String fullLink;

    public ShortLink(String code, String fullLink) {
        this.code = code;
        this.fullLink = fullLink;
    }
}
