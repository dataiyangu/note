package com.leesin.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/29 11:46 上午
 */
public class Transaction {
    private static Integer a = 1;

    public static void main(String[] args) {
        transaction();
        System.out.println(a);
    }

    /**
    *
    **/
    @Autowired
    private static DataSourceTransactionManager transactionManager;

    public static void transaction() {
        //配置事物策略
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("planOne-transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // 设置状态点
        TransactionStatus transactionStatus = transactionManager.getTransaction(def);
        try {
            a = 2;
            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
        }
    }
}
