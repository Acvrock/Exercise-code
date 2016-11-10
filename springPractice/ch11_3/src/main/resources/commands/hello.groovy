package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

/**
 * Created by moon on 09/11/2016. 
 * @Description:
 */
class hello {
    @Usage("Say hello")
    @Command
    def main(InvocationContext context) {
        def bootVersion = context.attributes['spring.boot.version']
        def springVersion = context.attributes['spring.version']
        return "Hello,your Spring Boot version is " + bootVersion + ",your Spring Framework version is " + springVersion
    }
}
