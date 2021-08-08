package _5_spring.spring._7myspring_frame.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 根据包名提取所有class对象
 */
@Slf4j
public class ClassUtil {

    public static final String FILE_PROTOCOL = "file";

    /**
     * 根据包名提取所有class对象
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {

        // 1.获取类加载器
        ClassLoader classLoader = getClassLoader();
        // 2.加载资源
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (null == url) {
            log.warn("unable to retrieve anything from package: " + packageName);
            return null;
        }
        // 3.获取资源集合
        Set<Class<?>> classSet = null;
        //过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDir = new File(url.getPath());
            extractClassFile(classSet, packageDir, packageName);
        }

        return classSet;
    }

    /**
     * 递归获取所有class文件
     */
    private static void extractClassFile(Set<Class<?>> classSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()) {
            return;
        }
        //过滤出目录和.class结尾的
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    String absFilePath = file.getAbsolutePath();
                    if (absFilePath.endsWith(".class")) {
                        addToClassSet(absFilePath);
                    }
                }
                return false;
            }

            /**
             * 根据路径生成class对象并放入classSet
             */
            private void addToClassSet(String absFilePath) {
                //1.取出全路径类名
                absFilePath = absFilePath.replace(File.separator, ".");
                String className = absFilePath.substring(absFilePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf(".class"));
                //2.反射获取class对象
                Class<?> targetClass = loadClass(className);
                classSet.add(targetClass);
            }
        });
        //递归
        if (files != null) {
            for (File f : files) {
                extractClassFile(classSet, f, packageName);
            }
        }

    }


    /**
     * 加载类
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        /**
         * url =
         * file:/E:/codes/scx040407/qwer/target/classes/_5_spring/spring/_6mybatis/domain
         * packageDir =
         * E:\codes\scx040407\qwer\target\classes\_5_spring\spring\_6mybatis\domain
         */
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("_5_spring.spring._6mybatis.domain");
        System.out.println(classSet);
    }
}
