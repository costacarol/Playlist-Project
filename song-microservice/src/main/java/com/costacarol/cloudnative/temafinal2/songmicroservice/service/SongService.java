package com.costacarol.cloudnative.temafinal2.songmicroservice.service;

import com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix.AddSongCommand;
import com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix.DeleteSongCommand;
import com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix.ReadSongCommand;
import com.costacarol.cloudnative.temafinal2.songmicroservice.hystrix.UpdateSongCommand;
import com.costacarol.cloudnative.temafinal2.songmicroservice.repository.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
