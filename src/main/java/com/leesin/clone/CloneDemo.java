package com.leesin.clone;

import java.io.IOException;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 16:39
 * @modified By:
 */
public class CloneDemo {
    /*第一种深克隆*/
    // public static void main(String[] args) throws CloneNotSupportedException {
    //     Email email = new Email("今天晚上上课");
    //     User user = new User("mic");
    //     //发送邮件
    //     user.setEmail(email);
    //     //发送给其他人邮件
    //     User user1 = (User) user.clone();
    //     user1.setName("tom");
    //     //这里在clone方法已经set过了，所以这里不需要set了
    //     // user1.setEmail(email);
    //     //增加一个需求
    //     user1.getEmail().setContent("今天8点半上课，但是你需要8点到");
    //
    //     //发送
    //     User user2 = (User) user.clone();
    //     user2.setName("james");
    //     // user2.setEmail(email);
    //     user2.getEmail().setContent("今天9点半上课，但是你需要8点到");
    //
    //     System.out.println(user.getName() + "邮件内容：" + user.getEmail().getContent());
    //     System.out.println(user1.getName() + "邮件内容：" + user1.getEmail().getContent());
    //     System.out.println(user2.getName() + "邮件内容：" + user2.getEmail().getContent());
    //
    //
    // }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Email email = new Email("今天晚上上课");
        User user = new User("mic");
        //发送邮件
        user.setEmail(email);
        //发送给其他人邮件
        User user1 = (User) user.deepClone();
        user1.setName("tom");
        user1.getEmail().setContent("今天8点半上课，但是你需要8点到");
        System.out.println(user.getName() + "邮件内容：" + user.getEmail().getContent());
        System.out.println(user1.getName() + "邮件内容：" + user1.getEmail().getContent());
    }
}
