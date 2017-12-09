package cnaio.imooc.com.mvp.mvp_perfect;

import android.os.Bundle;
import android.util.Log;

import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;
import cnaio.imooc.com.mvp.base.IMvpBaseView;

/**
*作者:candy
*创建时间:2017/12/9 10:46
*邮箱:1601796593@qq.com
*功能描述:代理
**/
public class BaseMvpProxy<V extends IMvpBaseView, P extends AbstractMvpPersenter<V>> implements PresenterProxyInterface<V, P> {


    /**
     * Presenter工厂类
     */
    private PresenterMvpFactory<V, P> mFactory;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;
    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    public BaseMvpProxy(PresenterMvpFactory<V, P> factory) {
        mFactory = factory;
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        if (mPresenter != null) {
            throw new IllegalArgumentException("这个方法只能在getMvpPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.mFactory = presenterFactory;
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mFactory;
    }

    @Override
    public P getMvpPresenter() {
        if (mFactory!=null)
        {
            if (mPresenter==null)
            {
                mPresenter=mFactory.createMvpPresenter();
                mPresenter.onCreatePersenter(mBundle==null?null:mBundle.getBundle(PRESENTER_KEY));
            }
        }
        return mPresenter;
    }
    /**
     * 绑定Presenter和view
     * @param mvpView
     */
    public void onResume(V mvpView) {
        getMvpPresenter();
        Log.e("perfect-mvp","Proxy onResume");
        if (mPresenter != null && !mIsAttchView) {
            mPresenter.onAttachMvpView(mvpView);
            mIsAttchView = true;
        }
    }
    /**
     * 销毁Presenter持有的View
     */
    private void onDetachMvpView() {
        Log.e("perfect-mvp","Proxy onDetachMvpView = ");
        if (mPresenter != null && mIsAttchView) {
            mPresenter.onDetachMvpView();
            mIsAttchView = false;
        }
    }
    /**
     * 销毁Presenter
     */
    public void onDestroy() {
        Log.e("perfect-mvp","Proxy onDestroy = ");
        if (mPresenter != null ) {
            onDetachMvpView();
            mPresenter.onDestroyPersenter();
            mPresenter = null;
        }
    }
    /**
     * 意外销毁的时候调用
     * @return Bundle，存入回调给Presenter的Bundle和当前Presenter的id
     */
    public Bundle onSaveInstanceState() {
        Log.e("perfect-mvp","Proxy onSaveInstanceState = ");
        Bundle bundle = new Bundle();
        getMvpPresenter();
        if(mPresenter != null){
            Bundle presenterBundle = new Bundle();
            //回调Presenter
            mPresenter.onSaveInstanceState(presenterBundle);
            bundle.putBundle(PRESENTER_KEY,presenterBundle);
        }
        return bundle;
    }
    /**
     * 意外关闭恢复Presenter
     * @param savedInstanceState 意外关闭时存储的Bundler
     */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("perfect-mvp","Proxy onRestoreInstanceState = ");
        Log.e("perfect-mvp","Proxy onRestoreInstanceState Presenter = " + mPresenter);
        mBundle = savedInstanceState;
    }
}
