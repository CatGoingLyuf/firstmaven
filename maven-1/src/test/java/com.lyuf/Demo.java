package com.lyuf;

import org.junit.Test;

/**
 * @author lyuf
 * @date 2020/9/21 16:58
 */
public class Demo {

    @Test
    public void testUser() {
        User user = new User();
        user.setUsername("lyuf");

        System.out.println(user);
    }

}
