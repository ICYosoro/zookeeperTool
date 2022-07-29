package sumscope.idc;

import lombok.extern.slf4j.Slf4j;
import sumscope.idc.util.CheckZkUtil;
import sumscope.idc.util.ReadFileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> nodeList = ReadFileUtil.readNodeFile("./ZkNode.ini");
        CheckZkUtil.checkZk(nodeList);
    }
}
