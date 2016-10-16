package conditional;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
public class LinuxListService implements Listservice{
    @Override
    public String showListCmd() {
        return "ll";
    }
}
