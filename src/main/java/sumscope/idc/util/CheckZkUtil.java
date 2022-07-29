package sumscope.idc.util;

import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * 读取zk节点的工具类
 *
 * @author RenZhiHao
 * @version 1.0.0
 * @create 2022-07-28 15:13
 * @project zookeeperTool
 */
@Slf4j
public class CheckZkUtil {
    private CheckZkUtil() {
    }

    /**
     * 读取节点的list
     */
    private static List<String> nodeList = ImmutableList.<String>builder().add("MDTService").add("services").build();
    static String ip = "172.16.97.171";
    static String port = "2181";

    public static void checkZk(List<String> nodes) {
        if (nodes != null && !nodes.isEmpty()) {
            nodeList = nodes;
        } else {
            log.info("ZkNode file doesn't work well, now use defalut nodes [{}]", nodeList);
            System.out.println("ZkNode file doesn't work well, now use defalut nodes ".concat(nodeList.toString()));
        }
        ZooKeeper zooKeeper = getZookeeper(ip, port);
        try {
            if (zooKeeper != null) {
                for (String node : nodeList) {
                    ls("/".concat(node), zooKeeper);
                }
            }
        } catch (Exception e) {
        }

    }

    private static ZooKeeper getZookeeper(String host, String port) {
        String connectString = host.concat(":").concat(port);
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(connectString, 100000, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }

    public static void ls(String path, ZooKeeper zk) throws Exception {
        byte[] bts = zk.getData(path, false, null);
        String str = new String(bts);
        List<String> list = zk.getChildren(path, null);
        if (list == null || list.isEmpty()) {
            if (StringUtils.isNotBlank(str)) {
                System.out.println(path + ":" + str + judgeStatus(str, path));
                log.info(path + ":" + str + judgeStatus(str, path));
            }
            return;
        }
        for (String s : list) {
            if (path.equals("/")) {
                ls(path + s, zk);
            } else {
                ls(path + "/" + s, zk);
            }
        }
    }

    private static String judgeStatus(String res, String fullPath) {
        String result = "";
        if (fullPath.contains("MDTService")) {
            if (res.contains("Stat:1")) {
                result = " OK !";
            }
        }
        if ((fullPath.contains("services")) || fullPath.contains("ptrd") || fullPath.contains("dbdd")) {
            if (res.contains("\"instance_status\":\"UP\"")) {
                result = " OK !";
            }
        }
        return result;
    }
}
