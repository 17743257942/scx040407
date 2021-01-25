package week02.callback;

public class XiaoMing {
    public int a;
    public int b;

    public XiaoMing(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void tellTeacherResult(int result) {
        System.out.println("hello teacher , the result is " + result);
    }

    // i call you   xiaoming call helper
    public void callHelp() {
        new Helper().helpXiaoMing(a, b, this);
    }


}
