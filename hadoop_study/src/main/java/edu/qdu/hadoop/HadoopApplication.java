package edu.qdu.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HadoopApplication {
    public static void main(String[] args) throws Exception{

        //System.setProperty("hadoop_user_name","spark");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://spark01:9820");
        FileSystem fs = FileSystem.get(conf);
        Path localPath = new Path("C:/Users/ShuaiBi/Desktop/words.txt");
        Path hdfsPath = new Path("/");
        fs.copyFromLocalFile(localPath,hdfsPath);
        fs.close();

    }
}
