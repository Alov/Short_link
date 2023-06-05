package me.alov.demo.service;

import me.alov.demo.domain.ShortLink;
import me.alov.demo.dto.ShortLinkDto;
import me.alov.demo.repository.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {

    @Autowired
    private ShortLinkRepository shortLinkRepository;

    public ShortLinkDto create(ShortLinkDto dto) {
        ShortLink entity = shortLinkRepository.save(new ShortLink(dto.getCode(), dto.getFullLink()));
        return new ShortLinkDto(entity.getId(), entity.getCode(), entity.getFullLink());
    }

    public String findRedirectLink(String code) {
        ShortLink shortLink = shortLinkRepository.findShortLinkByCode(code);
        return shortLink.getFullLink();
    }
}
