#ѧ��:G20210579020286
#�༶:4��
#��ҵ&�ܽ�����:https://github.com/17743257942/JAVA-01/tree/main/Week_01

��1����ҵʵ��
1����ѡ�����Լ�дһ���򵥵� Hello.java��������Ҫ�漰�������ͣ��������У�if ��
for��Ȼ���Լ�����һ�¶�Ӧ���ֽ��룬������Ⱥ�����ۡ�
2�����������Զ���һ�� Classloader������һ�� Hello.xlass �ļ���ִ�� hello ������ ���ļ�������һ�� Hello.class �ļ������ֽڣ�x=255-x���������ļ����ļ�Ⱥ���ṩ��
3������������һ��ͼ��չʾ Xmx��Xms��Xmn��Metaspache��DirectMemory��Xss
��Щ�ڴ�����Ĺ�ϵ��
4����ѡ�������һ���Լ�ά����ҵ��ϵͳ�� JVM �������ã��� jstat �� jstack��jmap �鿴һ�����飬�����Լ���������һ�´�������˼����û�в�����ĵط�����θĽ���
ע�⣺
1������������������ϵͳ������ʹ��jmap���
2�����û������ϵͳ�������Լ� run һ�� web/java ��Ŀ������ֱ�Ӳ鿴idea���̡�
�����ص�֪ʶ�ʼǺʹ������ӣ�����Ⱥ���һ������������Ҫ��

�� 2 �ڿ���ҵʵ��
1������ʹ�� G1 GC ����һ�����򣬷��տ��ϰ�������һ�� JVM ���
����ʹ��gateway-server-0.0.1-SNAPSHOT.jar ע��ر�����Ӧ������-XX:-UseAdaptiveSizePolicy
> java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseSerialGC
-jar target/gateway-server- 0.0.1-SNAPSHOT.jar
> java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseParallelGC -jar target/gateway-server- 0.0.1-SNAPSHOT.jar
> java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseConcMarkSweepGC -jar target/gateway-server-0.0.1-SNAPSHOT.jar
> java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar target/gateway-server-0.0.1-SNAPSHOT.jar
ʹ��jmap��jstat��jstack���Լ����ӻ����ߣ��鿴jvm�����
mac�Ͽ�����wrk��windows�Ͽ��԰���superbenchmarkѹ��
http://localhost:8088/api/hello �鿴jvm��

git config --global credential.helper store
git init
git pull
git status
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/17743257942/JAVA01.git
git config --global --unset http.proxy
git config --global --unset https.proxy
git push -u origin main

jvm           123
nio           12
����          123
spring        123
mysql         12
�ֿ�ֱ�       123
�ֲ�ʽ����     12
�ֲ�ʽ����
�ֲ�ʽ��Ϣ
�ֲ�ʽϵͳ�ܹ�
�ع�
�ܹ�����


