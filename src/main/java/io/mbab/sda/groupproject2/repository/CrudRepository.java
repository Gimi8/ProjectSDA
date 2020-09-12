package io.mbab.sda.groupproject2.repository;


import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

  List<T> getAll();

  Optional<T> findById(ID id);

 T findNameAlbum(T entity);

  T create(T entity);

  T update(T entity);

  void delete(ID id);
}
