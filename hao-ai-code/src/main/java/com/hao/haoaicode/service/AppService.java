package com.hao.haoaicode.service;

import com.hao.haoaicode.model.dto.app.AppQueryRequest;
import com.hao.haoaicode.model.entity.App;
import com.hao.haoaicode.model.entity.User;
import com.hao.haoaicode.model.vo.AppVO;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author hao
 */
public interface AppService extends IService<App> {
    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    String deployApp(Long appId, User loginUser);
}
