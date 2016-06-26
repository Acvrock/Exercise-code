import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.GetNotificationResponse;
import com.baidubce.services.lss.model.ListNotificationsResponse;

/**
 * Created by moon on 6/22/16.
 *
 * @Description: 参数不明,不确定是 后台接口地址还是其他的
 */
public class Notifications {

    /**
     * 创建 Notification
     * @param client
     * @param name
     * @param endpoint
     */
    public static void createNotification(LssClient client, String name, String endpoint) {
        client.createNotification(name, endpoint);
    }

    /**
     * 查看所有的 Notification
     * @param client
     */
    public static void listNotifications(LssClient client) {
        ListNotificationsResponse resp = client.listNotifications();
        System.out.println(resp.toString());
    }

    /**
     * 查询指定的 Notification
     * @param client
     * @param name
     */
    public static void getNotification(LssClient client, String name) {
        GetNotificationResponse resp = client.getNotification(name);
        System.out.println("name: " + resp.getName());
        System.out.println("endpoint: " + resp.getEndpoint());
    }

    /**
     * 删除某个 Notification
     * @param client
     * @param name
     */
    public static void deleteNotification(LssClient client, String name) {
        client.deleteNotification(name);
    }


}
