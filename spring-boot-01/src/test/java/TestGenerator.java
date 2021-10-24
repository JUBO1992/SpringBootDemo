import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

/**
 * @author JUBO
 * @version 1.0.0
 * @date 2021/03/08
 */
public class TestGenerator {

    @Test
    public void testGenerator() {
        AutoGenerator autoGenerator = new AutoGenerator();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("jubo")
            .setOutputDir("D:\\Lesson&Study\\mashibing\\idea-workspace\\SpringBootDemo\\src\\main\\java")
            .setFileOverride(true)
            .setIdType(IdType.AUTO)
            .setServiceName("%sService")
            .setBaseResultMap(true)
            .setBaseColumnList(true)
            .setControllerName("%sController");

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver")
            .setUrl("jdbc:mysql://localhost:3306/spdemo?serverTimezone=UTC")
            .setUsername("root")
            .setPassword("root");

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
            .setNaming(NamingStrategy.underline_to_camel)
            .setInclude("account", "role", "permission", "account_role", "role_permission", "menu");

        // 包名配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jubo.demo.system")
            .setMapper("mapper")
            .setService("service")
            .setController("controller")
            .setEntity("bean")
            .setXml("mapper");

        autoGenerator.setGlobalConfig(globalConfig)
            .setDataSource(dataSourceConfig)
            .setStrategy(strategyConfig)
            .setPackageInfo(packageConfig);

//        autoGenerator.execute();
    }
}
