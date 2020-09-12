package io.mbab.sda.groupproject2.repository;

import io.mbab.sda.groupproject2.entity.Album;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AlbumRepository implements CrudRepository<Album, Integer> {

    private final EntityManager em;

    @Override
    public List<Album> getAll() {
        return em.createQuery("FROM Album", Album.class).getResultList();
    }

    @Override
    public Optional<Album> findById(Integer id) {
        String jpql = "FROM Album e WHERE e.id = :id";

        try {
            var album = em.createQuery(jpql, Album.class).setParameter("id", id).getSingleResult();
            return Optional.of(album);
        } catch (NoResultException e) {
            return Optional.empty();
        }

    }


    @Override
    public Album update(Album entity) {
        return null;
    }

    @Override
    public Album create(Album entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Integer o) {
    }

    @Override
    public Optional<Album> FindAlbumByName(String name) {
        String jpql = "FROM Album e WHERE e.name = :name";
        try {
            var album = em.createQuery(jpql, Album.class).setParameter("name", name).getSingleResult();
            return Optional.of(album);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Album> FindAlbumByArtistName(String artistName) {
        String jpql = "FROM Album e WHERE e.artistName = :artistName";
        try {
            var album = em.createQuery(jpql, Album.class).setParameter("artistName",artistName ).getSingleResult();
            return Optional.of(album);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
