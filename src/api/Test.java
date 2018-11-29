package api;
/**
 * 
* @ClassName: Test
* @Description: TODO(这里用一句话描述这个类的作用)
* @author wuqia
* @date 2017年5月11日 下午3:50:47
*
 */
public enum Test {
    /**
     * 
     */
    normal(1, "正常"), freeze(2, "锁定/冻结"), deleted(9, "作废/删除");
    /**
     * 
     */
    private int value;
    /**
     * 
     */
    private String displayName;

    Test(int value, String displayName)
    {
        this.value = value;
        this.displayName = displayName;
    }

    /**
     * @Title:displayName
     * @Description:
     * @return
     * @return Status
     * @throws
     */
    public String displayName()
    {
        return displayName;
    }

    public int getValue()
    {
        return value;
    }
}

