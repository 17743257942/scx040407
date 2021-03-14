TransactionDefinition接口
获取事务对象名称 String getName()
获取事务隔离级别(对应spring中事务属性isolation) int getIsolationLevel()
  ISOLATION_DEFAULT 默认级别，和数据库相同
  ISOLATION_READ_UNCOMMITTED 读未提交，会出现脏读，不可重复读，幻读
  ISOLATION_READ_COMMITTED 读已提交，会出现不可重复读，幻读
  ISOLATION_REPEATABLE_READ 可重复读，会出现幻读
  ISOLATION_SERIALIZABLE 串行化，全解决
获取事务传播行为(propagation) int getPropagationBehavior()
  REQUIRED 默认值，如果没有事务就新建一个，如果存在就加入
  SUPPORTS 支持当前事务，如果当前没有就以非事务执行
  MANDATORY 使用当前，没有就抛异常
  REQUERS_NEW 新建事务，当前有就挂起
  NOT_SUPPORTED 非事务执行，当前有就挂起
  NEVER 非事务执行，当前存在就抛异常
  NESTED 如果当前存在事务则在嵌套事务内运行，没有则新建
获取事务超时时间(timeout) int getTimeout() 默认-1没有限制
获取事务是否只读(read-only) boolean isReadOnly() 查询时设置为只读

TransactionStatus接口
刷新事务 void flush()
获取是否存在存储点 boolean hasSavePoint()
获取事务是否完成 boolean isCompleted()
获取事务是否为新的事务 boolean isNewTransaction()
获取事务是否回滚 boolean isRollbackOnly()
设置事务回滚 void setRollBackOnly()

