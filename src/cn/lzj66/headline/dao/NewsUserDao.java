package cn.lzj66.headline.dao;

import cn.lzj66.headline.pojo.NewsUser;

public interface NewsUserDao {
    /**
     *
     * @param username
     * @return
     */
    NewsUser findByUsername(String username);

    /**
     *
     * @param userId
     * @return
     */
    NewsUser findByUid(Integer userId);

    /**
     *
     * @param registUser
     * @return
     */
    Integer insertUser(NewsUser registUser);
}
