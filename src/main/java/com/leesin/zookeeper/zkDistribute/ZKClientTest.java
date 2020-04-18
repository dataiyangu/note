package com.leesin.zookeeper.zkDistribute;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * @description:先简单操作一把，感受一下API，给下面做准备
 * @author: Leesin Dong
 * @date: Created in 2020/4/14 21:53
 * @modified By:
 */
public class ZKClientTest {
    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String[] args) throws InterruptedException {
        //建立连接
        ZkClient zkClient = new ZkClient(CONNECTION_STR, 50000);

        String path = "/zkclient";

        //子节点监听
        zkClient.subscribeChildChanges(path, new IZkChildListener() {
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("路径"+parentPath+"下面的子节点变更，子节点为："+currentChilds);
            }
        });

        //监听节点
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("路径"+dataPath+"数据变成了"+data);
            }

            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("路径"+dataPath+"已经被删除了");
            }

        });




        //递归创建子节点（此时父节点并不存在）
        zkClient.createPersistent("/zkclient/al",true);
        Thread.sleep(5000);
        System.out.println(zkClient.getChildren(path));

        //递归删除
        zkClient.delete("/zkclient");
        System.out.println("删除成功");

        //获得子节点
        List<String> children = zkClient.getChildren("/leesin");
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i));
        }

    }
}
