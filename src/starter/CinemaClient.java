package starter;

import Util.InputUtil;
import action.UserAction;
import menu.Menu;
import menu.MenuManager;

import java.util.Date;
import java.util.List;

public class CinemaClient {

    public static void main(String[] args) {
        showInterface(MenuManager.LOGIN_MENUS);
    }

    /**
     * 展示界面
     */
    private static void showInterface(Menu[] menus){
        MenuManager.showMenu(menus);
        int number = InputUtil.getInputInteger("请选择菜单编号",1,menus.length);
        Menu select = menus[number-1];
        switch(select.getAction()){
            case "login":
                UserAction.login();
                showInterface(MenuManager.USER_MENUS);
                break;
            case "register":
                UserAction.register();
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "getPasswordBack":
                UserAction.getPasswordBack();
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "unfrozenApply":
                UserAction.unfrozenApply();
                break;
            case "quit":
                UserAction.quit();
                break;
            case "showChildren":
                Menu[] childrenMenus = select.getChildren().toArray(new Menu[0]);
                showInterface(childrenMenus);
                break;
            case "goBackLogin":
                showInterface(MenuManager.LOGIN_MENUS);
                break;
            case "goBackMain":
                showInterface(MenuManager.USER_MENUS);
                break;
            default:
                Menu[] selectMenus = select.getParent().getChildren().toArray(new Menu[0]);
                showInterface(selectMenus);
        }
    }

//    private static void showLoginMenu() {
//        MenuManager.showMenu(MenuManager.LOGIN_MENUS);
//        int number = InputUtil.getInputInteger("请选择菜单编号", 1, MenuManager.LOGIN_MENUS.length);
//        Menu select = MenuManager.LOGIN_MENUS[number - 1];
//        switch (select.getAction()) {
//
//        }
//    }
//
//    private static void showMainMenu() {
//        MenuManager.showMenu(MenuManager.USER_MENUS);
//        int number = InputUtil.getInputInteger("请输入菜单编号：", 1, MenuManager.USER_MENUS.length);
//        Menu select = MenuManager.USER_MENUS[number - 1];
//        switch (select.getAction()) {
//
//        }
//    }
//
//    private static void showChildren(Menu parent) {
//
//        List<Menu> children = parent.getChildren();
//        Menu[] childrenArray = children.toArray(new Menu[children.size()]);
//        MenuManager.showMenu(childrenArray);
//        int number = InputUtil.getInputInteger("请输入菜单编号", 1, childrenArray.length);
//        Menu select = childrenArray[number - 1];
//        switch (select.getAction()) {
//
//        }
//    }
}
