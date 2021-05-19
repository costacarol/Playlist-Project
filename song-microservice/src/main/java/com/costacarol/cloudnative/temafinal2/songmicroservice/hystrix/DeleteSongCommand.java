package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


public class DeleteSongCommand extends HystrixCommand<Boolean>{

    private SongRepository songRepository;
    private Integer id;

    public DeleteSongCommand(Integer id, SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( " DeleteSong " ));
        this.id = id;
        this.songRepository = songRepository;
    }

    @Override
    protected Boolean run () {
        songRepository.deleteById(id);
        return true;
    }

    @Override
    protected Boolean getFallback () {
        return false;
    }
}

