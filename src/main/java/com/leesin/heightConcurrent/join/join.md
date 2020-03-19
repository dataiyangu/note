核心源码

 if (millis == 0) {  //由于上一步传入参数为0，因此调用当前判断
            while (isAlive()) { //判断子线程是否存活
                wait(0); //调用wait(0)方法
            }
}


/**
     * Tests if this thread is alive. A thread is alive if it has
     * been started and has not yet died.
     * 测试线程是否还活着。如果线程存活的话它就是已经开始，还没有死亡的状态。
     * @return  <code>true</code> if this thread is alive;
     *          <code>false</code> otherwise.
     */****
    public final native boolean isAlive();



链接：https://juejin.im/post/5b3054c66fb9a00e4d53ef75
