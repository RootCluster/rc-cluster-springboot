package org.incoder.start.annotation;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author : Jerry xu
 * @date : 2019/10/6  17:41
 */
public class MyConfigBean {

    @Value("${myConfig.myObject.myName}")
    private String myAge;

    @Value("${myConfig.myObject.myAge}")
    private String myName;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyAge() {
        return myAge;
    }

    public void setMyAge(String myAge) {
        this.myAge = myAge;
    }
}
