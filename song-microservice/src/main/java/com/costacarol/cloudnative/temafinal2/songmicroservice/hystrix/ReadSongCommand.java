package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;

public class ReadSongCommand extends HystrixCommand<Object> {

    private final Integer idSong;
    private final SongRepository songRepository;

    public ReadSongCommand(Integer idSong, SongRepository songRepository) {
        super(HystrixCommandGroupKey.Factory.asKey("ReadSong"));
        this.idSong = idSong;
        this.songRepository = songRepository;
    }

    @Override
    protected Object run() throws Exception {
        return songRepository.findById(idSong);
    }

    @Override
    protected Object getFallback() {
        return Optional.empty();
    }
}
