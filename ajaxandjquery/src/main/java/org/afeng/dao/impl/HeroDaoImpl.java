package org.afeng.dao.impl;

import org.afeng.dao.HeroDao;
import org.afeng.domain.HeroBean;
import org.afeng.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author afeng
 * @date 2018/8/20 21:03
 **/
public class HeroDaoImpl implements HeroDao
{

    QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());

    @Override
    public List<HeroBean> findHero(int campId) throws Exception
    {

        List<HeroBean> heroList = queryRunner.query("select * from lol where campid=?",
                new BeanListHandler<>(HeroBean.class), campId);
        return heroList;
    }
}
