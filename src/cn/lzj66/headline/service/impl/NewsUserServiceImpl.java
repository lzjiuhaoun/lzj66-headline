package cn.lzj66.headline.service.impl;

import cn.lzj66.headline.dao.NewsUserDao;
import cn.lzj66.headline.dao.impl.NewsUserDaoImpl;
import cn.lzj66.headline.pojo.NewsUser;
import cn.lzj66.headline.service.NewsUserService;
import cn.lzj66.headline.util.MD5Util;

public class NewsUserServiceImpl implements NewsUserService {

    private NewsUserDao userDao =new NewsUserDaoImpl();
    @Override
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser registUser) {
        // 处理增加数据的业务
        // 将明文密码转换成密文密码
        registUser.setUserPwd(MD5Util.encrypt(registUser.getUserPwd()));

        return userDao.insertUser(registUser);
    }
}
