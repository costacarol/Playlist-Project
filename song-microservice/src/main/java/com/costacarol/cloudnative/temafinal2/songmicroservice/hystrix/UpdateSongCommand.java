package com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;

public class UpdateSongCommand extends HystrixCommand<Object> {

    private final SongRepository songRepository;
    private final String title;
    private final Integer id;

    public UpdateSongCommand(String title, Integer id, SongRepository songRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( "AddSong" ));
        this.title = title;
        this.id = id;
        this.songRepository = songRepository;
    }

    @Override
    protected Object run() throws Exception {
        Optional<Songs> songOptional = songRepository.findById(id);
        if(songOptional.isPresent()){
            songOptional.get().setTitle(title);
            songRepository.save(songOptional.get());
        }
            return Optional.empty();
    }

    @Override
    protected Object getFallback () {
        return Optional.empty();
    }
}
