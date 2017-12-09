package cnaio.imooc.com.mvp.mvp_perfect;

import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;
import cnaio.imooc.com.mvp.base.IMvpBaseView;


/**
*作者:candy
*创建时间:2017/12/9 10:24
*邮箱:1601796593@qq.com
*功能描述:工厂
**/
public interface PresenterMvpFactory<V extends IMvpBaseView,P extends AbstractMvpPersenter> {
    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
