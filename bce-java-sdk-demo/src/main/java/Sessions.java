import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.*;

import java.util.Map;

/**
 * Created by moon on 6/22/16.
 *
 * @Description:
 */
public class Sessions {

    /**
     * 创建 推流模式Session
     *
     * @param client
     * @param description
     * @param preset
     * @param notification
     * @param securityPolicy
     * @param recording
     */
    public static void createPushSession(LssClient client, String description, String preset, String notification, String securityPolicy, String recording) {
        CreateSessionResponse resp = client.createSession(description, preset, notification, securityPolicy, recording, null);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        if (resp.getPublish() != null) {
            System.out.println("push url: " + resp.getPublish().getPushUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null && resp.getPlay().getHlsUrl() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
        }
        if (resp.getPlay() != null && resp.getPlay().getRtmpUrl() != null) {
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }

    /**
     * 创建拉流模式Session
     *
     * @param client
     * @param description
     * @param preset
     * @param notification
     * @param securityPolicy
     * @param recording
     * @param publish
     */
    public static void createPullSession(LssClient client, String description, String preset, String notification,
                                         String securityPolicy, String recording, LivePublishInfo publish) {
        CreateSessionResponse resp = client.createSession(description, preset, notification, securityPolicy, recording, publish);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        if (resp.getPublish() != null) {
            System.out.println("pull url: " + resp.getPublish().getPullUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null && resp.getPlay().getHlsUrl() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
        }
        if (resp.getPlay() != null && resp.getPlay().getRtmpUrl() != null) {
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }

    /**
     * 查看目前拥有的Session
     *
     * @param client
     */
    public static void listSessions(LssClient client) {
        ListSessionsResponse resp = client.listSessions();
        System.out.println(resp.toString());
    }


    /**
     * 安全策略未开启推流/播放认证，查询指定session代码如下：
     *
     * @param client
     * @param sessionId
     */
    public static void getSession(LssClient client, String sessionId) {
        GetSessionResponse resp = client.getSession(sessionId);
        System.out.println("sessionId: " + resp.getSessionId());
        System.out.println("preset: " + resp.getPreset());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
        System.out.println("notification: " + resp.getNotification());
        System.out.println("status: " + resp.getStatus());
        System.out.println("securityPolicy: " + resp.getSecurityPolicy());
        System.out.println("recording: " + resp.getRecording());
        System.out.println("streamingStatus: " + resp.getStreamingStatus());
        if (resp.getPublish() != null) {
            System.out.println("push url: " + resp.getPublish().getPushUrl());
            System.out.println("pull url: " + resp.getPublish().getPullUrl());
            System.out.println("region: " + resp.getPublish().getRegion());
        }
        if (resp.getPlay() != null) {
            System.out.println("hls url: " + resp.getPlay().getHlsUrl());
            System.out.println("rtmp url: " + resp.getPlay().getRtmpUrl());
        }
    }


    /**
     * 插入提示点
     *
     * @param client
     * @param sessionId
     * @param callback
     * @param arguments
     */
    public static void  insertCuePoint(LssClient client, String sessionId, String callback,
                               Map<String, String> arguments) {
        client.insertCuePoint(sessionId, callback, arguments);
    }

    public static void getSessionSourceInfo(LssClient client, String sessionId) {
        GetSessionSourceInfoResponse resp = client.getSessionSourceInfo(sessionId);
        System.out.println(resp.toString());
    }

    public static void stopRecording(LssClient client, String sessionId) {
        client.stopRecording(sessionId);
    }

}
