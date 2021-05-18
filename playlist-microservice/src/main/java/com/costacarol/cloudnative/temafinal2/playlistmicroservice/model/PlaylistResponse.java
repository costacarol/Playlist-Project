package com.costacarol.cloudnative.temafinal2.playlistmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaylistResponse {

    private Playlist playlist;

    @Override
    public String toString() {
        return "New playlist created{" +
                "id='" + playlist.getId() + '\'' +
                ", title='" + playlist.getTitle() + '\'' +
                '}';
    }
}
