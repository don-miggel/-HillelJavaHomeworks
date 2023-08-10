package mytest.test_result;

import java.util.Map;

public class TestResult {

    private int total;
    private int succeed;
    private int failed;
    private int totalTimePassed;

    public TestResult(Map<String, Integer> testData){
        if(testData == null || testData.isEmpty()) throw new RuntimeException("Wrong argument passed!");
        total = testData.get("tests started");
        succeed = testData.get("tests successful");
        failed = testData.get("tests failed");
        totalTimePassed = testData.get("finished after");

    }

    public int getTotal() {
        return total;
    }

    public int getSucceed() {
        return succeed;
    }

    public int getFailed() {
        return failed;
    }

    public int getTotalTimePassed() {
        return totalTimePassed;
    }

    @Override
    public String toString() {
        return "TestResult [" +
                "total tests ran: " + total +
                ", total tests succeed: " + succeed +
                ", total tests failed: " + failed +
                ", total time passed: " + totalTimePassed +
                ']';
    }
}
