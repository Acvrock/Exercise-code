package conditional;

/**
 * Created by moon on 16/10/2016.
 *
 * @Description:
 */
public class MacOSListService implements Listservice {
    @Override
    public String showListCmd() {
        return "ls -l";
    }
}
