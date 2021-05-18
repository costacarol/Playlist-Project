package com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.SongPlaylist;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.SongPlaylistRepository;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Optional;

public class AddSongOnPlaylistCommand extends HystrixCommand<Optional<SongPlaylist>> {

    private Integer idSong;
    private Integer idPlaylist;
    private SongPlaylistRepository songPlaylistRepository;

    public AddSongOnPlaylistCommand(Integer idPlaylist , Integer idSong, SongPlaylistRepository songPlaylistRepository) {
        super (HystrixCommandGroupKey.Factory.asKey( " AddSongOnPlaylist" ));
        this.idSong = idSong;
        this.idPlaylist = idPlaylist;
        this.songPlaylistRepository = songPlaylistRepository;
    }

    @Override
    protected Optional<SongPlaylist> run() throws Exception {
        SongPlaylist songplaylist = new SongPlaylist(idPlaylist, idSong);
        songPlaylistRepository.save(songplaylist);
        return Optional.of(songplaylist);

    }

    @Override
    protected Optional<SongPlaylist> getFallback () {
        return Optional.empty();
    }


}
