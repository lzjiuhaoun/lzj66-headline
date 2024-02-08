package cn.lzj66.headline.dao.impl;

import cn.lzj66.headline.dao.BaseDao;
import cn.lzj66.headline.dao.NewsTypeDao;
import cn.lzj66.headline.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql = "select tid,tname from news_type";
        return baseQuery(NewsType.class,sql);
    }
}
