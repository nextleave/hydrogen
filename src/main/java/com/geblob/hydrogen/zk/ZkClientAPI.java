package com.geblob.hydrogen.zk;


import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;

public class ZkClientAPI {

    public static void main(String[] args) {

        // 连接串
        String serverString = "127.0.0.1:2181";

        // 连接超时时间
        int timeout = 2000;

        ZkClient zk = new ZkClient(serverString, timeout);

        zk.create("/demo", "hello demo", CreateMode.PERSISTENT);

        Object obj = zk.readData("/demo");
        System.out.println(obj);

        // 关闭连接
        zk.close();
    }
}