package nju.cs.Form;

/**
 * @author chenjiapeng
 * @Description
 * @date 2018-01-05
 */
public interface Priority {
    public void setPriority(Integer priority);
    public Integer getPriority();
    public boolean comparePriority(Priority priority);
}
