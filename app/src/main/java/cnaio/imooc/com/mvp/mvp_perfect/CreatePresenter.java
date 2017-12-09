package cnaio.imooc.com.mvp.mvp_perfect;


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import cnaio.imooc.com.mvp.base.AbstractMvpPersenter;

/**
*作者:candy
*创建时间:2017/12/9 10:25
*邮箱:1601796593@qq.com
*功能描述:注解
**/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CreatePresenter {
    Class<? extends AbstractMvpPersenter>value();
}
