package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 */
public class Menu {
    /**
     * 菜单编号
     */
    private int order;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单行为
     */
    private String action;
    /**
     * 子菜单列表
     */
    private List<Menu> children = new ArrayList<>();
    /**
     * 父菜单
     */
    private Menu parent;

    public Menu(int order, String name, String action, Menu parent) {
        this.order = order;
        this.name = name;
        this.action = action;
        this.parent = parent;
    }

    public Menu(int order, String name, String action) {
        this(order, name, action, null);
    }

    /**
     * 添加子菜单
     *
     * @param child
     */
    public void addChild(Menu child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return order + "，" + name;
    }

    /**
     * 获取action信息
     *
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * 获取子菜单列表
     *
     * @return
     */
    public List<Menu> getChildren() {
        return children;
    }

    /**
     * 获取父菜单
     *
     * @return
     */
    public Menu getParent() {
        return parent;
    }
}
