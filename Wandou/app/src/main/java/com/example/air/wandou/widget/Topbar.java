package com.example.air.wandou.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by ruolan on 2015/11/29.
 */
public class Topbar extends Toolbar {

    //添加布局必不可少的工具
    private LayoutInflater mInflater;

    //搜索框
    private EditText mEditSearchView;
    //标题
    private TextView mTextTitle;
    //右边按钮
    private ImageButton mRightButton;
    //左边按钮
    private ImageButton mLeftButton;

    private View mView;

    //以下是继承ToolBar必须创建的三个构造方法
    public Topbar(Context context) {
        this(context, null);
    }

    public Topbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Topbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();

        //Set the content insets for this toolbar relative to layout direction.
        setContentInsetsRelative(10, 10);

        if (attrs != null) {
            //读写自定义的属性，如果不会自己写的时候，就看看官方文档是怎么写的哈
            /**
             * 下面是摘自官方文档
             * final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
             R.styleable.Toolbar, defStyleAttr, 0);

             mTitleTextAppearance = a.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
             mSubtitleTextAppearance = a.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
             mGravity = a.getInteger(R.styleable.Toolbar_android_gravity, mGravity);
             mButtonGravity = Gravity.TOP;
             mTitleMarginStart = mTitleMarginEnd = mTitleMarginTop = mTitleMarginBottom =
             a.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);

             final int marginStart = a.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
             if (marginStart >= 0) {
             mTitleMarginStart = marginStart;
             }

             *
             */
            final TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                    com.example.air.wandou.R.styleable.Topbar, defStyleAttr, 0);

            final Drawable leftIcon = a.getDrawable(com.example.air.wandou.R.styleable.Topbar_leftButtonIcon);
            if (leftIcon != null) {
                setLeftButtonIcon(leftIcon);
            }

            final Drawable rightIcon = a.getDrawable(com.example.air.wandou.R.styleable.Topbar_rightButtonIcon);
            if (rightIcon != null) {
                setRightButtonIcon(rightIcon);
            }

            boolean isShowSearchView = a.getBoolean(com.example.air.wandou.R.styleable.Topbar_isShowSearchView, false);

            //如果要显示searchView的时候
            if (isShowSearchView) {
                setSearchViewVisable(true);
                setTitleVisable(false);
            }
            //资源的回收
            a.recycle();
        }

    }

    private void initView() {

        if (mView == null) {
            //初始化
            mInflater = LayoutInflater.from(getContext());
            //添加布局文件
            mView = mInflater.inflate(com.example.air.wandou.R.layout.toolbar, null);

            //绑定控件
            mEditSearchView = (EditText) mView.findViewById(com.example.air.wandou.R.id.toolbar_searchview);
            mTextTitle = (TextView) mView.findViewById(com.example.air.wandou.R.id.toolbar_title);
            mLeftButton = (ImageButton) mView.findViewById(com.example.air.wandou.R.id.toolbar_leftbutton);
            mRightButton = (ImageButton) mView.findViewById(com.example.air.wandou.R.id.toolbar_rightbutton);

            //然后使用LayoutParams把控件添加到子view中
            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);

        }
    }

    @Override
    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title) {
        initView();
        if (mTextTitle != null) {
            mTextTitle.setText(title);
            setTitleVisable(true);
        }
    }

    //设置标题可见性
    public void setTitleVisable(boolean flag){
        if (flag){
            mTextTitle.setVisibility(View.VISIBLE);
        }else {
            mTextTitle.setVisibility(View.GONE);
        }
    }

    //设置搜索框可见性
    public void setSearchViewVisable(boolean flag){
        if (flag){
            mEditSearchView.setVisibility(View.VISIBLE);
        }else {
            mEditSearchView.setVisibility(View.GONE);
        }
    }

    //给右侧按钮设置图片，也可以在布局文件中直接引入
    // 如：app:leftButtonIcon="@drawable/icon_back_32px"
    public void setRightButtonIcon(Drawable icon) {
        if (mRightButton != null) {
            mRightButton.setImageDrawable(icon);
            mRightButton.setVisibility(VISIBLE);
        }
    }

    //给左侧按钮设置图片，也可以在布局文件中直接引入
    private void setLeftButtonIcon(Drawable icon) {
        if (mLeftButton != null){
            mLeftButton.setImageDrawable(icon);
            mLeftButton.setVisibility(VISIBLE);
        }
    }

    //设置右侧按钮监听事件
    public void setRightButtonOnClickLinster(OnClickListener linster) {
        mRightButton.setOnClickListener(linster);
    }

    //设置左侧按钮监听事件
    public void setLeftButtonOnClickLinster(OnClickListener linster) {
        mLeftButton.setOnClickListener(linster);
    }


}