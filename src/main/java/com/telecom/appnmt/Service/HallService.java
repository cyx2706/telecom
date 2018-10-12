package com.telecom.appnmt.Service;

import com.telecom.appnmt.Entity.Hall;

import java.util.List;

public interface HallService {

    /**
     * 创建一个新的营业厅到数据库
     * @return
     */
    public Hall create();

    /**
     * 获取营业厅列表
     * @param page
     * @return
     */
    public List<Hall> getListByPage(int page);
}
