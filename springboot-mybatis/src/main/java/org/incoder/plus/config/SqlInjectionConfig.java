package org.incoder.plus.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import org.incoder.plus.method.SqlInjectionMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 这里你
 * 可以继承{@link DefaultSqlInjector}，
 * 也可以继承{@link com.baomidou.mybatisplus.core.injector.AbstractSqlInjector}，
 * 还可以继承{@link com.baomidou.mybatisplus.core.injector.ISqlInjector}，
 * 根据实际情况来选择
 *
 * @author : Jerry xu
 * @since : 2020/5/15  09:08
 */
@Component
public class SqlInjectionConfig extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        // 这里必须是先调用它父类的方法，即 super，然后再加入自定义的方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new SqlInjectionMethod());
        return methodList;
    }
}
