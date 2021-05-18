package com.costacarol.cloudnative.temafinal2.playlistmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SongPlaylistResponse {

    private List<Integer> idSong;

}
