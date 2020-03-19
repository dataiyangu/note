# interrupt()作用
1. interrupted状态标识为 true
2. 通过ParkEvent 的 unpark 方法来唤醒线程（Object.wait 、 Thread.sleep 、 Thread.join）。


并没有真正意义去中断，只是去给一个“你需要中断”的标识，需要加一个判断才能停止线程

注意：
对于 synchronized 阻塞的线程，被唤醒以后会继续尝试获取锁，如果失败仍然可能被 park？？？？？
在调用 ParkEvent 的 park 方法之前，会先判断线程的中断状态，如果为 true， 会清除当前线程的中断标识变为false
Object.wait 、 Thread.sleep 、 Thread.join 会 抛 出InterruptedException

# interrupted()作用
true->false
1. 复位（清除状态）
2. 返回复位之前的值。

是当前线程对外界中断信号的一个响应，表示自己已经得到了中断信号，但不会立刻中断自己，具体什么时候中断由自己决定，  
让外界知道在自身中断前， 他的中断状态仍然是false，这就是复位的原因。

为什么变为了false？
因为这里是已经知道了interrupt了，具体怎么做自己决定，可以中断可以不中断，如果是不中断的话，如果不改为false无法运行了下次。

# 为什么Object.wait、Thread.sleep、Thread.join这些阻塞方法都会抛出InterruptException？
这些方法都需要等待外部的触发时间终止，可能等不到这个时间了。
所以抛出这个一个异常，通知当前执行这个阻塞方法的线程被中断，
然后通过is_interrupted方法判断中断标识，如果为true，清除中断标识，并抛出异常。
在异常中可以终止，也可以不终止（不处理，往外跑异常，终止当前线程。）

所以这个真正意义上并不是一个异常，只是“开了一个口子”，允许在阻塞的时候进行中断。

