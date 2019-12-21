package com.lhz.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: lhz
 * @Date: 2019/12/21 0021 13:44
 * @Description: 网关过滤器
 * @Version: 1.0
 */
@Component
public class TokenFilter extends ZuulFilter {
    //过滤器类型“pre” 表示请求之前进行过滤
    @Override
    public String filterType() {
        return "pre";
    }

    //表示过滤器执行顺寻 当一个请求在同一个阶段时存在多个过滤器时，过滤器执行顺序问题
    @Override
    public int filterOrder() {
        return 0;
    }

    //表示判断过滤器是否生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //编写过滤器业务逻辑方法，拦截所有服务接口判断服务接口是否有
    @Override
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = currentContext.getRequest();
        //获取token时从请求头中获取  以下以问号方式
        String userToken = request.getParameter("userToken");
        if (StringUtils.isBlank(userToken)) {
            //返回错误提示 不会调用接口直接返回客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToekn is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        //正在正常执行接口
        return null;
    }
}
