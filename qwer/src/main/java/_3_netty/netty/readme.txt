channelOption中的属性了解
https://blog.csdn.net/qq_28198181/article/details/82152338

Netty之ServerBootstrap的handler和childhandler的区别
https://blog.csdn.net/jiezhang656/article/details/105197013/


Netty系列学习
https://blog.csdn.net/liujiahan629629/category_9282501.html


服务端还是客户端都进行了handler的设置，通过添加hanlder，我们可以监听Channel的各种动作以及状态的改变，包括连接，绑定，接收消息等。

在基类AbstractBootstrap有handler方法，目的是添加一个handler，监听Bootstrap的动作，客户端的Bootstrap中，继承了这一点。

在服务端的ServerBootstrap中增加了一个方法childHandler，它的目的是添加handler，用来监听已经连接的客户端的Channel的动作和状态。

handler在初始化时就会执行，而childHandler会在客户端成功connect后才执行，这是两者的区别。