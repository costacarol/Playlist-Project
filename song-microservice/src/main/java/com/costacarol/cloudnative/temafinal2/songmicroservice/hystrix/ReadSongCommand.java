package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;

public class ReadSongCommand extends HystrixCommand<Optional<Songs>> {

    private Integer idSong;
    private SongRepository songRepository;

    public ReadSongCommand(Integer idSong, SongRepository songRepository) {
        super(HystrixCommandGroupKey.Factory.asKey("ReadSong"));
        this.idSong = idSong;
        this.songRepository = songRepository;
    }

    @Override
    protected Optional<Songs> run() throws Exception {
        return songRepository.findById(idSong);
    }

    @Override
    protected Optional<Songs> getFallback() {
        return Optional.empty();
    }
}
