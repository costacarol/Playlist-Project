package com.costacarol.cloudnative.temafinal2.songmicroservice.controller;

import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.costacarol.cloudnative.temafinal2.songmicroservice.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/song")
public class SongController {

    private final SongService songService;


    @PostMapping(path="/{title}")
    public ResponseEntity<Object> addNewSong (@PathVariable ("title") String title,
                                              @PathVariable ("String singer") String singer) {
        return new ResponseEntity<>(songService.addNewSong(title, singer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteSong (@PathVariable ("id") Integer id){
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}/{newTitle}")
    public ResponseEntity<Object> editSongTitle (@PathVariable ("id") Integer id,
                                                 @PathVariable ("newTitle") String newTitle){
        return new ResponseEntity<>(songService.editSongTitle(id, newTitle), HttpStatus.OK);
    }

    @GetMapping(path = "/detail/{idSong}")
    public ResponseEntity<Object> listSong(@PathVariable("idSong") Integer idSong){
        return new ResponseEntity<>(songService.listSong(idSong), HttpStatus.OK);
    }
}
