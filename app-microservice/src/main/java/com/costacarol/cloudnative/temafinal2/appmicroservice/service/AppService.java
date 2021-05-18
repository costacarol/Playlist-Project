package com.costacarol.cloudnative.temafinal2.appmicroservice.service;

import com.costacarol.cloudnative.temafinal2.appmicroservice.hystrix.DetailPlaylistCommand;
import com.costacarol.cloudnative.temafinal2.appmicroservice.hystrix.GetInfoPlaylistCommand;
import com.costacarol.cloudnative.temafinal2.appmicroservice.model.PlaylistSongs;
import com.costacarol.cloudnative.temafinal2.appmicroservice.ribbon.RibbonClass;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AppService {

    private RibbonClass ribbonClass;
    private final String PLAYLIST_PORT = "8082";

    private Integer[] getInfoPlaylist(Integer idPlaylist) {
        GetInfoPlaylistCommand getInfoPlaylistCommand = new GetInfoPlaylistCommand(idPlaylist);
        return getInfoPlaylistCommand.execute();
    }

    public Optional<PlaylistSongs> detailPlaylist(Integer idPlaylist) {
        DetailPlaylistCommand detailPlaylistCommand = new DetailPlaylistCommand(idPlaylist,
                ribbonClass,
                getInfoPlaylist(idPlaylist));
        return detailPlaylistCommand.execute();
    }
}
