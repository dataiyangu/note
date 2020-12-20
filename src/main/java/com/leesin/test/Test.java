package com.leesin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/25 5:47 下午
 */
public class Test {
    public static void main(String[] args) {
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(null));
        System.out.println(jsonObject);

        Boolean b;
        System.out.println(b);

    }




    public static void levelOrder(TreeNode head) {
        List<String> documents = new ArrayList<>();
        if (head != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(head);
            while (!queue.isEmpty()) {
                //获取当前层的节点数
                int levelNum = queue.size();
                //一层的操作
                for (int i = 0; i < levelNum; i++) {
                    TreeNode poll = queue.poll();//出队

                    //
                    for (String documentOriginal : poll.getDocumentOriginal()) {
                        for (String value : poll.getValue()) {
                            // TODO: 每个子节点都在原来的一个文档中新建一个记录[拼接]，原来的文档数 n -> n*子节点数
                            //  每经过一个节点一次分裂一次
                            // 创建一个新文档：
                            String newDocument = documentOriginal + value;
                            documents.add(newDocument);
                        }
                    }

                    // 有子节点进入队列
                    if (poll.getChildren().size() > 0) {
                        poll.getChildren().forEach((key, value) ->
                                queue.offer(value)
                        );
                    }

                }
            }
        }
    }

    class TreeNode {
        // 原来文档[已经有的文档]
        public List<String> documentOriginal;
        // 当前字段有多个值
        public List<String> value;
        public Map<String, TreeNode> children;
        //构造方法

        public TreeNode(List<String> documentOriginal, List<String> value, Map<String, TreeNode> children) {
            this.documentOriginal = documentOriginal;
            this.value = value;
            this.children = children;
        }

        public List<String> getDocumentOriginal() {
            return documentOriginal;
        }

        public void setDocumentOriginal(List<String> documentOriginal) {
            this.documentOriginal = documentOriginal;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        public Map<String, TreeNode> getChildren() {
            return children;
        }

        public void setChildren(Map<String, TreeNode> children) {
            this.children = children;
        }
    }

    class Document {

    }
}


