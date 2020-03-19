 package com.leesin.heightConcurrent.Interrupt;

 /**
  * @description: 源码
  *
  * 文件jvm.cpp->Thread.cpp->os_linux.cpp
  *
  *就是设置一个 interrupted 状态标识为 true、并且通过ParkEvent 的 unpark 方法来唤醒线程。
  *
  * @author: Leesin.Dong
  * @date: Created in 2020/3/17 15:31
  * @version:
  * @modified By:
  */
void os::interrupt(Thread* thread) {
    assert(Thread::current() == thread || Threads_lock->owned_by_self(),
            "possibility of dangling Thread pointer");
    //获取本地线程对象
    OSThread* osthread = thread->osthread();
    //判断本地线程对象是否中断
    if (!osthread->interrupted()) {
        //设置中断状态为true
        //set_interrupted调用osThread.hpp中的set_interrupted方法，osThread中定义了成员属性
        //volatile jint_interrupted 0或者1
        osthread->set_interrupted(true);
        // More than one thread can get here with the same value of osthread,
        // resulting in multiple notifications.  We do, however, want the store
        // to interrupted() to be visible to other threads before we execute unpark().
        //这里是内存屏障，这在后续的文章中会剖析，内存屏障的目的是使得interrupted状态对其他线程立即
        OrderAccess::fence();
        //_SleepEvent相当于Thread.sleep，标识如果线程调用了sleep方法，则通过unpark唤醒。
        ParkEvent * const slp = thread->_SleepEvent ;
        if (slp != NULL) slp->unpark() ;
    }

    // For JSR166. Unpark even if interrupt status already was set
    if (thread->is_Java_thread())
        ((JavaThread*)thread)->parker()->unpark();
    //_ParkEvent用于synchronize同步块和Object.wait()，这里相当于也是通过unpark处理唤醒。
    ParkEvent * ev = thread->_ParkEvent ;
    if (ev != NULL) ev->unpark() ;

}
