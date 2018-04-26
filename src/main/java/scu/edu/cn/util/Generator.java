package scu.edu.cn.util;

import org.mybatis.generator.api.ShellRunner;

/**
 * mybatis构造器，生成dao层数据
 */
public class Generator {

        public static void main( String[] args )
        {
            args = new String[] { "-configfile", "src\\main\\resources\\generator.xml", "-overwrite" };
            ShellRunner.main(args);
        }

}
