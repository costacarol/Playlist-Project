package com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.Playlist;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.PlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;

public class AddPlaylistCommand extends HystrixCommand<Optional<Playlist>> {

    private String title;
    private PlaylistRepository playlistRepository;

    public AddPlaylistCommand(String title, PlaylistRepository playlistRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( " AddPlaylist " ));
        this.title = title;
        this.playlistRepository = playlistRepository;
    }

    @Override
    protected Optional<Playlist> run() throws Exception {
        Playlist playlist = new Playlist(title);
        playlistRepository.save(playlist);
        return Optional.of(playlist);
    }

    @Override
    protected Optional<Playlist> getFallback () {
        return Optional.empty();
    }

}
