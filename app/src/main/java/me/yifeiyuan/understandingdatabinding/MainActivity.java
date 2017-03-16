package me.yifeiyuan.understandingdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.yifeiyuan.understandingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setUser(createUser());
        mainBinding.setImgUrl("http://img.qqai.net/uploads/i_5_4094424040x1536326957_21.jpg");
        mainBinding.setHandler(new EventHandler());
    }

    private User createUser() {
        User user = new User();
        user.id = 900110;
        user.name = "程序亦非猿";
//        user.nickName = "";// "" 不行 一定要 null 才会显示 name
        user.age = 18;
        user.male = true;
        user.birthDay = System.currentTimeMillis();
        return user;
    }
}
