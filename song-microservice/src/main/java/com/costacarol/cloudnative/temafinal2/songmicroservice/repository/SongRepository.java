package com.costacarol.cloudnative.temafinal2.songmicroservice.repository;

import com.costacarol.cloudnative.temafinal2.songmicroservice.model.Songs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Songs, Integer> {

}
