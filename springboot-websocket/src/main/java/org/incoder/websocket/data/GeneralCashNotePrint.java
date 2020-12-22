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
public class GeneralCashNotePrint {

    private List<DishesBean> dishList;
    private List<DishesBean> orgDishList;
    private String tableNumber;
    private String orderId;
    private String peopleNumber;
    private String item;
    private String totalPrice;
    private String remark;
    private String printTime;
    private String toBeCalled;
    private String title;
    private String printIp;
    private String people;
    private boolean isOrderAgain;
    private boolean isRefund;
    private String refundTime;
    private String refundNote;
    private String source;
    private int payMode;
    private String drawee;
    private List<MealCouponBean> mcds;
    private String couponName;
    private String couponPrice;
    private String discountPrice;
    private String yingprice;
    private String price;
    private String payTime;
    private String amountReceived;

}
