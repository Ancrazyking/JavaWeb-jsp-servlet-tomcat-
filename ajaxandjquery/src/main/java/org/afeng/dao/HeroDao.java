package org.afeng.dao;
import org.afeng.domain.HeroBean;

import java.util.List;
/**
 * @author afeng
 * @date 2018/8/20 21:00
 **/
public interface HeroDao
{

    List<HeroBean>  findHero(int campId)throws Exception;

}
