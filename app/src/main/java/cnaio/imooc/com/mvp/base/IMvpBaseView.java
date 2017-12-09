package cnaio.imooc.com.mvp.base;

import cnaio.imooc.com.mvp.WeatherBean;

/**
 * @author：lihl on 2017/12/9 08:49
 * @email：1601796593@qq.com
 */
public abstract interface IMvpBaseView {
    //请求时展示加载
    void requestLoading();
    //请求成功
    void resultSuccess(WeatherBean result);
    //请求失败
    void resultFailure(String result);
}
