package cn.lzj66.headline.service;

import cn.lzj66.headline.pojo.NewsHeadline;
import cn.lzj66.headline.pojo.vo.HeadlineDetailVo;
import cn.lzj66.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     *
     * @param headlineQueryVo
     * @return
     */
    Map findPage(HeadlineQueryVo headlineQueryVo);

    /**
     *
     * @param hid
     * @return
     */
    HeadlineDetailVo findHeadlineDetail(int hid);

    /**
     *
     * @param newsHeadline
     */
    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     *
     * @param hid
     * @return
     */
    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);


    /**
     *
     * @param hid
     * @return
     */
    int removeByHid(int hid);
}
