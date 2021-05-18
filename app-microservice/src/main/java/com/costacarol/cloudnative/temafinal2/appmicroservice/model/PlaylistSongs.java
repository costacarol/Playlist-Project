package com.costacarol.cloudnative.temafinal2.appmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlaylistSongs {

    private Integer id;
    private List<Song> songs;

}
