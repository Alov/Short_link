package me.alov.demo.controller;

import me.alov.demo.dto.ShortLinkDto;
import me.alov.demo.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/s")
public class ShortLinkController {


    @Autowired
    private ShortLinkService shortLinkService;


    @PostMapping
    public ResponseEntity create(@RequestBody ShortLinkDto dto) {
        return ResponseEntity.ok(shortLinkService.create(dto));
    }

    @GetMapping("/{code}")
    public ResponseEntity getRedirect(@PathVariable String code) {
        String redirectLink = shortLinkService.findRedirectLink(code);
        return ResponseEntity.status(302).header("Location", redirectLink).build();
    }

}
