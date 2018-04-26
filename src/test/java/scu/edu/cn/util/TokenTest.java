package scu.edu.cn.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author  黄伟
 * 测试生成的token
 */
public class TokenTest {
    @Test
    public void getToken() throws Exception {
        Token token = new Token();
        System.out.println(token.getToken());
    }

}