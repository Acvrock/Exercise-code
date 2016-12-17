package com.acvrock.s1;

/**
 * Created by moon on 18/12/2016.
 *
 * @Description:
 */
public class LowerCaseCreator extends Decorator {

    public LowerCaseCreator() {
    }

    public LowerCaseCreator(ICreator creator) {
        super(creator);
    }

    @Override
    public String handleContent(String in) {
        if (null != component) in = component.handleContent(in);
        return in + "->>已经进行小写转换";
    }
}
