package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SecondAcitvity extends AppCompatActivity {

    private ListView listView;
    private SmartRefreshLayout refreshLayout;
    private ArrayList<Map<String,String>> list=new ArrayList();
    String[] from = new String[]{"name","age"};
    int[] to = new int[]{R.id.name,R.id.age};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitvity);

        listView = findViewById(R.id.lv);
        refreshLayout = findViewById(R.id.refreshLayout);
        final TwoLevelHeader header = findViewById(R.id.header);


        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener(){
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(2000);
            }
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(SecondAcitvity.this,"触发刷新事件", Toast.LENGTH_SHORT).show();
                refreshLayout.finishRefresh(2000);
            }

            @Override
            public void onHeaderMoving(RefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
                super.onHeaderMoving(header, isDragging, percent, offset, headerHeight, maxDragHeight);
            }
        });

        header.setOnTwoLevelListener(new OnTwoLevelListener() {
            @Override
            public boolean onTwoLevel(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(SecondAcitvity.this,"触发二楼事件",Toast.LENGTH_SHORT).show();
//                findViewById(R.id.secondfloor_content).animate().alpha(1).setDuration(2000);
                ObjectAnimator objectAnimator =ObjectAnimator.ofFloat(findViewById(R.id.secondfloor_content),"alpha",1f);
                objectAnimator.setDuration(2000);
                objectAnimator.start();
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        header.finishTwoLevel();
                        findViewById(R.id.secondfloor_content).animate().alpha(0).setDuration(1000);
                    }
                },5000);
                return true;//true 将会展开二楼状态 false 关闭刷新
            }
        });

        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });

//        initData();

        View view= View.inflate(this,R.layout.headerview,null);
        listView.addHeaderView(view);
        listView.setAdapter(new SimpleAdapter(SecondAcitvity.this,list,R.layout.item,from,to));
    }

    private void initData() {
        for (int i =0;i<10;i++){
            Map map =new HashMap<String,String>();
            map.put("name","名字"+i);
            map.put("age","年龄"+i);
            list.add(map);
        }


    }
}
