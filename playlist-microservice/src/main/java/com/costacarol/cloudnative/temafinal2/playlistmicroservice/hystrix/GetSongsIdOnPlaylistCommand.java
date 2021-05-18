package com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.SongPlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Collections;
import java.util.List;

public class GetSongsIdOnPlaylistCommand extends HystrixCommand<List<Integer>> {

    private Integer idPlaylist;
    private SongPlaylistRepository songPlaylistRepository;

    public GetSongsIdOnPlaylistCommand(Integer idPlaylist, SongPlaylistRepository songPlaylistRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( "GetSongsIdOnPlaylistCommand" ));
        this.idPlaylist = idPlaylist;
        this.songPlaylistRepository = songPlaylistRepository;
    }

    @Override
    protected List<Integer> run() throws Exception {
        return songPlaylistRepository.findByPlaylistId(idPlaylist);
    }

    @Override
    protected List<Integer> getFallback () {
        return Collections.emptyList();
    }
}