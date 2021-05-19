package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Collections;

public class ReadAllSongsCommand extends HystrixCommand<Iterable<Songs>> {

    private final SongRepository songRepository;

    public ReadAllSongsCommand(SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( "ReadAllSongs" ));
        this.songRepository = songRepository;
    }

    @Override
    protected Iterable<Songs> run() throws Exception {
        return songRepository.findAll();
    }

    @Override
    protected Iterable<Songs> getFallback () {
        return Collections.emptyList();
    }
}
