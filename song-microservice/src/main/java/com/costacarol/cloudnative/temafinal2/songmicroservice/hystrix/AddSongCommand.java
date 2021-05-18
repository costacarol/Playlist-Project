package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;


public class AddSongCommand extends HystrixCommand<Optional<Songs>> {

    private SongRepository songRepository;
    private String title;
    private String singer;

    public AddSongCommand(String title, String singer, SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( "AddSong" ));
        this.title = title;
        this.singer = singer;
        this.songRepository = songRepository;
    }

    @Override
    protected Optional<Songs> run() throws Exception {
        Songs song = new Songs(title, singer);
        songRepository.save(song);
        return Optional.of(song);
    }

    @Override
    protected Optional<Songs> getFallback () {
        return Optional.empty();
    }


}
