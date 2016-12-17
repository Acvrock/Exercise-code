package com.acvrock.s1;

/**
 * Created by moon on 17/12/2016.
 *
 * @Description:
 */
public class UpperCaseCreator extends Decorator {

    public UpperCaseCreator() {
    }

    public UpperCaseCreator(ICreator creator) {
        super(creator);
    }

    @Override
    public String handleContent(String in) {
        if (null != component) in = component.handleContent(in);
        return in +  "->>已经进行大写转换";
    }
}
