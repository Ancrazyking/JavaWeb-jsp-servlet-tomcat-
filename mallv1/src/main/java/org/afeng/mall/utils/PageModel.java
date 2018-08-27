package org.afeng.mall.utils;

import java.util.List;

/**
 * 分页类
 * 将分页的信息封装到一个类中
 *
 * @author afeng
 * @date 2018/8/27 11:15
 **/
public class PageModel<T>
{
    private int currentPageNum;//当前页
    private int pageSize = 5;//每页显示的条数,固定为5
    private int totalRecords;//总记录条数,数据库查找

    private int totalPageNum;//总页数,计算出来
    private int startIndex;//每页开始记录的索引
    private int prePageNum;//上一页
    private int nextPageNum;//下一页

    private int startPageNum;//开始页
    private int endPageNum;//结束页

    private List<T> list;//存放数据库记录的集合


    //完善属性
    private String url;


    /**
     * 要使用该分页
     *
     * @param currentPageNum 当前页
     * @param totalRecords   总记录数
     * @param pageSize       每一页的数量
     */
    public PageModel(int currentPageNum, int totalRecords, int pageSize)
    {
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;

        /**
         * 当前页的索引
         */
        startIndex = (currentPageNum - 1) * pageSize;

        /**
         * 计算出总的页数
         */
        totalPageNum = totalRecords % pageSize == 0 ? totalRecords / pageSize : (totalRecords / pageSize + 1);


        /**
         * 默认最多显示9页的数据
         */
        startPageNum = currentPageNum - 4;
        endPageNum = currentPageNum + 4;
        if (totalPageNum > 9)
        {
            if (startPageNum < 1)
            {
                startPageNum = 1;
                endPageNum = startPageNum + 8;
            }
            if (endPageNum > totalPageNum)
            {
                endPageNum = totalPageNum;
                startPageNum = endPageNum - 8;
            }
        } else
        {
            /**
             * 如果数据不足9页
             */
            startPageNum = 1;
            endPageNum = totalPageNum;

        }
    }



    public int getCurrentPageNum()
    {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum)
    {
        this.currentPageNum = currentPageNum;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalRecords()
    {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords)
    {
        this.totalRecords = totalRecords;
    }

    public int getTotalPageNum()
    {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum)
    {
        this.totalPageNum = totalPageNum;
    }

    public int getStartIndex()
    {
        return startIndex;
    }

    public void setStartIndex(int startIndex)
    {
        this.startIndex = startIndex;
    }

    /**
     * 获取上一页
     *
     * @return
     */
    public int getPrePageNum()
    {
        prePageNum = currentPageNum - 1;
        if (prePageNum < 1)
        {
            prePageNum = 1;
        }
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum)
    {
        this.prePageNum = prePageNum;
    }

    /**
     * 获取下一页
     *
     * @return
     */
    public int getNextPageNum()
    {
        nextPageNum = currentPageNum + 1;
        if (nextPageNum > totalPageNum)
        {
            nextPageNum = totalPageNum;
        }
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum)
    {
        this.nextPageNum = nextPageNum;
    }

    public int getStartPageNum()
    {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum)
    {
        this.startPageNum = startPageNum;
    }

    public int getEndPageNum()
    {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum)
    {
        this.endPageNum = endPageNum;
    }

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }


}
