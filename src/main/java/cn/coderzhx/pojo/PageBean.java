package cn.coderzhx.pojo;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhx
 * @create 2019-07-20-16
 */
@Component
public class PageBean<T> {
    // 当前页数
    private Integer currentPage=0;
    // 总记录数
    private Integer totalCount;
    // 每页显示条数
    private Integer pageSize=7;
    // 总页数
    private Integer totalPage;
    // 起始索引
    private Integer index;
    //数据
   private List<T> list;
    //全局搜索条件
    private String word;

    //博客管理后台搜索条件
    private String title;
    private int category;

    //根据标签查出文章
    private String tags;

    //留言管理后台搜索条件
    private String qq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //友情链接搜索条件
    private String name;

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.totalCount = totalCount;

        this.pageSize = pageSize;

        this.currentPage = currentPage;

        if (this.currentPage == null) {
            // 如页面没有指定显示那一页.显示第一页.
            this.currentPage = 1;
        }

        if (this.pageSize == null) {
            // 如果每页显示条数没有指定,默认每页显示8条
            this.pageSize = 8;
        }

        // 计算总页数
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;

        // 判断当前页数是否超出范围
        // 不能小于1
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        // 不能大于总页数
        if (this.currentPage > this.totalPage) {
            this.currentPage = this.totalPage;
        }

    }

    // 计算起始索引
	public int getStart() {
		return (this.currentPage - 1) * this.pageSize;
	}
    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getIndex() {

        return (this.currentPage - 1) * this.pageSize;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", index=" + index +
                ", list=" + list +
                ", word='" + word + '\'' +
                '}';
    }
}
