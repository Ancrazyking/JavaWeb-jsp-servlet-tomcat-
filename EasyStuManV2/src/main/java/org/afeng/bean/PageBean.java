package org.afeng.bean;
import java.util.List;

/**
 * @author afeng
 * @date 2018/8/18 16:30
 **/
public class PageBean<T>
{
    private int currentPage;//当前页
    private int totalPage;//总页数
    private int pageSize;//每页的总记录数
    private int totalSize;//总的记录数
    private List<T> list;//用于存放分页对象的集合

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public int getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getTotalSize()
    {
        return totalSize;
    }

    public void setTotalSize(int totalSize)
    {
        this.totalSize = totalSize;
    }

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }
}
