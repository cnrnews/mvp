package cnaio.imooc.com.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author：lihl on 2017/12/9 08:50
 * @email：1601796593@qq.com
 */
public  class AbstractMvpPersenter<V extends IMvpBaseView> {
    private V iMvpView;  /**
     * Presenter被创建后调用
     *
     * @param savedState 被意外销毁后重建后的Bundle
     */
    public void onCreatePersenter(@Nullable Bundle savedState) {
        Log.e("perfect-mvp","P onCreatePersenter = ");
    }

    public void onAttachMvpView(V view)
    {
        iMvpView=view;
    }
    public void onDetachMvpView()
    {
        iMvpView=null;
    }
    /**
     * Presenter被销毁时调用
     */
    public void onDestroyPersenter() {
        Log.e("perfect-mvp","P onDestroy = ");
    }
    /**
     * 在Presenter意外销毁的时候被调用，它的调用时机和Activity、Fragment、View中的onSaveInstanceState
     * 时机相同
     *
     * @param outState
     */
    public void onSaveInstanceState(Bundle outState) {
        Log.e("perfect-mvp","P onSaveInstanceState = ");
    }

    /**
     * 获取V层接口View
     *
     * @return 返回当前MvpView
     */

    public V getiMvpView()
    {
        return iMvpView;
    }

}
