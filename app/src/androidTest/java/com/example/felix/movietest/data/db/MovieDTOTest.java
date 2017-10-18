package com.example.felix.movietest.data.db;

import org.greenrobot.greendao.test.AbstractDaoTestLongPk;

import com.example.felix.movietest.data.db.MovieDTO;
import com.example.felix.movietest.data.db.MovieDTODao;

public class MovieDTOTest extends AbstractDaoTestLongPk<MovieDTODao, MovieDTO> {

    public MovieDTOTest() {
        super(MovieDTODao.class);
    }

    @Override
    protected MovieDTO createEntity(Long key) {
        MovieDTO entity = new MovieDTO();
        entity.setIdDb(key);
        return entity;
    }

}
