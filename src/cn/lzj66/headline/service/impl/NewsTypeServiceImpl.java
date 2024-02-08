package cn.lzj66.headline.service.impl;

import cn.lzj66.headline.dao.NewsTypeDao;
import cn.lzj66.headline.dao.impl.NewsTypeDaoImpl;
import cn.lzj66.headline.pojo.NewsType;
import cn.lzj66.headline.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao typeDao =new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() {
        return typeDao.findAll();
    }
}
