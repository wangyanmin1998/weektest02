package com.bwie.wangyanmin20200106.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.bwie.wangyanmin20200106.model.dao.ClassflyDao;

import com.bwie.wangyanmin20200106.database.ClassflyDaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig classflyDaoDaoConfig;

    private final ClassflyDaoDao classflyDaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        classflyDaoDaoConfig = daoConfigMap.get(ClassflyDaoDao.class).clone();
        classflyDaoDaoConfig.initIdentityScope(type);

        classflyDaoDao = new ClassflyDaoDao(classflyDaoDaoConfig, this);

        registerDao(ClassflyDao.class, classflyDaoDao);
    }
    
    public void clear() {
        classflyDaoDaoConfig.clearIdentityScope();
    }

    public ClassflyDaoDao getClassflyDaoDao() {
        return classflyDaoDao;
    }

}
