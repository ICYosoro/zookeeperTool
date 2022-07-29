package sumscope.idc.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description Here
 *
 * @author RenZhiHao
 * @version 1.0.0
 * @create 2022-07-28 14:32
 * @project zookeeperTool
 */
@Slf4j
public class ReadFileUtil {

    public static List<String> readNodeFile(String filePath) {
        List<String> zkNodeList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            zkNodeList = stream.collect(Collectors.toList());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return zkNodeList;
    }
}
