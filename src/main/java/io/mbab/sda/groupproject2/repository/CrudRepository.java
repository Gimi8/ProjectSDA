package io.mbab.sda.groupproject2.repository;


import io.mbab.sda.groupproject2.entity.Album;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

  List<T> getAll();

  Optional<T> findById(ID id);

  T create(T entity);

  T update(T entity);

  void delete(ID id);



  List<Album> findAlbumByName(String name);

  Optional<Album> findAlbumByArtistName(String name);
}
