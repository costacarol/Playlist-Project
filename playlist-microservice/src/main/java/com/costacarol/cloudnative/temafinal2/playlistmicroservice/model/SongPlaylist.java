package com.costacarol.cloudnative.temafinal2.playlistmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongPlaylist {

    @Id @With
    private Integer id;
    private Integer idPlaylist;
    private Integer idSong;


    public SongPlaylist(Integer idPlaylist, Integer idSong){
        this.idPlaylist = idPlaylist;
        this.idSong = idSong;
    }

}
