package com.costacarol.cloudnative.temafinal2.songmicroservice.controller;

import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.costacarol.cloudnative.temafinal2.songmicroservice.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/song")
public class SongController {

    private SongService songService;


    @PostMapping(path="/add/{title}")
    public ResponseEntity addNewSong (@PathVariable ("title") String title,
                                                @PathVariable ("String singer") String singer) {
        songService.addNewSong(title, singer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteSong (@PathVariable ("id") Integer id){
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/edit/{id}/{newTitle}")
    public ResponseEntity editSongTitle (@PathVariable ("id") Integer id,
                                         @PathVariable ("newTitle") String newTitle){
        songService.editSongTitle(id, newTitle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/detail/{idSong}")
    public ResponseEntity<Songs> listSong(@PathVariable("idSong") Integer idSong){
        return new ResponseEntity<>(songService.listSong(idSong).get(), HttpStatus.OK);
    }
}
