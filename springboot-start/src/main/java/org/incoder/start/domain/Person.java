package org.incoder.start.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Person
 *
 * @author : Jerry xu
 * @date : 2019-06-20  23:41
 */
public class Person {

    private Integer id;
    private String name;
    private Date birthday;
    private BigDecimal decimal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
