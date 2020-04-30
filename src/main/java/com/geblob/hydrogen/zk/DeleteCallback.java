package com.geblob.hydrogen.zk;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;

/**
 * 可以获取到，节点的路径，数据。以及事件的类型
 */
public class DeleteCallback implements BackgroundCallback {
    @Override
    public void processResult(CuratorFramework client, CuratorEvent event)
            throws Exception {
        System.out.println(event.getPath() + ",data=" + event.getData());
        System.out.println("event type=" + event.getType());
        System.out.println("event code=" + event.getResultCode());

    }

}