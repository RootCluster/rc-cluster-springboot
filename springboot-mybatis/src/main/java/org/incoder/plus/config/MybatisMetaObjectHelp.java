package org.incoder.plus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author : Jerry xu
 * @since : 2020/5/14  23:55
 */
@Component
public class MybatisMetaObjectHelp implements MetaObjectHandler {

    /**
     * 插入数据时填充的逻辑
     *
     * @param metaObject metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 如果需要对一些存在的字段才进行填充，可以进行判断
        /*boolean create = metaObject.hasSetter("create");
        if (create) {
            // 这里进行添加填充
        }*/
//        setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新数据时填充逻辑
     *
     * @param metaObject metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 如果对于某个字段没有设置值时，我们自动为该字段赋值，如果手动【在业务】中设值了我们则不进行自动填充
        /*Object update = getFieldValByName("update", metaObject);
        if (update != null) {

        }*/
//        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
