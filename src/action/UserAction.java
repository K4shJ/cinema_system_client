package action;

import Util.InputUtil;
import Util.SocketUtil;
import entity.User;
import message.Message;

/**
 * 用户行为
 */
public class UserAction {
    /**
     * 注册
     */
    public static void register() {
        String username = InputUtil.getInputText("请输入账号：");
        String pwd = InputUtil.getInputText("请输入密码：");
        String securityCode = InputUtil.getInputText("请输入安全码：");
        User user = new User(username, pwd, securityCode);
        Message<User> msg = new Message<>("register",user);
        Integer res = SocketUtil.sendMessage(msg);
        if(res != null && res == 1) System.out.println("注册成功");
        else if (res != null && res == -1) System.out.println("该账号已经被注册");
        else System.out.println("注册失败，请稍后重试");
    }

    /**
     * 登录
     */
    public static void login() {
    }

    /**
     * 找回密码
     */
    public static void getPasswordBack() {

    }

    /**
     * 解冻申请
     */
    public static void unfrozenApply() {

    }

    /**
     * 退出
     */
    public static void quit() {
        System.out.println("感谢使用");
        System.exit(0);
    }

    /**
     * 查看订单
     */
    public static void getOrderList() {

    }

    /**
     * 修改订单
     */
    public static void updateOrder() {

    }

    /**
     * 取消订单
     */
    public static void cancelOrder() {

    }

    /**
     * 审核订单
     */
    public static void auditOrder() {

    }

    /**
     * 查看影片
     */
    public static void getFilmList() {

    }

    /**
     * 增加影片
     */
    public static void addFilm() {

    }

    /**
     * 修改影片
     */
    public static void updateFilm() {

    }

    /**
     * 删除影片
     */
    public static void deleteFilm() {

    }

    /**
     * 查看影厅
     */
    public static void getFilmHallList() {

    }

    /**
     * 增加影厅
     */
    public static void addFilmHall() {

    }

    /**
     * 更改影厅
     */
    public static void updateFilmHall() {

    }

    /**
     * 删除影厅
     */
    public static void deleteFilmHall() {

    }

    /**
     * 查看播放计划
     */
    public static void getFilmPlan() {

    }

    /**
     * 添加播放计划
     */
    public static void addFilmPlan() {

    }

    /**
     * 更新播放计划
     */
    public static void updateFilmPlan() {

    }

    /**
     * 删除播放计划
     */
    public static void deleteFilmPlan() {

    }

    /**
     * 查看用户
     */
    public static void getUserList() {

    }

    /**
     * 冻结用户
     */
    public static void frozenUser() {

    }

    /**
     * 解冻用户
     */
    public static void unfrozenUser() {

    }

    /**
     * 查看解冻申请
     */
    public static void getUnfrozenApplyList() {

    }
}
