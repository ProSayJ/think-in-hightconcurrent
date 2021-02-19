# cas原理

- cas全称Compare and swap，比较和交换的意思。原子操作，需要硬件的支持。
- 三个基本操作数：内存地址V，旧的预期值A，要修改的新值B。

## 举个线程A想执行相加的例子。

> 1.内存地址V有个值是1。<br>
2.线程A把V的值放在A中。 <br>
3.线程A执行V+2，得到的3为B。 <br>
4.把A和V的值比较，如果不一样，重新执行2的步骤。 <br>
5.如果一样，把V的值替换为B。

# synchronized，volatile，cas

- synchronized：独占锁，会导致其他所有需要锁的线程挂起，等待持有锁的线程释放锁。
- volatile：可见性，不保证原子性。
- cas：乐观锁，不适用锁的情况下实现多线程的变量同步。

## 缺点

1. ABA问题：在上面例子中，如果V的值是1，被B线程变成2，再被A线程变成1，那么对于A线程来说，还是当做没有变化。解决的办法就是加版本号。
2. 性能问题：在并发量较高的情况下，如果一直不成功，会一直增加CPU的开销。
3. 只能保证一个共享变量的原子操作。
