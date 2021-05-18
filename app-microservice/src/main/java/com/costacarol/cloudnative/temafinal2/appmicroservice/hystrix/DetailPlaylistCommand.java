package com.costacarol.cloudnative.temafinal2.appmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.appmicroservice.model.PlaylistSongs;
import com.costacarol.cloudnative.temafinal2.appmicroservice.model.Song;
import com.costacarol.cloudnative.temafinal2.appmicroservice.ribbon.RibbonClass;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DetailPlaylistCommand extends HystrixCommand<Optional<PlaylistSongs>> {

    private RibbonClass ribbonClass;
    private Integer idPlaylist;
    private Integer[] listInfoPlaylist;


    public DetailPlaylistCommand(Integer idPlaylist, RibbonClass ribbonClass, Integer[] listInfoPlaylist){
        super (HystrixCommandGroupKey.Factory.asKey( "DetailPlaylistCommand" ));
        this.listInfoPlaylist = listInfoPlaylist;
        this.idPlaylist = idPlaylist;
        this.ribbonClass = ribbonClass;
    }

    @Override
    protected Optional<PlaylistSongs> run() throws Exception {
        List<Song> songs = new ArrayList<>();
        for (Integer idSong: listInfoPlaylist) {
            songs.add(ribbonClass.callService(idSong));
        }
        return Optional.of(new PlaylistSongs(idPlaylist, songs));
    }

    @Override
    protected Optional<PlaylistSongs> getFallback() {
        return Optional.empty();
    }
}
