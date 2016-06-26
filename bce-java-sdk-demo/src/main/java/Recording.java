import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.GetRecordingResponse;
import com.baidubce.services.lss.model.ListRecordingsResponse;

/**
 * Created by moon on 6/22/16.
 *
 * @Description:
 */
public class Recording {


    /**
     * 用户可以查询指定名称的录制模板
     *
     * @param client
     * @param recording
     */
    public static void getRecording(LssClient client, String recording) {
        GetRecordingResponse resp = client.getRecording(recording);
        System.out.println(resp.toString());
    }

    /**
     * 用户可以通过如下代码查询所有的录制模板列表
     *
     * @param client
     */
    public static void listRecordings(LssClient client) {
        ListRecordingsResponse resp = client.listRecordings();
        System.out.println(resp.toString());
    }

}
