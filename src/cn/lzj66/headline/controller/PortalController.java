package cn.lzj66.headline.controller;

import cn.lzj66.headline.common.Result;
import cn.lzj66.headline.pojo.NewsType;
import cn.lzj66.headline.pojo.vo.HeadlineDetailVo;
import cn.lzj66.headline.pojo.vo.HeadlineQueryVo;
import cn.lzj66.headline.service.NewsHeadlineService;
import cn.lzj66.headline.service.NewsTypeService;
import cn.lzj66.headline.service.impl.NewsHeadlineServiceImpl;
import cn.lzj66.headline.service.impl.NewsTypeServiceImpl;
import cn.lzj66.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 门户 控制器
* 那些不需要登录,不需要做增删改的门户页的请求都放在这里
*
* */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private NewsTypeService typeService =new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService =new NewsHeadlineServiceImpl();


    /**
     * 查询头条详情的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收要查询头条的hid
        int hid = Integer.parseInt(req.getParameter("hid"));
        // 调用服务层完成查询处理
        HeadlineDetailVo headlineDetailVo =headlineService.findHeadlineDetail(hid);
        // 将查到的信息响应给客户端
        Map data =new HashMap();
        data.put("headline",headlineDetailVo);
        WebUtil.writeJson(resp, Result.ok(data));
    }

    /**
     * 分页查询头条信息的接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的参数
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);


        // 将参数传递给服务层 进行分页查询
        /*
        * pageData:[
        *   {
        *           "hid":"1",                     // 新闻id
    				"title":"尚硅谷宣布 ... ...",   // 新闻标题
    				"type":"1",                    // 新闻所属类别编号
    				"pageViews":"40",              // 新闻浏览量
    				"pastHours":"3",              // 发布时间已过小时数
    				"publisher":"1"
        *   }
        *
        * ],
        * pageNum:1,
        * pageSize:1,
        * totalPage:1,
        * totalSize:1
        *
        *
        * */
       Map pageInfo =headlineService.findPage(headlineQueryVo);
       Map data =new HashMap();
       data.put("pageInfo",pageInfo);

        // 将分页查询的结果转换成json响应给客户端
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 查询所有头条类型的业务接口实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 查询所有的新闻类型,装入Result响应给客户端
        List<NewsType> newsTypeList= typeService.findAll();


        WebUtil.writeJson(resp,Result.ok(newsTypeList));
    }
}
