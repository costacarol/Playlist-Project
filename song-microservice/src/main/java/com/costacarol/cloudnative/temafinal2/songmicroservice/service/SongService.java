package com.costacarol.cloudnative.temafinal2.songmicroservice.service;

import com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix.*;
import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    public Object addNewSong (String title, String singer) {
        AddSongCommand addSongCommand = new AddSongCommand(title, singer, songRepository);
        return addSongCommand.execute();
    }

    public void deleteSong (Integer idSong){
        DeleteSongCommand deleteSong = new DeleteSongCommand(idSong, songRepository);
        deleteSong.execute();
    }

    public Object editSongTitle (Integer idSong, String newTitle){
        UpdateSongCommand updateSong = new UpdateSongCommand(newTitle, idSong, songRepository);
        return updateSong.execute();
    }

    public Object listSong(Integer idSong){
        ReadSongCommand readSong = new ReadSongCommand(idSong, songRepository);
        return readSong.execute();
    }
}
