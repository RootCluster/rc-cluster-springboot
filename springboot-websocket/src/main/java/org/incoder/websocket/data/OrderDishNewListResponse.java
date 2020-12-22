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
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author : Jerry xu
 * @date : 2020/7/14  14:09
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDishNewListResponse extends BaseResponse {

    private DataBean data;

    @Data
    public static class DataBean {

        private List<OriginalBean> original;
        private List<OriginalBarBean> originalBar;
        private List<OriginalMenuBean> originalMenu;
        private List<OriginalBean> stickie;
        private List<StickieBarBean> stickieBar;
        private List<StickieMenuBean> stickieMenu;

        @Data
        public static class OriginalBean {
            private int id;
            private String name;
            private List<DishesBean> dishes;
        }

        @Data
        public static class OriginalBarBean {
            private String checked;
            private int dishCateId;
            private String dishCateName;
            private int id;
        }

        @Data
        public static class OriginalMenuBean {
        }

        @Data
        public static class StickieBarBean {
            private String checked;
            private int dishCateId;
            private String dishCateName;
            private int id;
        }

        @Data
        public static class StickieMenuBean {
            private String checked;
            private int dishCateId;
            private String dishCateName;
            private int id;
        }

    }
}
