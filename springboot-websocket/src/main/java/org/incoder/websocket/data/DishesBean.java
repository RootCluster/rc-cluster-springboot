/*
 * Copyright (C) 2020 The Jerry xu Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.incoder.websocket.data;

import lombok.Data;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2020/7/14  14:09
 */
@Data
public class DishesBean {

    private String calculatePrice;
    private boolean isDelete;
    private String flavour;
    private int number;
    private int position;
    private boolean isCheck;
    private String currentNumber;
    private String printIp;
    private boolean isRefund;
    private String barId;
    private String cateId;
    private String discount;
    private int discountFlag;
    private String discountPrice;
    private String flavors;
    private int id;
    private String image;
    private String introduce;
    private int isDish;
    private boolean isSellOut;
    private int mark;
    private int mealFlag;
    private int minNum;
    private String name;
    private String price;
    private int sold;
    private int store;
    private String unit;
    private String selectchargingName;
    private String selectchargingPrice;
    private List<ChargingsBean> chargings;
    private List<String> flavor;
    private List<ImagesBean> images;
    private List<MealOptionsBean> mealOptions;
    private List<ListBean> list;

}
