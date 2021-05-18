package com.costacarol.cloudnative.temafinal2.playlistmicroservice.controller;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.PlaylistResponse;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.PlaylistWithNewSongResponse;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.SongPlaylistResponse;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.SongPlaylistRepository;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/playlist")
public class PlaylistController {

    PlaylistService playlistService;
    SongPlaylistRepository songPlaylistRepository;

    @PostMapping(path = "/add/{title}")
    public ResponseEntity<Object> addNewPlaylist(@PathVariable("title") String playlistTitle){
        return new ResponseEntity<>(new PlaylistResponse(playlistService.addNewPlaylist(playlistTitle).get()), HttpStatus.OK);
    }

    @PostMapping(path = "/add/playlist/{idPlaylist}/song/{idSong}")
    public ResponseEntity<Object> addNewSongOnPlaylist(@PathVariable("idPlaylist") Integer idPlaylist,
                                                       @PathVariable("idSong") Integer idSong) {
        return new ResponseEntity<>(new PlaylistWithNewSongResponse(playlistService.addSongOnPlaylist(idPlaylist, idSong).get()), HttpStatus.OK);
    }

    @GetMapping(path = "/get/{idPlaylist}")
    public ResponseEntity<Object> getSongsIdOnPlaylist(@PathVariable("idPlaylist") Integer idPlaylist){
        return new ResponseEntity<>(new SongPlaylistResponse(playlistService.getSongsIdOnPlaylist(idPlaylist)), HttpStatus.OK);
    }
}
