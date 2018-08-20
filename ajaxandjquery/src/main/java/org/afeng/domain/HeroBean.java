package org.afeng.domain;

/**
 * @author afeng
 * @date 2018/8/20 21:01
 **/
public class HeroBean
{
    private int heroId;
    private String heroName;
    private int campId;


    @Override
    public String toString()
    {
        return "HeroBean{" +
                "heroId=" + heroId +
                ", heroName='" + heroName + '\'' +
                ", campId=" + campId +
                '}';
    }

    public int getHeroId()
    {
        return heroId;
    }

    public void setHeroId(int heroId)
    {
        this.heroId = heroId;
    }

    public String getHeroName()
    {
        return heroName;
    }

    public void setHeroName(String heroName)
    {
        this.heroName = heroName;
    }

    public int getCampId()
    {
        return campId;
    }

    public void setCampId(int campId)
    {
        this.campId = campId;
    }
}
