package org.kmo.program.P17;

import java.util.Arrays;

public class Tests {
    public static void main(String[] args) throws Exception {
//        UserService userService = new UserServiceImpl();
        UserService userService = ProxyUtil.createProxy(new UserServiceImpl());

        userService.login("admin","123456");
        System.out.println("--------------------");
        userService.deleteUsers();
        System.out.println("--------------------");
        String[] strings = userService.selectUsers();
        System.out.println(Arrays.toString(strings));
        System.out.println("--------------------");

    }
}
