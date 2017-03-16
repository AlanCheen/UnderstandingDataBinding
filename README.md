# UnderstandingDataBinding



DataBinding ，Android 官方推出的数据绑定库。

可以理解为 数据与 View(XML) 的绑定，而且目前已经支持双向绑定了。



## 配置



DataBinding支持的环境：

  

- **Android 2.1** (API level 7+) 
- Android Plugin for Gradle **1.5.0-alpha1**
- Android Studio **1.3** 。



配置 App 模块 的 build.gradle：



```groovy
android {
    ....
    dataBinding {
        enabled = true
    }
}
```

如果有依赖库使用了 DataBinding，那么 App 也需要配置 DataBinding。



简单配置即可拥有 DataBinding 的能力。



## 使用



XML 中的写法有所改变，`layout` 为根节点，多了 `data` `variable` `import` 标签。

举个例子：

```xml
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
 tools:context="me.yifeiyuan.understandingdatabinding.MainActivity"
    >

    <data>

        <import type="android.view.View" />
        <variable
            name="user"
            type="me.yifeiyuan.understandingdatabinding.User"/>

        <variable
            name="imgUrl"
            type="String"/>

    </data>

    <!-- 这里是原来的布局 -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >
        <!-- ... -->
    </LinearLayout>
</layout>
```



讲解：

- data 标签表示数据
- import 标签表示导入


- variable 标签表示变量



variable 中定义了一个类型为 `me.yifeiyuan.understandingdatabinding.User`的变量 `user`,xml 里我们就可以直接使用 `user`了。



那这个 user 的数据哪里来呢？

DataBinding 会为每个 xml 生成对应的`Binding`类，并为每个变量生成 `setter` 方法，  我们还需要修改原来的 setContentView 方式，改用 `DataBindingUtil.setContentView`的方式， 如：

```java
ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setUser(new User());
```



可以看出DB 的生成规则 xml 改成驼峰，再加上后缀 Binding。

activity_main == 》ActivityMainBinding



## DataBinding 的语法

DataBinding 有自己的语法，最关键的是 `@{}`。



属性引用：



```xml
// user的firstName 或者 getFirstName()方法 又或者 firstName() 方法
android:text="@{user.firstName}"
```



事件处理









## 更多资料

[Android-Resources](https://github.com/AlanCheen/Android-Resources/blob/master/DataBinding.md)

## License

Apache
