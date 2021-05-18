package com.costacarol.cloudnative.temafinal2.songmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Songs {

    @Id @With
    private Integer id;
    private String title;
    private String singer;

    public Songs(String title, String singer){
        this.title = title;
        this.singer = singer;
    }
}
