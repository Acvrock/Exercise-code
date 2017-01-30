package com.acvrock;

import java.util.concurrent.RecursiveAction;

/**
 * Created by moon on 30/01/2017.
 *
 * @Description:
 */
//RecursiveAction为ForkJoinTask的抽象子类，没有返回值的任务
class PrintTask extends RecursiveAction {
    // 每个"小任务"最多只打印50个数
    private static final int MAX = 50;

    private int start;
    private int end;

    PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end-start的值小于MAX时候，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值:"
                        + i);
            }
        } else {
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}

