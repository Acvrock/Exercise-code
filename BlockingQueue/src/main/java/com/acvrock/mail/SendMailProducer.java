package com.acvrock.mail;

/**
 * Created by moon on 25/06/2017.
 *
 * @Description:
 */
public class SendMailProducer {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++)
            SendMailHandler.send("发送内容" + i, i);

        SendMailHandler.finished();
    }
}
