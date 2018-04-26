package scu.edu.cn.util;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.Date;

/**
 * @author 黄伟
 * 测试json数据转换
 */
public class JsonTest {
    @Test
    public void parseJson() {
        Gson gson = new Gson();
        String json = "2018-03-20 ";

        Date date = gson.fromJson(json, Date.class);
        System.out.println(date);
    }
}
