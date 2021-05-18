package com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.SongPlaylist;
import feign.Param;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongPlaylistRepository extends CrudRepository<SongPlaylist, Integer> {

    @Query("select id_song from song_playlist where id_playlist = :id")
    List<Integer> findByPlaylistId(@Param("id") Integer id);

}
