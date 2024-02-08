package cn.lzj66.headline.dao;

import cn.lzj66.headline.pojo.NewsHeadline;
import cn.lzj66.headline.pojo.vo.HeadlineDetailVo;
import cn.lzj66.headline.pojo.vo.HeadlinePageVo;
import cn.lzj66.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadlineDao {
    /**
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     * @param hid
     * @return
     */
    int incrPageViews(int hid);

    /**
     * @param hid
     * @return
     */
    HeadlineDetailVo findHealineDetail(int hid);

    int addNewsHeadline(NewsHeadline newsHeadline);

    /**
     * @param hid
     * @return
     */
    NewsHeadline findByHid(Integer hid);

    int update(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}
