package cnaio.imooc.com.mvp.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cnaio.imooc.com.mvp.mvp_perfect.BaseMvpProxy;
import cnaio.imooc.com.mvp.mvp_perfect.PresenterMvpFactory;
import cnaio.imooc.com.mvp.mvp_perfect.PresenterMvpFactoryImpl;
import cnaio.imooc.com.mvp.mvp_perfect.PresenterProxyInterface;

/**
 * @author：lihl on 2017/12/9 08:52
 * @email：1601796593@qq.com
 */
public abstract class AbstractMvpActivity<V extends IMvpBaseView,P extends AbstractMvpPersenter<V>>
        extends AppCompatActivity implements PresenterProxyInterface<V,P>
{
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";

    private BaseMvpProxy<V,P> mProxy=new BaseMvpProxy<>(PresenterMvpFactoryImpl.<V,P>createFactory(getClass()));
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       if (savedInstanceState!=null)
       {
           mProxy.onRestoreInstanceState(savedInstanceState.getBundle(PRESENTER_SAVE_KEY));
       }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProxy.onResume((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       mProxy.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return null;
    }

    @Override
    public P getMvpPresenter() {
        return (P) mProxy.getMvpPresenter();
    }

}
