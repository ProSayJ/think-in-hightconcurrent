# 接口Runnable和接口Callable的区别

- Callable可以有返回值。
- 通过FutureTask包装成Runnable，传递给Thread，因为FutureTask是实现了Runnable接口。