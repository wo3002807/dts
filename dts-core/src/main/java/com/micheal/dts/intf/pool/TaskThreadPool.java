package com.micheal.dts.intf.pool;

/**
 * 任务线程池
 */
public interface TaskThreadPool {
    boolean runInThread(Runnable runnable);

    int getAvailableThreadsCount();

    void initialize();

    void shutdown(boolean waitForJobsToComplete);
}
