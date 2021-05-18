package com.costacarol.cloudnative.temafinal2.playlistmicroservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @With
    private Integer id;
    private String title;

    public Playlist(String title){
        this.title = title;
    }
}
