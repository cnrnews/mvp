package cnaio.imooc.com.mvp.mvp_perfect;

import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;
import cnaio.imooc.com.mvp.base.IMvpBaseView;

/**
 * 作者:candy
 * 创建时间:2017/12/9 10:30
 * 邮箱:1601796593@qq.com
 * 功能描述:注解工厂
 **/
public class PresenterMvpFactoryImpl<V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> implements PresenterMvpFactory<V, P> {


    /***
     * 需要创建的Presenter的类型
     */
    private final Class<P> mPresenterClass;

    private PresenterMvpFactoryImpl(Class<P> presenterClass) {
        mPresenterClass = presenterClass;
    }

    /**
     * 根据注解创建Presenter的工厂实现类
     *
     * @param viewClazz 需要创建Presenter的V层实现类
     * @param <V>       当前View实现的接口类型
     * @param <P>       当前要创建的Presenter类型
     * @return 工厂类
     */
    public static <V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> PresenterMvpFactoryImpl<V, P> createFactory(Class<?> viewClazz) {
        CreatePresenter annotation = viewClazz.getAnnotation(CreatePresenter.class);
        Class<P> aClass = null;
        if (annotation != null) {
            aClass = (Class<P>) annotation.value();
        }
        return aClass == null ? null : new PresenterMvpFactoryImpl<V, P>(aClass);
    }

    @Override
    public P createMvpPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
