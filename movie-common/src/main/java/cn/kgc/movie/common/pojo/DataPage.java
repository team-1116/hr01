package cn.kgc.movie.common.pojo;

import java.util.List;

/**
 * Created by Tiler on 2020/8/25
 */
public class DataPage<T> {
    private Integer rowCount;  //记录总数
    private Integer pageCount; //总页数
    private Integer pageNum;   //当前页
    private Integer pageSize;  //页面大小
    private List<T> dataList;

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
