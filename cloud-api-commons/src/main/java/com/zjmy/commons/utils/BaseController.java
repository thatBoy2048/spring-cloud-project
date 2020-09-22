package com.zjmy.commons.utils;

public class BaseController {
    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder)
//    {
//        // Date 类型转换
//        binder.registerCustomEditor(Date.class, new PropertyEditorSupport()
//        {
//            @Override
//            public void setAsText(String text)
//            {
//            	setValue(DateUtils.StringToDate(text));
//            }
//        });
//    }

    /**
     * 设置请求分页数据
     */
//    protected void startPage()
//    {
//        PageDomain pageDomain = TableSupport.buildPageRequest();
//        Integer pageNum = pageDomain.getPageNum();
//        Integer pageSize = pageDomain.getPageSize();
//        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
//        {
//            String orderBy = pageDomain.getOrderBy();
//            PageHelper.startPage(pageNum, pageSize, orderBy);
//        }
//    }

    /**
     * 响应请求分页数据
     */
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    protected TableDataInfo getDataTable(List<?> list)
//    {
//        TableDataInfo rspData = new TableDataInfo();
//        rspData.setCode(1);
//        rspData.setRows(list);
//        rspData.setTotal(new PageInfo(list).getTotal());
//        return rspData;
//    }

    /**
     * 响应返回结果
     * 
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? success() : error();
    }
    
    protected AjaxResult toAjaxSuccess(Object object)
    {
        return AjaxResult.success().put("data", object);
    }

    /**
     * 返回成功
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }

    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }

    /**
     * 返回错误码消息
     */
    public AjaxResult error(int code, String message)
    {
        return AjaxResult.error(code, message);
    }

}
