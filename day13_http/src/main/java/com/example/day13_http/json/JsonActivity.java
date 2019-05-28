package com.example.day13_http.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.day13_http.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_http_get,bt_http_post,bt_http_sd;
    String str1="{\"ret\":1,\"data\":[{\"id\":\"8289\",\"title\":\"\\u6cb9\\u7116\\u5927\\u867e\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/9\\/8289.jpg\",\"collect_num\":\"1667\",\"food_str\":\"\\u5927\\u867e \\u8471 \\u751f\\u59dc \\u690d\\u7269\\u6cb9 \\u6599\\u9152\",\"num\":1667},{\"id\":\"2127\",\"title\":\"\\u56db\\u5ddd\\u56de\\u9505\\u8089\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/3\\/2127.jpg\",\"collect_num\":\"1590\",\"food_str\":\"\\u732a\\u8089 \\u9752\\u849c \\u9752\\u6912 \\u7ea2\\u6912 \\u59dc\\u7247\",\"num\":1590},{\"id\":\"30630\",\"title\":\"\\u8d85\\u7b80\\u5355\\u8292\\u679c\\u5e03\\u4e01\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/31\\/30630.jpg\",\"collect_num\":\"1538\",\"food_str\":\"QQ\\u7cd6 \\u725b\\u5976 \\u8292\\u679c\",\"num\":1538},{\"id\":\"9073\",\"title\":\"\\u5bb6\\u5e38\\u7ea2\\u70e7\\u9c7c\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/10\\/9073.jpg\",\"collect_num\":\"1424\",\"food_str\":\"\\u9c9c\\u9c7c \\u59dc \\u8471 \\u849c \\u82b1\\u6912\",\"num\":1424},{\"id\":\"10097\",\"title\":\"\\u5bb6\\u5e38\\u714e\\u8c46\\u8150\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/11\\/10097.jpg\",\"collect_num\":\"1417\",\"food_str\":\"\\u8c46\\u8150 \\u65b0\\u9c9c\\u7ea2\\u6912 \\u9752\\u6912 \\u8471\\u82b1 \\u6cb9\",\"num\":1417},{\"id\":\"10509\",\"title\":\"\\u6c34\\u716e\\u8089\\u7247\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/11\\/10509.jpg\",\"collect_num\":\"1339\",\"food_str\":\"\\u7626\\u732a\\u8089 \\u751f\\u83dc \\u8c46\\u74e3\\u9171 \\u5e72\\u8fa3\\u6912 \\u82b1\\u6912\",\"num\":1339},{\"id\":\"46968\",\"title\":\"\\u7ea2\\u7cd6\\u82f9\\u679c\\u94f6\\u8033\\u6c64\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/47\\/46968.jpg\",\"collect_num\":\"1252\",\"food_str\":\"\\u94f6\\u8033 \\u82f9\\u679c \\u7ea2\\u7cd6\",\"num\":1252},{\"id\":\"10191\",\"title\":\"\\u9ebb\\u5a46\\u8c46\\u8150\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/11\\/10191.jpg\",\"collect_num\":\"1220\",\"food_str\":\"\\u8c46\\u8150 \\u8089\\u672b \\u751f\\u62bd \\u767d\\u7cd6 \\u829d\\u9ebb\\u6cb9\",\"num\":1220},{\"id\":\"2372\",\"title\":\"\\u76ae\\u86cb\\u7626\\u8089\\u7ca5\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/3\\/2372.jpg\",\"collect_num\":\"1151\",\"food_str\":\"\\u5927\\u7c73 \\u76ae\\u86cb \\u732a\\u8089 \\u6cb9\\u6761 \\u9999\\u8471\",\"num\":1151},{\"id\":\"2166\",\"title\":\"\\u8682\\u8681\\u4e0a\\u6811\",\"pic\":\"http:\\/\\/www.qubaobei.com\\/ios\\/cf\\/uploadfile\\/132\\/3\\/2166.jpg\",\"collect_num\":\"1143\",\"food_str\":\"\\u7ea2\\u85af\\u7c89 \\u8089 \\u59dc \\u849c \\u82b1\\u6912\",\"num\":1143}]}";
    String str="[{\"itemid\":\"625464\",\"title\":\"\\u5939\\u6c5f\\u53bf\\u946b\\u54c1\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575912\",\"edittime\":\"1539575912\",\"introduce\":\"\\u5939\\u6c5f\\u53bf\\u946b\\u54c1\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\\u662f\\u4e00\\u5bb6\\u96c6\\u82b1\\u578b\\u56fe\\u6848\\u5f00\\u53d1\\u3001\\u4e13\\u4e1a\\u751f\\u4ea7\\u3001\\u8425\\u9500\\u4e3a\\u4e00\\u4f53\\u7684\\u73b0\\u4ee3\\u5316\\u5382\\u5bb6\\u3002\\u672c\\u5382\\u91c7\\u7528\\u610f\\u5927\\u5229\\u5148\\u8fdb\\u6280\\u672f\\u751f\\u4ea7\\u9ad8\\u7ea7\\u6c34\\u6676\\u629b\\u6676\\u7816\\u3001\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1158284178703.png.thumb.png\",\"address\":\"\\u5317\\u4eac\",\"homepage\":\"\",\"areaid\":\"1\",\"comment\":0},{\"itemid\":\"625463\",\"title\":\"\\u63ed\\u9633\\u5e02\\u53d1\\u8d22\\u9a6c\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575875\",\"edittime\":\"1539575875\",\"introduce\":\"\\u53d1\\u8d22\\u9a6c\\u88c5\\u9970\\u6750\\u6599\\u5382\\u5730\\u5904\\u63ed\\u9633\\u6995\\u6c5f\\u6cb3\\u7554\\uff0c\\u662f\\u65b0\\u578b\\u88c5\\u9970\\u6750\\u6599\\u751f\\u6001\\u6728\\u677f\\u5382\\u5bb6\\u3002\\u81ea\\u6709\\u4ea7\\u7ebf10\\u6761\\uff0c\\u4e13\\u4e1a\\u751f\\u4ea7\\u7af9\\u6728\\u7ea4\\u7ef4\\u5899\\u677f\\u3001\\u751f\\u6001\\u6728\\u957f\\u57ce\\u677f\\u4ee5\\u53ca\\u914d\\u5957\\u7528\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1157422878703.png.thumb.png\",\"address\":\"\\u6cb3\\u5357\",\"homepage\":\"\",\"areaid\":\"17\",\"comment\":0},{\"itemid\":\"625462\",\"title\":\"\\u4e34\\u6c82\\u5e02\\u5170\\u5c71\\u533a\\u4e7e\\u660a\\u88c5\\u9970\\u6750\\u6599\\u5382\",\"addtime\":\"1539575821\",\"edittime\":\"1539575821\",\"introduce\":\"\\u4e34\\u6c82\\u5e02\\u5170\\u5c71\\u533a\\u4e7e\\u660a\\u88c5\\u9970\\u6750\\u6599\\u5382 \\u7ecf\\u9500\\u6279\\u53d1\\u7684\\u5899\\u677f\\u3001\\u5f27\\u5f62\\u677f\\u3001\\u5929\\u82b1\\u3001\\u65b9\\u6728\\u3001\\u6d6e\\u96d5\\u677f\\u7545\\u9500\\u6d88\\u8d39\\u8005\\u5e02\\u573a\\uff0c\\u5728\\u6d88\\u8d39\\u8005\\u5f53\\u4e2d\\u4eab\\u6709\\u8f83\\u9ad8\\u7684\\u5730\\u4f4d\\uff0c\\u516c\\u53f8\\u4e0e\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1156534778703.png.thumb.png\",\"address\":\"\\u5c71\\u897f\",\"homepage\":\"\",\"areaid\":\"6\",\"comment\":0},{\"itemid\":\"625461\",\"title\":\"\\u91d1\\u534e\\u5e02\\u91d1\\u4e1c\\u533a\\u96c5\\u534e\\u88c5\\u9970\\u6750\\u6599\\u5382\",\"addtime\":\"1539575785\",\"edittime\":\"1539575785\",\"introduce\":\"\\u91d1\\u534e\\u5e02\\u91d1\\u4e1c\\u533a\\u96c5\\u534e\\u88c5\\u9970\\u6750\\u6599\\u521b\\u7acb\\u4e8e2013\\u5e74\\uff0c\\u81f4\\u529b\\u4e8e\\u751f\\u4ea7\\u3001\\u9500\\u552e\\u6c34\\u8f6c\\u5370\\u77f3\\u5851\\u88c5\\u9970\\u82b1\\u3001\\u7f57\\u9a6c\\u67f1\\u3001\\u6574\\u4f53\\u80cc\\u666f\\u5899\\u3001\\u7ebf\\u6761\\u3001\\u5f2f\\u5f27\\u52a0\\u5de5\\u7b49\\uff0c\\u5df2\\u5f62\\u6210\\u4e86\\u7f51\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1156128378703.png.thumb.png\",\"address\":\"\\u6d59\\u6c5f\",\"homepage\":\"\",\"areaid\":\"12\",\"comment\":0},{\"itemid\":\"625460\",\"title\":\"\\u5c71\\u4e1c\\u65f6\\u6548\\u5efa\\u7b51\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575737\",\"edittime\":\"1539575737\",\"introduce\":\"\\u5c71\\u4e1c\\u65f6\\u6548\\u5efa\\u7b51\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\\u662f\\u88c5\\u9970\\u6750\\u6599\\u7b49\\u4ea7\\u54c1\\u4e13\\u4e1a\\u751f\\u4ea7\\u52a0\\u5de5\\u7684\\u516c\\u53f8\\uff0c\\u62e5\\u6709\\u5b8c\\u6574\\u3001\\u79d1\\u5b66\\u7684\\u8d28\\u91cf\\u7ba1\\u7406\\u4f53\\u7cfb\\u3002\\u5c71\\u4e1c\\u65f6\\u6548\\u5efa\\u7b51\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1155347078703.png.thumb.png\",\"address\":\"\\u5c71\\u4e1c\",\"homepage\":\"\",\"areaid\":\"16\",\"comment\":0},{\"itemid\":\"625459\",\"title\":\"\\u5357\\u660c\\u7ecf\\u6d4e\\u6280\\u672f\\u5f00\\u53d1\\u533a\\u4e1c\\u7ea2\\u88c5\\u9970\\u6750\\u6599\\u5382\",\"addtime\":\"1539575699\",\"edittime\":\"1539575699\",\"introduce\":\"\\u5357\\u660c\\u7ecf\\u6d4e\\u6280\\u672f\\u5f00\\u53d1\\u533a\\u4e1c\\u7ea2\\u88c5\\u9970\\u6750\\u6599\\u5382\\u4e3b\\u8425\\u4e50\\u9970\\u5bb6\\u54c1\\u724c\\u7af9\\u6728\\u7ea4\\u7ef4\\u96c6\\u6210\\u5899\\u677f\\u3001\\u62a4\\u5899\\u677f\\u6279\\u53d1\\u3001\\u96c6\\u6210\\u5899\\u677f\\u6279\\u53d1\\u3001\\u73af\\u4fdd\\u5feb\\u88c5\\u5899\\u677f\\u6279\\u53d1\\u3001\\u5899\\u9762\\u88c5\\u9970\\u7ebf\\u6761\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1154511178703.png.thumb.png\",\"address\":\"\\u6c5f\\u897f\",\"homepage\":\"\",\"areaid\":\"15\",\"comment\":0},{\"itemid\":\"625458\",\"title\":\"\\u4e49\\u4e4c\\u5e02\\u82f1\\u8c6a\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575657\",\"edittime\":\"1539575657\",\"introduce\":\"\\u4e49\\u4e4c\\u5e02\\u82f1\\u8c6a\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\\u662f\\u76f8\\u6846\\u7ebf\\u6761\\u3001\\u753b\\u6846\\u7ebf\\u6761\\u3001\\u955c\\u6846\\u7ebf\\u6761\\u3001\\u7af9\\u6728\\u7ea4\\u7ef4\\u677f\\u3001\\u77f3\\u5851\\u7ebf\\u6761\\u7b49\\u4ea7\\u54c1\\u4e13\\u4e1a\\u751f\\u4ea7\\u52a0\\u5de5\\u7684\\u516c\\u53f8\\uff0c\\u62e5\\u6709\\u5b8c\\u6574\\u3001\\u79d1\\u5b66\\u7684\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1154099078703.png.thumb.png\",\"address\":\"\\u6d59\\u6c5f\",\"homepage\":\"\",\"areaid\":\"12\",\"comment\":0},{\"itemid\":\"625457\",\"title\":\"\\u4e1c\\u839e\\u5e02\\u78a7\\u7389\\u5986\\u57ce\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575612\",\"edittime\":\"1539575612\",\"introduce\":\"\\u4e1c\\u839e\\u5e02\\u78a7\\u7389\\u5986\\u57ce\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\\u96c6\\u7814\\u53d1\\u3001\\u751f\\u4ea7\\u3001\\u9500\\u552e\\u4e3a\\u4e00\\u4f53\\uff0c\\u503e\\u529b\\u6253\\u9020\\u5ba4\\u5185\\u4eba\\u9020\\u7389\\u77f3\\u88c5\\u9970\\u4ea7\\u54c1\\u3002 \\u516c\\u53f8\\u8bbe\\u8ba1\\u7814\\u53d1\\u7684\\u4eba\\u9020\\u7389\\u77f3\\u9633\\u89d2\\u7ebf\\u83b7\\u5f97\\u56fd\\u5bb6\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1153161378703.png.thumb.png\",\"address\":\"\\u5e7f\\u4e1c\",\"homepage\":\"\",\"areaid\":\"20\",\"comment\":0},{\"itemid\":\"625456\",\"title\":\"\\u897f\\u5b89\\u5e02\\u4e34\\u6f7c\\u533a\\u4e2d\\u88d5\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575565\",\"edittime\":\"1539575565\",\"introduce\":\"\\u897f\\u5b89\\u5e02\\u4e34\\u6f7c\\u533a\\u4e2d\\u88d5\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\\uff08\\u539f\\u897f\\u5b89\\u6ca3\\u4e1c\\u65b0\\u57ce\\u4e2d\\u88d5\\u5efa\\u6750\\u6709\\u9650\\u516c\\u53f8\\u3001\\u897f\\u5b89\\u5e02\\u957f\\u5b89\\u533a\\u8054\\u521b\\u5efa\\u6750\\u5382\\uff0c\\u6210\\u7acb\\u4e8e2008\\u5e743\\u6708\\uff09\\u5750\\u843d\\u4e8e\\u795e\\u79d8\\u53e4\\u90fd\\uff08\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1152406978703.png.thumb.png\",\"address\":\"\\u9655\\u897f\",\"homepage\":\"\",\"areaid\":\"27\",\"comment\":0},{\"itemid\":\"625455\",\"title\":\"\\u4f5b\\u5c71\\u5e02\\u4e3d\\u5ddd\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\",\"addtime\":\"1539575525\",\"edittime\":\"1539575525\",\"introduce\":\"\\u4f5b\\u5c71\\u5e02\\u4e3d\\u5ddd\\u88c5\\u9970\\u6750\\u6599\\u6709\\u9650\\u516c\\u53f8\\u4e00\\u76f4\\u81f4\\u529b\\u4e8e\\u5bb6\\u5c45\\u88c5\\u9970\\u4fee\\u8fb9\\u7cfb\\u7edf\\u7684\\u751f\\u4ea7\\u9500\\u552e\\u548c\\u7814\\u53d1\\uff0c\\u516c\\u53f8\\u4e3b\\u8425\\u94dd\\u5408\\u91d1\\u4fee\\u8fb9\\u7ebf\\u3001\\u4e0d\\u9508\\u94a2\\u4fee\\u8fb9\\u7ebf\\u3001\\u5730\\u677f\\u6263\\u6761\\u3001UV\\u677f\",\"thumb\":\"http:\\/\\/d.yunzhancn.cn\\/file\\/upload\\/201810\\/15\\/1152005678703.png.thumb.png\",\"address\":\"\\u5e7f\\u4e1c\",\"homepage\":\"\",\"areaid\":\"20\",\"comment\":0}]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        bt_http_get=findViewById(R.id.bt_http_get);
        bt_http_get.setOnClickListener(this);
        bt_http_post=findViewById(R.id.bt_http_post);
        bt_http_post.setOnClickListener(this);
        bt_http_sd=findViewById(R.id.bt_http_sd);
        bt_http_sd.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_http_get:
                //原生对象
                try {
                    bt_http_get();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            //原生 数组
            case R.id.bt_http_post:
                try {
                    bt_http_post();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            //gson 数组
            case R.id.bt_http_sd:
                bt_http_sd();
                break;
        }
    }
    //gson 数组
    private void bt_http_sd() {
        Gson gson = new Gson();
        ArrayList<Bean> list=gson.fromJson(str,new TypeToken<ArrayList<Bean>>(){}.getType());
        Log.d("ytx", "gson 数组: "+list);
    }
    //原生 数组
    private void bt_http_post() throws JSONException {
        ArrayList<Bean> list = new ArrayList<>();
        JSONArray array = new JSONArray(str);//JSONArrray使用org 不要使用google
        for(int i=0;i<array.length();i++){
            JSONObject jsonObject = array.getJSONObject(i);//获得json对象
            /**
             * itemid : 625464
             * title : 夹江县鑫品建材有限公司
             * addtime : 1539575912
             * edittime : 1539575912
             * introduce : 夹江县鑫品建材有限公司是一家集花型图案开发、专业生产、营销为一体的现代化厂家。本厂采用意大利先进技术生产高级水晶抛晶砖、
             * thumb : http://d.yunzhancn.cn/file/upload/201810/15/1158284178703.png.thumb.png
             * address : 北京
             * homepage :
             * areaid : 1
             * comment : 0
             */
            String itemid = jsonObject.getString("itemid");
            String title = jsonObject.getString("title");
            String addtime = jsonObject.getString("addtime");
            String edittime = jsonObject.getString("edittime");
            String introduce = jsonObject.getString("introduce");
            String thumb = jsonObject.getString("thumb");
            String address = jsonObject.getString("address");
            String homepage = jsonObject.getString("homepage");
            String areaid = jsonObject.getString("areaid");
            int comment = jsonObject.getInt("comment");
            list.add(new Bean(itemid,title,addtime,edittime,introduce,thumb,address,homepage,areaid,comment));
        }
        Log.d("ytx", "原生 数组: "+list);

    }
    //原生对象
    private void bt_http_get() throws JSONException {
        ArrayList<Bean1.DataBean> list=new ArrayList<>();
        JSONObject object = new JSONObject(str1);
        JSONArray array = object.getJSONArray("data");
        for(int i=0;i<array.length();i++){
            JSONObject jsonObject = array.getJSONObject(i);//获得json对象
            /**
             * id : 8289
             * title : 油焖大虾
             * pic : http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg
             * collect_num : 1667
             * food_str : 大虾 葱 生姜 植物油 料酒
             * num : 1667
             */
            String id = jsonObject.getString("id");
            String title = jsonObject.getString("title");
            String pic = jsonObject.getString("pic");
            String collect_num = jsonObject.getString("collect_num");
            String food_str = jsonObject.getString("food_str");
            int num = jsonObject.getInt("num");
            list.add(new Bean1.DataBean(id,title,pic,collect_num,food_str,num));
        }
        Log.d("ytx", "原生 对象: "+list);

    }
}
