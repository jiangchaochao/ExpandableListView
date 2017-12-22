package cn.yview.expandablelistview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListAdapter;
    String[] groupFrom = new String[]{"腾讯", "阿里", "百度"};
    List<Map<String, ?>> groupData = new ArrayList<>();    //父列表
    String[][] childStringArrs={
            {"QQ", "微信", "QQ浏览器"},
            {"百度搜索", "百度地图", "百度外卖"},
            {"淘宝", "支付宝", "天猫"}
    };
    List<List<Map<String, ?>>> childData = new ArrayList<>(); //子列表
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListAdapter = findViewById(R.id.expandableListView);

        /*初始化父列表*/
        for (int i = 0; i <groupFrom.length ; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("groupname", groupFrom[i]);
            groupData.add(map);
            List<Map<String, ?>> itemList = new ArrayList<>();
            for (int j = 0; j <childStringArrs[i].length ; j++) {
                Map<String, String> map1 = new HashMap<>();
                map1.put("itemname", childStringArrs[i][j]);
                itemList.add(map1);
            }
            childData.add(itemList);
        }

        SimpleExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(this, groupData, R.layout.item_group, new String[]{"groupname"}, new int[]{R.id.tv_group}, childData, R.layout.item_child, new String[]{"itemname"}, new int[]{R.id.child_item});

        expandableListAdapter.setAdapter(simpleExpandableListAdapter);


    }
}
