package io.mbab.sda.groupproject2.repository;

import io.mbab.sda.groupproject2.entity.Album;
import io.mbab.sda.groupproject2.entity.Song;

import java.util.List;

public interface CrudRepository<T, ID> {

  List<T> getAll();

  T findById(ID id);

  T create(T entity);

  T update(T entity);

    Album create(Album entity);

    Song create(Song entity);
    void delete(ID id);
}
