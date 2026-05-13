package starter;

import Util.InputUtil;
import action.UserAction;
import entity.FilmHall;
import menu.Menu;
import menu.MenuManager;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CinemaClient {

    public static void main(String[] args) {
        showInterface(MenuManager.LOGIN_MENUS);
    }

    /**
     * 展示界面
     */
    private static void showInterface(Menu[] menus) {
        MenuManager.showMenu(menus);
        int number = InputUtil.getInputInteger("请选择菜单编号", 1, menus.length);
        Menu select = menus[number - 1];
        switch (select.getAction()) {
            case "login":
                login();
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
                showInterface(MenuManager.LOGIN_MENUS);
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
            case "addFilm":
                UserAction.addFilm();
                showChildren(select);
                break;
            case "updateFilm":
                UserAction.updateFilm();
                showChildren(select);
                break;
            case "deleteFilm":
                UserAction.deleteFilm();
                showChildren(select);
                break;
            case "getFilmList":
                UserAction.getFilmList();
                showChildren(select);
                break;
            case "addFilmHall":
                UserAction.addFilmHall();
                showChildren(select);
                break;
            case "updateFilmHall":
                UserAction.updateFilmHall();
                showChildren(select);
                break;
            case "deleteFilmHall":
                UserAction.deleteFilmHall();
                showChildren(select);
                break;
            case "getFilmHallList":
                UserAction.getFilmHallList();
                showChildren(select);
                break;
            default:
                showChildren(select);
        }
    }

    private static void login() {
        Map<String, Object> res = UserAction.login();
        if (res == null) {
            System.out.println("登陆失败");
            showInterface(MenuManager.LOGIN_MENUS);
        } else {
            int process = (int) res.get("process");
            if (process == 1) {
                boolean isManager = (boolean) res.get("manager");
                Menu[] mainMenus = isManager ? MenuManager.MANAGER_MENUS : MenuManager.USER_MENUS;
                showInterface(mainMenus);
            } else {
                String tips;
                if (process == 0) {
                    tips = "账号或密码错误";
                } else if (process == -1) {
                    tips = "账号不存在，请先注册";
                } else {
                    tips = "账号已被冻结，请申请解冻";
                }
                System.out.println(tips);
                showInterface(MenuManager.LOGIN_MENUS);
            }
        }
    }

    /**
     * 展示与子菜单同级的菜单
     *
     * @param childMenu 所选的子菜单
     *
     */
    private static void showChildren(Menu childMenu) {
        Menu parent = childMenu.getParent();
        List<Menu> children = parent.getChildren();
        Menu[] menus = children.toArray(new Menu[0]);
        showInterface(menus);
    }
}
