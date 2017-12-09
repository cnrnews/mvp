package cnaio.imooc.com.mvp.mvp_perfect;

import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;
import cnaio.imooc.com.mvp.base.IMvpBaseView;

/**
*作者:candy
*创建时间:2017/12/9 10:40
*邮箱:1601796593@qq.com
*功能描述:代理接口
**/
public interface PresenterProxyInterface<V extends IMvpBaseView,P extends AbstractMvpPersenter> {
    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory类型
     */
    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return 返回PresenterMvpFactory类型
     */
    PresenterMvpFactory<V,P> getPresenterFactory();


    /**
     * 获取创建的Presenter
     * @return 指定类型的Presenter
     */
    P getMvpPresenter();
}
