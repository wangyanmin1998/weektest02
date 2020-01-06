package com.bwie.wangyanmin20200106.model.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:王彦敏
 *@Date: 2020/1/6
 *@Time:10:47
 *@Description:
 * */
@Entity
public class ClassflyDao {
    private String classflyDao;

    @Generated(hash = 1528398524)
    public ClassflyDao(String classflyDao) {
        this.classflyDao = classflyDao;
    }

    @Generated(hash = 1808436164)
    public ClassflyDao() {
    }

    public String getClassflyDao() {
        return this.classflyDao;
    }

    public void setClassflyDao(String classflyDao) {
        this.classflyDao = classflyDao;
    }
}
