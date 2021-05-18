package com.costacarol.cloudnative.temafinal2.appmicroservice.feign;

import com.costacarol.cloudnative.temafinal2.appmicroservice.model.SongsPlaylistResponse;
import feign.Param;
import feign.RequestLine;

public interface AppMicroserviceFeign {

    @RequestLine("GET /playlist/get/{idPlaylist}")
    SongsPlaylistResponse getPlaylistSongs(@Param("idPlaylist") Integer idPlaylist);
}
