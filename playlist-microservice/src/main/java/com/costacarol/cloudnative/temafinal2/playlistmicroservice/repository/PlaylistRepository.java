package com.costacarol.cloudnative.temafinal2.playlistmicroservice.repository;

import com.costacarol.cloudnative.temafinal2.playlistmicroservice.model.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Integer> {
}
