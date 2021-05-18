package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;


public class DeleteSongCommand extends HystrixCommand<Optional>{

    private SongRepository songRepository;
    private Integer id;

    public DeleteSongCommand(Integer id, SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( " DeleteSong " ));
        this.id = id;
        this.songRepository = songRepository;
    }

    @Override
    protected Optional run () {
        songRepository.deleteById(id);
        return Optional.empty();
    }

    @Override
    protected  Optional getFallback () {
        return Optional.empty();
    }
}

