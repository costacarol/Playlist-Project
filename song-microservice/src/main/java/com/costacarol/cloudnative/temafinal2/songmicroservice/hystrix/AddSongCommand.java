package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;


public class AddSongCommand extends HystrixCommand<Object> {

    private final SongRepository songRepository;
    private final String title;
    private final String singer;

    public AddSongCommand(String title, String singer, SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( "AddSong" ));
        this.title = title;
        this.singer = singer;
        this.songRepository = songRepository;
    }

    @Override
    protected Object run() throws Exception {
        Songs song = new Songs(title, singer);
        songRepository.save(song);
        return song;
    }

    @Override
    protected Object getFallback () {
        return Optional.empty();
    }


}
