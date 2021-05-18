package com.costacarol.cloudnative.temafinal2.playlistmicroservice.service;


import com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix.AddPlaylistCommand;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix.AddSongOnPlaylistCommand;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.hystrix.GetSongsIdOnPlaylistCommand;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.Playlist;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.SongPlaylist;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.PlaylistRepository;
import com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository.SongPlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlaylistService {

    PlaylistRepository playlistRepository;
    SongPlaylistRepository songPlaylistRepository;

    public Optional<Playlist> addNewPlaylist(String title){
        AddPlaylistCommand addPlaylistCommand =
                new AddPlaylistCommand(title,
                playlistRepository);
        return addPlaylistCommand.execute();
    }

    public Optional<SongPlaylist> addSongOnPlaylist(Integer idPlaylist, Integer idSong){
        AddSongOnPlaylistCommand addSongOnPlaylistCommand =
                new AddSongOnPlaylistCommand(idPlaylist,
                idSong,
                songPlaylistRepository);
       return addSongOnPlaylistCommand.execute();
    }

    public List<Integer> getSongsIdOnPlaylist(Integer idPlaylist){
        GetSongsIdOnPlaylistCommand getSongsIdOnPlaylistCommand =
                new GetSongsIdOnPlaylistCommand(idPlaylist, songPlaylistRepository);
        return getSongsIdOnPlaylistCommand.execute();
    }
}
