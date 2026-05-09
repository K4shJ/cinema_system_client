package Util;

import message.Message;

import java.io.*;
import java.net.Socket;

/**
 * 套接字工具类
 */
public class SocketUtil {

    private static final String IP = "127.0.0.1";

    private static final int PORT = 8888;

    /**
     * 与服务器之间的信息交互
     * @param msg 发送出去的消息
     * @return 从服务器接受的消息
     * @param <T> 不确定发送的消息使用的泛型
     * @param <V> 不确定接收消息的类型使用的泛型
     */
    public static <T, V> V sendMessage(Message<T> msg) {
        try {
            Socket client = new Socket(IP, PORT);
            OutputStream os = client.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(msg);
            oos.flush();
            client.shutdownOutput();
            InputStream is = client.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            V res = (V) ois.readObject();
            client.shutdownInput();
            return res;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
