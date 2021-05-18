package com.costacarol.cloudnative.temafinal2.appmicroservice.controller;

import com.costacarol.cloudnative.temafinal2.appmicroservice.model.PlaylistSongs;
import com.costacarol.cloudnative.temafinal2.appmicroservice.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/app")
public class AppController {

   private AppService appService;

    @GetMapping(path = "/get/{idPlaylist}")
    public ResponseEntity<PlaylistSongs> listSong(@PathVariable("idPlaylist") Integer idPlaylist){
        return new ResponseEntity<>(appService.detailPlaylist(idPlaylist).get(), HttpStatus.OK);
    }
}