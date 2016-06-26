import com.baidubce.services.lss.LssClient;
import com.baidubce.services.lss.model.GetPresetResponse;
import com.baidubce.services.lss.model.ListPresetsResponse;

/**
 * Created by moon on 6/22/16.
 *
 * @Description:
 */
public class Presets {

    /**
     * 获取视频模版
     *
     * @param client
     */
    public static void listPresets(LssClient client) {
        ListPresetsResponse resp = client.listPresets();
        System.out.println(resp.toString());
    }

    /**
     * 为视频指定使用某个模版
     *
     * @param client
     * @param name
     */
    public static void getPreset(LssClient client, String name) {
        GetPresetResponse resp = client.getPreset(name);
        System.out.println("name: " + resp.getName());
        System.out.println("description: " + resp.getDescription());
        System.out.println("createTime: " + resp.getCreateTime());
    }

    /**
     * 删除模版
     *
     * @param client
     * @param name
     */
    public static void deletePreset(LssClient client, String name) {
        client.deletePreset(name);
    }
}
