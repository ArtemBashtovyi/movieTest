package com.example.felix.movietest.data.db;

import android.content.Context;
import org.greenrobot.greendao.database.Database;

/**
 * Created by felix on 9/25/17.
 *  Контролер для БД
 */


public class DbService {
    private DaoSession daoSession = null;
    private Database database = null;
    private Context context;

    public DbService(Context context) {
        // Инициализируем helper для создания БД
        this.context = context;
    }

    // Проверяем, если уже создана БД, то просто возвращаем эту БД в DaoMaster
    private DaoMaster getMaster() {
        DaoMaster.DevOpenHelper  helper = new DaoMaster.DevOpenHelper(context, "movies.db", null);
        if (database == null) {
            database = helper.getWritableDb();
        }

        return new DaoMaster(database);
    }

    // Проверка на то была ли создана DaoSession, и по флагу можем создать ее, указав false
    public DaoSession getSession(boolean isNull) {
        if(isNull) {
            return getMaster().newSession();
        }
        if (daoSession == null) {
            return getMaster().newSession();
        }
        return daoSession;
    }

}
