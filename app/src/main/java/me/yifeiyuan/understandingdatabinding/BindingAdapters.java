/*
 * Copyright (C) 2017, 程序亦非猿
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.yifeiyuan.understandingdatabinding;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by 程序亦非猿 on 17/2/15.
 */
public class BindingAdapters {

    private static final String TAG = "BindingAdapters";

    /**
     * 自定义属性 会走到这里处理
     * @param view
     * @param url
     */
    @BindingAdapter({"imgUrl"})
    public static void loadImg(ImageView view, String url) {
        Log.d(TAG, "loadImg() called with: view = [" + view + "], url = [" + url + "]");
        Glide.with(view.getContext()).load(url).placeholder(R.mipmap.ic_launcher).into(view);
    }
}
