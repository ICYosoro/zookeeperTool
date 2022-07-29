package sumscope.idc;

import lombok.extern.slf4j.Slf4j;
import sumscope.idc.util.ReadFileUtil;

import java.util.List;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{
    public static void main( String[] args )
    {
        List<String> nodeList = ReadFileUtil.readNodeFile("C:\\Users\\RZH\\IdeaProjects\\zookeeperTool\\src\\main\\resources\\ZkNode.ini");
        log.info("1111");
    }
}
