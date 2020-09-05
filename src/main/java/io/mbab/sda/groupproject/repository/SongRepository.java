package io.mbab.sda.groupproject.repository;

import io.mbab.sda.groupproject.entity.City;
import io.mbab.sda.groupproject.entity.Song;

import javax.persistence.EntityManager;
import java.util.List;

public class SongRepository implements CrudRepository<Song, Integer> {

    private final EntityManager em;

    public SongRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Song> getAll() {
        return em.createQuery("FROM Song", Song.class)
                .getResultList();
    }

    @Override
    public Song findById(Integer integer) {
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
    public Song update(Song entity) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }


}
