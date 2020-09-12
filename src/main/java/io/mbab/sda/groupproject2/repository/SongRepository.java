package io.mbab.sda.groupproject2.repository;

import io.mbab.sda.groupproject2.entity.Album;
import io.mbab.sda.groupproject2.entity.Song;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SongRepository implements CrudRepository<Song, Integer> {

  private final EntityManager em;

  @Override
  public List<Song> getAll() {
    return em.createQuery("FROM Song", Song.class).getResultList();
  }

  @Override
  public Optional<Song> findById(Integer id) {
    return null;
  }

  @Override
  public Song update(Song entity) {
    return null;
  }

  @Override
  public Song create(Song entity) {
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    return entity;
  }

  @Override
  public void delete(Integer o) {}

  @Override
  public List<Album> FindAlbumByName(String name) {
    return null;
  }


  @Override
  public Optional<Album> FindAlbumByArtistName(String name) {
    return Optional.empty();
  }


}
