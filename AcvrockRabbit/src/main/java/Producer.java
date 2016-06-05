/**
 * Created by moon on 16/6/5.
 *
 * The producer endpoint that writes to the queue.
 * @author syntx
 */

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Producer extends EndPoint{

    public Producer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}