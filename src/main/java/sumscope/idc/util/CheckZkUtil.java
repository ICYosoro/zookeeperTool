package sumscope.idc.util;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取zk节点的工具类
 *
 * @author RenZhiHao
 * @version 1.0.0
 * @create 2022-07-28 15:13
 * @project zookeeperTool
 */
public class CheckZkUtil {
    List<String> nodeList = ImmutableList.<String>builder().add("MDTService").add("dbdd").build();
    String ip = "127.0.0.1";
    String host = "2181";
}
