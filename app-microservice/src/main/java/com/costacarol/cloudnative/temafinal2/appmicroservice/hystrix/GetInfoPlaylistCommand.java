package com.costacarol.cloudnative.temafinal2.appmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.appmicroservice.feign.AppMicroserviceFeign;
import com.costacarol.cloudnative.temafinal2.appmicroservice.model.SongsPlaylistResponse;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import feign.Feign;
import feign.gson.GsonDecoder;

public class GetInfoPlaylistCommand extends HystrixCommand<Integer[]> {

    private Integer idPlaylist;
    private final String PLAYLIST_PORT = "8082";

    public GetInfoPlaylistCommand(Integer idPlaylist){
        super (HystrixCommandGroupKey.Factory.asKey("GetInfoPlaylistCommand"));
        this.idPlaylist = idPlaylist;
    }

    @Override
    protected Integer[] run() throws Exception {
        AppMicroserviceFeign appFeign = Feign.builder()
                .decoder(new GsonDecoder())
                .target(AppMicroserviceFeign.class, "http://localhost:"+ PLAYLIST_PORT);
        SongsPlaylistResponse songsPlaylist = appFeign.getPlaylistSongs(idPlaylist);
        return songsPlaylist.getIdSong();
    }

    @Override
    protected Integer[] getFallback() {
        return new Integer[0];
    }
}
