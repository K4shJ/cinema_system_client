package action;

import Util.IdGenerator;
import Util.InputUtil;
import Util.SocketUtil;
import entity.Film;
import entity.UnfrozenApply;
import entity.User;
import message.Message;

import java.util.List;
import java.util.Map;

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
        Message<User> msg = new Message<>("register", user);
        Integer res = SocketUtil.sendMessage(msg);
        if (res != null && res == 1) System.out.println("注册成功");
        else if (res != null && res == -1) System.out.println("该账号已经被注册");
        else System.out.println("注册失败，请稍后重试");
    }

    /**
     * 登录
     */
    public static Map<String, Object> login() {
        String username = InputUtil.getInputText("请输入账号");
        String pwd = InputUtil.getInputText("请输入密码");
        User user = new User(username, pwd, null);
        Message<User> msg = new Message<>("login", user);
        return SocketUtil.sendMessage(msg);
    }

    /**
     * 找回密码
     */
    public static void getPasswordBack() {
        String username = InputUtil.getInputText("请输入账号");
        String securityCode = InputUtil.getInputText("请输入安全码");
        User user = new User(username, null, securityCode);
        Message<User> msg = new Message<>("getPasswordBack", user);
        String res = SocketUtil.sendMessage(msg);
        if (res == null) {
            System.out.println("找回失败，安全码错误");
        } else {
            System.out.println("您的密码是：" + res);
        }
    }

    /**
     * 解冻申请
     */
    public static void unfrozenApply() {
        String username = InputUtil.getInputText("请输入账号");
        String reason = InputUtil.getInputText("请输入解冻理由");
        UnfrozenApply apply = new UnfrozenApply(IdGenerator.generateId(10), username, reason);
        Message<UnfrozenApply> msg = new Message<>("unfrozenApply", apply);
        Integer res = SocketUtil.sendMessage(msg);
        if(res == null || res == 0){
            System.out.println("解冻申请失败，请稍后重试");
        }else if(res ==1) {
            System.out.println("解冻申请发送成功");
        }else {
            System.out.println("账号未被冻结，无需申请解冻");
        }
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
        String name = InputUtil.getInputText("请输入影片名字");
        Message<String>  msg = new Message<>("getFilmList", name);
        List<Film> filmList = SocketUtil.sendMessage(msg);
        if(filmList == null || filmList.isEmpty()){
            System.out.println("未找到与\""+name+"\"相关的影片信息");
        }else {
            System.out.println("影片编号\t\t影片名称\t制片人\t影片描述");
            filmList.forEach(System.out::println);
        }
    }

    /**
     * 增加影片
     */
    public static void addFilm() {
        String name = InputUtil.getInputText("请输入影片名称");
        String producer = InputUtil.getInputText("请输入制片人");
        String description = InputUtil.getInputText("请输入描述信息");
        Film film = new Film(IdGenerator.generateId(10),name, producer, description);
        Message<Film> msg = new Message<>("addFilm", film);
        Integer res = SocketUtil.sendMessage(msg);
        if(res == null || res == 0){
            System.out.println("添加失败，请稍后重试");
        }else{
            System.out.println("添加成功");
        }
    }

    /**
     * 修改影片
     */
    public static void updateFilm() {
        String id = InputUtil.getInputText("请输入影片编号：");
        String name = InputUtil.getInputText("请输入影片名称：");
        String producer = InputUtil.getInputText("请输入制片人：");
        String description = InputUtil.getInputText("请输入影片描述：");
        Film film = new Film(id, name, producer, description);
        Message<Film> msg = new Message<>("updateFilm", film);
        Integer res = SocketUtil.sendMessage(msg);
        if(res == null || res == 0){
            System.out.println("修改失败，请检查");
        }else if(res == 1){
            System.out.println("修改成功");
        }else{
            System.out.println("未找到与\""+id+"\"相关的影片信息");
        }
    }

    /**
     * 删除影片
     */
    public static void deleteFilm() {
        String id = InputUtil.getInputText("请输入要删除的影片id：");
        Message<String> msg = new Message<>("deleteFilm", id);
        Integer res = SocketUtil.sendMessage(msg);
        if(res == null || res == 0){
            System.out.println("删除失败请稍后重试");
        }else {
            System.out.println("删除成功");
        }
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
