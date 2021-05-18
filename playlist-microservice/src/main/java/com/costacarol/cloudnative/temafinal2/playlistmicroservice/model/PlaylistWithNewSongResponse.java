package com.costacarol.cloudnative.temafinal2.playlistmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlaylistWithNewSongResponse {

    private SongPlaylist songPlaylist;

    @Override
    public String toString() {
        return "PlaylistWithNewSongResponse{" +
                "playlist=" + songPlaylist.getIdPlaylist() +
                "song=" + songPlaylist.getIdSong() +
                '}';
    }
}
