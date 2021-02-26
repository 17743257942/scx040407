package _2_http.callback;

public class Helper {

    public void helpXiaoMing(int a, int b, XiaoMing xiaoMing) {
        // you call me back
        xiaoMing.tellTeacherResult(a + b);
    }
}
