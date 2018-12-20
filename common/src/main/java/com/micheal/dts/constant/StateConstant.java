package com.micheal.dts.constant;

/**
 * 状态常亮
 */
public class StateConstant {
    /**
     * 初始化
     */
    public static String INITIAL = "INITIAL";

    /**
     * 准备
     */
    public static String PREPARED = "PREPARED";

    /**
     * 等待
     */
    public static String WAITING = "WAITING";

    /**
     * 获取-可中断
     */
    public static String ACQUIRED = "ACQUIRED";

    /**
     * 执行-不可中断
     */
    public static String EXECUTING = "EXECUTING";

    /**
     * 执行完成
     */
    public static String COMPLETE = "COMPLETE";

    /**
     * 阻塞阶段
     */
    public static String BLOCKED = "BLOCKED";

    /**
     * 错误
     */
    public static String ERROR = "ERROR";

    /**
     * 暂停
     */
    public static String PAUSED = "PAUSED";

    /**
     * 暂停阻塞
     */
    public static String PAUSED_BLOCKED = "PAUSED_BLOCKED";

    /**
     * 删除
     */
    public static String DELETED = "DELETED";

    /**
     * 失败
     */
    public static String MISFIRED = "MISFIRED";
}
