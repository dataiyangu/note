package com.leesin.zookeeper.curator.apiStudy;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/4/12 15:39
 * @version: ${VERSION}
 * @modified By:
 */
public class AclDemo {
    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString(CONNECTION_STR).sessionTimeoutMs(5000).
                //给当前的会话授权，因为下面加了权限，这个也算是一个客户端
                authorization("digest", "admin:admin".getBytes()).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();

        curatorFramework.start();

        //权限模式：ip/Digest/world/super   digest
        List<ACL> list = new ArrayList<ACL>();
        //读权限
        //客户端需要 addauth digest admin:admin ，但是如果是只读的，设置了权限，也是不能修改的。set /xxx xx 不行
        //每次访问需要自己授权，就像电商网站的登录注册
        ACL acl = new ACL(ZooDefs.Perms.READ, new Id("digest",
                //加密用户名密码  不可逆的
                DigestAuthenticationProvider.generateDigest("admin:admin")));

        //ip的方式
        // ACL acl = new ACL(ZooDefs.Perms.READ, new Id("ip", "192.169.8.111"));

        //world方式   anyone 开放权限
        // ACL acl = new ACL(ZooDefs.Perms.READ, new Id("world", "anyone"));

        list.add(acl);
        //创建新的节点并添加权限 withACL是关键点
        // curatorFramework.create().withMode(CreateMode.PERSISTENT).withACL(list).forPath("/auth");

        //设置已经存在的节点的权限
        curatorFramework.setACL().withACL(list).forPath("/temp");

        //curator内置的一些权限：CREATOR_ALL_ACL创建者拥有所有的权限、READ_ACL_UNSAFE、ANYONE_ID_UNSAFE 等
        //这种方式和上面手写是一样的效果
        curatorFramework.setACL().withACL(ZooDefs.Ids.CREATOR_ALL_ACL).forPath("/temp");
    }
}
